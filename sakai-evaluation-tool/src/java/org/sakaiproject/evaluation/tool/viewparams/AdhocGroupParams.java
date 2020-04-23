/**
 * Copyright 2005 Sakai Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.sakaiproject.evaluation.tool.viewparams;

import uk.org.ponder.rsf.viewstate.SimpleViewParameters;

public class AdhocGroupParams extends SimpleViewParameters {
    public Long adhocGroupId;

    // Someday we will have a system for this or type you can inherit.
    // This is basically to make the page an http helper.
    public String returnURL;

    public AdhocGroupParams() {};

    public AdhocGroupParams(String viewid, Long adhocGroupId) {
        this.viewID = viewid;
        this.adhocGroupId = adhocGroupId;
    }

    public AdhocGroupParams(String viewid, Long adhocGroupId, String returnURL) {
        this.viewID = viewid;
        this.adhocGroupId = adhocGroupId;
        this.returnURL = returnURL;
    }
}
