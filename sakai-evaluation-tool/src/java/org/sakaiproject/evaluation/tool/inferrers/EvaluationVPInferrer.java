/**
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://opensource.org/licenses/ecl2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sakaiproject.evaluation.tool.inferrers;

import java.util.List;
import java.util.Map;

import org.sakaiproject.entitybroker.EntityReference;
import org.sakaiproject.evaluation.constant.EvalConstants;
import org.sakaiproject.evaluation.logic.EvalCommonLogic;
import org.sakaiproject.evaluation.logic.EvalEvaluationService;
import org.sakaiproject.evaluation.logic.entity.AssignGroupEntityProvider;
import org.sakaiproject.evaluation.logic.entity.EvaluationEntityProvider;
import org.sakaiproject.evaluation.logic.model.EvalGroup;
import org.sakaiproject.evaluation.model.EvalAssignGroup;
import org.sakaiproject.evaluation.model.EvalEvaluation;
import org.sakaiproject.evaluation.tool.producers.PreviewEvalProducer;
import org.sakaiproject.evaluation.tool.producers.TakeEvalProducer;
import org.sakaiproject.evaluation.tool.viewparams.EvalViewParameters;
import org.sakaiproject.evaluation.tool.wrapper.ModelAccessWrapperInvoker;
import org.sakaiproject.evaluation.utils.EvalUtils;
import org.sakaiproject.rsf.entitybroker.EntityViewParamsInferrer;

import lombok.extern.slf4j.Slf4j;
import uk.org.ponder.rsf.viewstate.ViewParameters;

/**
 * Handles the redirection of incoming evaluation and assign group entity URLs to the proper views with the proper view params added
 * 
 * @author Aaron Zeckoski (azeckoski @ unicon.net)
 */
@Slf4j
public class EvaluationVPInferrer implements EntityViewParamsInferrer {


    private EvalCommonLogic commonLogic;
    public void setCommonLogic(EvalCommonLogic commonLogic) {
        this.commonLogic = commonLogic;
    }

    private EvalEvaluationService evaluationService;
    public void setEvaluationService(EvalEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    private ModelAccessWrapperInvoker wrapperInvoker;
    public void setWrapperInvoker(ModelAccessWrapperInvoker wrapperInvoker) {
        this.wrapperInvoker = wrapperInvoker;
    }


    public void init() {
        log.debug("VP init");
    }

    /* (non-Javadoc)
     * @see org.sakaiproject.rsf.entitybroker.EntityViewParamsInferrer#getHandledPrefixes()
     */
    public String[] getHandledPrefixes() {
        return new String[] {
                EvaluationEntityProvider.ENTITY_PREFIX,
                AssignGroupEntityProvider.ENTITY_PREFIX
        };
    }

    /* (non-Javadoc)
     * @see org.sakaiproject.rsf.entitybroker.EntityViewParamsInferrer#inferDefaultViewParameters(java.lang.String)
     */
    public ViewParameters inferDefaultViewParameters(String reference) {
        //log.warn("Note: Routing user to view based on reference: " + reference);
        final String ref = reference;
        final ViewParameters[] togo = new ViewParameters[1];
        // this is needed to provide transactional protection
        wrapperInvoker.invokeRunnable(() -> { togo [0] = inferDefaultViewParametersImpl(ref); } );
        return togo[0];
    }

    private ViewParameters inferDefaultViewParametersImpl(String reference) {
        EntityReference ref = new EntityReference(reference);
        EvalEvaluation evaluation = null;
        Long evaluationId = null;
        String evalGroupId = null;

        if (EvaluationEntityProvider.ENTITY_PREFIX.equals(ref.getPrefix())) {
            // we only know the evaluation
            evaluationId = new Long(ref.getId());
            evaluation = evaluationService.getEvaluationById(evaluationId);
        } else if (AssignGroupEntityProvider.ENTITY_PREFIX.equals(ref.getPrefix())) {
            // we know the evaluation and the group
            Long AssignGroupId = new Long(ref.getId());
            EvalAssignGroup assignGroup = evaluationService.getAssignGroupById(AssignGroupId);
            evalGroupId = assignGroup.getEvalGroupId();
            evaluationId = assignGroup.getEvaluation().getId();
            evaluation = evaluationService.getEvaluationById(evaluationId);
        } else {
            throw new IllegalArgumentException("Invalid reference (don't know how to handle): "+ref);
        }

        if ( EvalConstants.EVALUATION_AUTHCONTROL_NONE.equals(evaluation.getAuthControl()) ) {
            // anonymous evaluation URLs ALWAYS go to the take_eval page
            log.debug("User taking anonymous evaluation: " + evaluationId + " for group: " + evalGroupId);
            EvalViewParameters vp = new EvalViewParameters(TakeEvalProducer.VIEW_ID, evaluationId, evalGroupId);
            vp.external = true;
            return vp;
        } else {
            // authenticated evaluation URLs depend on the state of the evaluation and the users permissions
            String currentUserId = commonLogic.getCurrentUserId();
            boolean userAdmin = commonLogic.isUserAdmin(currentUserId);
            log.debug("Note: User ("+currentUserId+") accessing authenticated evaluation: " + evaluationId + " in state ("+EvalUtils.getEvaluationState(evaluation, false)+") for group: " + evalGroupId);

            // eval has not started
            if ( EvalUtils.checkStateBefore(EvalUtils.getEvaluationState(evaluation, false), EvalConstants.EVALUATION_STATE_INQUEUE, true) ) {
                // go to the add instructor items view if permission
                // NOTE: the checks below are slightly expensive and should probably be reworked to use the newer participants methods
                if (evalGroupId == null) {
                    Map<Long, List<EvalAssignGroup>> m = evaluationService.getAssignGroupsForEvals(new Long[] {evaluationId}, true, null);
                    EvalGroup[] evalGroups = EvalUtils.getGroupsInCommon(
                            commonLogic.getEvalGroupsForUser(currentUserId, EvalConstants.PERM_BE_EVALUATED), 
                            m.get(evaluationId) );
                    if (evalGroups.length > 0) {
                        // if we are being evaluated in at least one group in this eval then we can add items
                        // TODO - except we do not have a view yet so go to the preview eval page 
                        EvalViewParameters vp = new EvalViewParameters(PreviewEvalProducer.VIEW_ID, evaluationId);
                        vp.external = true;
                        return vp;
                    }
                } else {
                    if (commonLogic.isUserAllowedInEvalGroup(currentUserId, EvalConstants.PERM_BE_EVALUATED, evalGroupId)) {
                        // those being evaluated get to go to add their own questions
                        // TODO - except we do not have a view yet so go to the preview eval page 
                        EvalViewParameters vp = new EvalViewParameters(PreviewEvalProducer.VIEW_ID, evaluationId);
                        vp.external = true;
                        return vp;
                    }
                }
                // otherwise just show the preview as long as the user is an admin
                if (userAdmin) {
                    EvalViewParameters vp = new EvalViewParameters(PreviewEvalProducer.VIEW_ID, evaluationId);
                    vp.external = true;
                    return vp;
                }
                // else just require auth
                throw new SecurityException("User must be authenticated to access this page");
            }

            // finally, try to go to the take evals view
            if (! commonLogic.isUserAnonymous(currentUserId) ) {
                // check perms if not anonymous
                // switched to take check first
                if ( evaluationService.canTakeEvaluation(currentUserId, evaluationId, evalGroupId) ) {
                    log.debug("User ("+currentUserId+") taking authenticated evaluation: " + evaluationId + " for group: " + evalGroupId);
                    EvalViewParameters vp = new EvalViewParameters(TakeEvalProducer.VIEW_ID, evaluationId, evalGroupId);
                    vp.external = true;
                    return vp;
                } else if (currentUserId.equals(evaluation.getOwner()) ||
                        commonLogic.isUserAllowedInEvalGroup(currentUserId, EvalConstants.PERM_BE_EVALUATED, evalGroupId)) {
                    // cannot take, but can preview
                    EvalViewParameters vp = new EvalViewParameters(PreviewEvalProducer.VIEW_ID, evaluationId);
                    vp.external = true;
                    return vp;
                } else {
                    // no longer want to show security exceptions - https://bugs.caret.cam.ac.uk/browse/CTL-1548
                    //throw new SecurityException("User ("+currentUserId+") does not have permission to take or preview this evaluation ("+evaluationId+")");
                    return new EvalViewParameters(TakeEvalProducer.VIEW_ID, evaluationId, evalGroupId);
                }
            }

            throw new SecurityException("User must be authenticated to access this page");
        }
    }
}
