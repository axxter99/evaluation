package org.sakaiproject.evaluation.model;

// Generated 07-Mar-2007 14:04:08 by Hibernate Tools 3.2.0.b9

import java.util.Date;

/**
 * EvalAnswer generated by hbm2java
 */
public class EvalAnswer implements java.io.Serializable {

	private Long id;

	private Date lastModified;

	private EvalTemplateItem templateItem;

	private EvalItem item;

	private EvalResponse response;

	private String text;

	private Integer numeric;

	private String associatedId;

	private String associatedType;

	public EvalAnswer() {
	}

	public EvalAnswer(Date lastModified, EvalTemplateItem templateItem, EvalResponse response) {
		this.lastModified = lastModified;
		this.templateItem = templateItem;
		this.response = response;
	}

	public EvalAnswer(Date lastModified, EvalTemplateItem templateItem, EvalItem item, EvalResponse response,
			String text, Integer numeric, String associatedId, String associatedType) {
		this.lastModified = lastModified;
		this.templateItem = templateItem;
		this.item = item;
		this.response = response;
		this.text = text;
		this.numeric = numeric;
		this.associatedId = associatedId;
		this.associatedType = associatedType;
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

	public EvalTemplateItem getTemplateItem() {
		return this.templateItem;
	}

	public void setTemplateItem(EvalTemplateItem templateItem) {
		this.templateItem = templateItem;
	}

	public EvalItem getItem() {
		return this.item;
	}

	public void setItem(EvalItem item) {
		this.item = item;
	}

	public EvalResponse getResponse() {
		return this.response;
	}

	public void setResponse(EvalResponse response) {
		this.response = response;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getNumeric() {
		return this.numeric;
	}

	public void setNumeric(Integer numeric) {
		this.numeric = numeric;
	}

	public String getAssociatedId() {
		return this.associatedId;
	}

	public void setAssociatedId(String associatedId) {
		this.associatedId = associatedId;
	}

	public String getAssociatedType() {
		return this.associatedType;
	}

	public void setAssociatedType(String associatedType) {
		this.associatedType = associatedType;
	}

}
