package org.sakaiproject.evaluation.model;

// Generated Jan 3, 2007 8:04:14 AM by Hibernate Tools 3.2.0.beta6a

import java.util.Date;

/**
 * EvalEmailTemplate generated by hbm2java
 */
public class EvalEmailTemplate implements java.io.Serializable {

	// Fields    

	private Long id;

	private Date lastModified;

	private String owner;

	private String message;

	private String defaultType;

	// Constructors

	/** default constructor */
	public EvalEmailTemplate() {
	}

	/** minimal constructor */
	public EvalEmailTemplate(Date lastModified, String owner, String message) {
		this.lastModified = lastModified;
		this.owner = owner;
		this.message = message;
	}

	/** full constructor */
	public EvalEmailTemplate(Date lastModified, String owner, String message,
			String defaultType) {
		this.lastModified = lastModified;
		this.owner = owner;
		this.message = message;
		this.defaultType = defaultType;
	}

	// Property accessors
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

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDefaultType() {
		return this.defaultType;
	}

	public void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}

}
