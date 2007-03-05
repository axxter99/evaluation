package org.sakaiproject.evaluation.model;

// Generated 05-Mar-2007 17:49:20 by Hibernate Tools 3.2.0.b9

import java.util.Date;

/**
 * EvalTemplateItem generated by hbm2java
 */
public class EvalTemplateItem implements java.io.Serializable {

	private Long id;

	private Date lastModified;

	private String owner;

	private EvalTemplate template;

	private EvalItem item;

	private Integer displayOrder;

	private String itemCategory;

	private Integer displayRows;

	private String scaleDisplaySetting;

	private Boolean usesNA;

	private Boolean blockParent;

	private Long blockId;

	public EvalTemplateItem() {
	}

	public EvalTemplateItem(Date lastModified, String owner,
			EvalTemplate template, EvalItem item, Integer displayOrder,
			String itemCategory) {
		this.lastModified = lastModified;
		this.owner = owner;
		this.template = template;
		this.item = item;
		this.displayOrder = displayOrder;
		this.itemCategory = itemCategory;
	}

	public EvalTemplateItem(Date lastModified, String owner,
			EvalTemplate template, EvalItem item, Integer displayOrder,
			String itemCategory, Integer displayRows,
			String scaleDisplaySetting, Boolean usesNA, Boolean blockParent,
			Long blockId) {
		this.lastModified = lastModified;
		this.owner = owner;
		this.template = template;
		this.item = item;
		this.displayOrder = displayOrder;
		this.itemCategory = itemCategory;
		this.displayRows = displayRows;
		this.scaleDisplaySetting = scaleDisplaySetting;
		this.usesNA = usesNA;
		this.blockParent = blockParent;
		this.blockId = blockId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EvalTemplate getTemplate() {
		return this.template;
	}

	public void setTemplate(EvalTemplate template) {
		this.template = template;
	}

	public EvalItem getItem() {
		return this.item;
	}

	public void setItem(EvalItem item) {
		this.item = item;
	}

	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getItemCategory() {
		return this.itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Integer getDisplayRows() {
		return this.displayRows;
	}

	public void setDisplayRows(Integer displayRows) {
		this.displayRows = displayRows;
	}

	public String getScaleDisplaySetting() {
		return this.scaleDisplaySetting;
	}

	public void setScaleDisplaySetting(String scaleDisplaySetting) {
		this.scaleDisplaySetting = scaleDisplaySetting;
	}

	public Boolean getUsesNA() {
		return this.usesNA;
	}

	public void setUsesNA(Boolean usesNA) {
		this.usesNA = usesNA;
	}

	public Boolean getBlockParent() {
		return this.blockParent;
	}

	public void setBlockParent(Boolean blockParent) {
		this.blockParent = blockParent;
	}

	public Long getBlockId() {
		return this.blockId;
	}

	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

}
