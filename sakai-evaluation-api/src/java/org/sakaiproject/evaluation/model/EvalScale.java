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
package org.sakaiproject.evaluation.model;

//Generated Mar 20, 2007 10:08:13 AM by Hibernate Tools 3.2.0.beta6a

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.sakaiproject.evaluation.constant.EvalConstants;

/**
 * This represents the scales/choices for items,
 * the scales can be reused for many items if desired
 */
public class EvalScale implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // Fields    

    private Long id;

    private String eid;

    private Date lastModified;

    private String owner;

    private String title;

    private String sharing;

    private Boolean expert;

    private String expertDescription;

    private String ideal;

    private List<String> options;

    private Boolean locked;

    /**
     * Should match the constants:
     * {@link EvalConstants#SCALE_MODE_ADHOC} for scales used in MA/MC items<br/>
     * {@link EvalConstants#SCALE_MODE_SCALE} for reusable scales for scaled items
     */
    private String mode;

    /**
     * Indicates that this is a copy of an item and therefore should be hidden from views and 
     * only revealed when taking/previewing (not as part of item banks, etc.),
     * this will be the id of the persistent object it is a copy of
     */
    private Long copyOf;

    /**
     * Indicates that the object is hidden from the control views and will not be visible to the user for editing/removal
     */
    private boolean hidden = false;

    // Constructors

    /** default constructor */
    public EvalScale() {
    }

    /** 
     * minimal constructor
     * @param owner
     * @param title
     * @param mode
     * @param sharing
     * @param expert 
     */
    public EvalScale(String owner, String title, String mode, String sharing, Boolean expert) {
        this(owner, title, mode, sharing, expert, null, null, null, Boolean.FALSE);
    }

    /** 
     * full constructor
     * @param owner
     * @param title
     * @param mode
     * @param sharing
     * @param expert
     * @param expertDescription
     * @param ideal
     * @param options
     * @param locked 
     */
    public EvalScale(String owner, String title, String mode, String sharing, Boolean expert, String expertDescription, 
            String ideal, List<String> options, Boolean locked) {
        this.lastModified = new Date();
        this.owner = owner;
        this.title = title;
        this.mode = mode;
        this.sharing = sharing;
        this.expert = expert;
        this.expertDescription = expertDescription;
        this.ideal = ideal;
        this.options = options;
        this.locked = locked;
    }

    // Property accessors
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEid() {
        return this.eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSharing() {
        return this.sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    public Boolean getExpert() {
        return this.expert;
    }

    public void setExpert(Boolean expert) {
        this.expert = expert;
    }

    public String getExpertDescription() {
        return this.expertDescription;
    }

    public void setExpertDescription(String expertDescription) {
        this.expertDescription = expertDescription;
    }

    public String getIdeal() {
        return this.ideal;
    }

    public void setIdeal(String ideal) {
        this.ideal = ideal;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Boolean getLocked() {
        return this.locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Long getCopyOf() {
        return copyOf;
    }

    /**
     * Indicates that this is a copy of an item and therefore should be hidden from views and 
     * only revealed when taking/previewing (not as part of item banks, etc.),
     * this will be the id of the persistent object it is a copy of
     * @param copyOf
     */
    public void setCopyOf(Long copyOf) {
        this.copyOf = copyOf;
    }

    public String getMode() {
        return mode;
    }

    /**
     * Should match the constants:
     * {@link EvalConstants#SCALE_MODE_ADHOC} for scales used in MA/MC items<br/>
     * {@link EvalConstants#SCALE_MODE_SCALE} for reusable scales for scaled items
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }


    public boolean isHidden() {
        return hidden;
    }


    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

	public void setOptionsArray(String[] optionsArr){
		this.options = Arrays.asList(optionsArr);		
	}
	public String[] getOptionsArray() {
		return options.toArray(new String[options.size()]);
    }
}
