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

/**
 * This is a view parameters class which defines the variables that are passed
 * from one page to another
 * 
 * @author Sakai App Builder -AZ
 */
public class TemplateItemViewParameters extends TemplateViewParameters {

  public Long templateItemId;

  public TemplateItemViewParameters() {
  }

  public TemplateItemViewParameters(String viewID, Long templateId,
      Long templateItemId) {
    this.viewID = viewID;
    this.templateId = templateId;
    this.templateItemId = templateItemId;
  }

}
