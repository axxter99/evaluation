/******************************************************************************
 * class EvalViewParameters.java - created by fengr@vt.edu on Oct 23, 2006
 * 
 * Copyright (c) 2007 Virginia Polytechnic Institute and State University
 * Licensed under the Educational Community License version 1.0
 * 
 * A copy of the Educational Community License has been included in this 
 * distribution and is available at: http://www.opensource.org/licenses/ecl1.php
 * 
 * Contributors:
 * Rui Feng (fengr@vt.edu)
 * Kapil Ahuja (kahuja@vt.edu)
 *****************************************************************************/
package org.sakaiproject.evaluation.tool.params;

import uk.org.ponder.rsf.viewstate.SimpleViewParameters;

/**
 * This is a view parameters class which defines the variables that are
 * passed from one page to another
 * @author Sakai App Builder -AZ
 */
public class EvalViewParameters extends SimpleViewParameters {
	
	public Long templateId; 
	public String originalPage;
	
	public EvalViewParameters() {
	}

	public EvalViewParameters(String viewID, Long templateId, String originalPage) {
		this.viewID = viewID;
		this.templateId = templateId;
		this.originalPage = originalPage;
	}

// RSF 0.7 no longer requires this to be declared (need to build from 2671+)
//	public String getParseSpec() {
//		// include a comma delimited list of the public properties in this class
//		return super.getParseSpec() + ",templateId,originalPage";
//	}
}
