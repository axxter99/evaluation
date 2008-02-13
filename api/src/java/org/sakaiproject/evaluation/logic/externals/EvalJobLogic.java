/**
 * $Id: EvalJobLogic.java 1000 May 28, 2007 12:07:31 AM azeckoski $
 * $URL: https://source.sakaiproject.org/contrib $
 * EvalJobLogic.java - evaluation - May 28, 2007 12:07:31 AM - rwellis
 **************************************************************************
 * Copyright (c) 2008 Centre for Applied Research in Educational Technologies, University of Cambridge
 * Licensed under the Educational Community License version 1.0
 * 
 * A copy of the Educational Community License has been included in this 
 * distribution and is available at: http://www.opensource.org/licenses/ecl1.php
 *
 * Aaron Zeckoski (azeckoski@gmail.com) (aaronz@vt.edu) (aaron@caret.cam.ac.uk)
 */

package org.sakaiproject.evaluation.logic.externals;

import org.sakaiproject.evaluation.model.EvalEvaluation;
import org.sakaiproject.evaluation.model.constant.EvalConstants;

/**
 * Handle the scheduling of jobs and taking action
 * when an EvalEvaluation changes state.
 * 
 * @author rwellis
 * @author Aaron Zeckoski (aaron@caret.cam.ac.uk)
 */
public interface EvalJobLogic {

   public static String ACTION_CREATE = "Create";
   public static String ACTION_UPDATE = "Update";
   public static String ACTION_DELETE = "Delete";

   /**
    * Handle job scheduling changes when a date changed 
    * by editing and saving an Evaluation necessitates
    * rescheduling a job.</br>
    * Check the invocation dates of pending jobs for
    * current EvalEvaluation state and change job
    * start date to match EvalEvaluation date.<br/>
    * Handle job scheduling when an EvalEvaluation is created.
    * Send email notification of EvalEvaluation creation and 
    * schedule a job to make the EvalEvaluation active when the 
    * start date is reached.<br/>
    * Remove all outstanding scheduled job invocations for this evaluation
    * if the state is deleted<br/>
    * 
    * @param evaluationId the unique id for an {@link EvalEvaluation}
    * @param actionState the state constant representing the change in the evaluation, 
    * constants are {@link #ACTION_CREATE},{@link #ACTION_DELETE},{@link #ACTION_UPDATE}
    */
   public void processEvaluationStateChange(Long evaluationId, String actionState);

   /**
    * Handle sending email and starting jobs when a scheduled job 
    * calls this method. Dispatch to action(s) based on jobType.</br>
    * 
    * @param evaluationId the unique id for an {@link EvalEvaluation}
    * @param jobType the job type from {@link EvalConstants}
    */
   public void jobAction(Long evaluationId, String jobType);


}