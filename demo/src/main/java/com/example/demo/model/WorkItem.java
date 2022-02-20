package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Work Item")
public class WorkItem {

	@Id
	private String id;
	private String code;
	private int severity;
	private String category;
	private String description;
	private boolean productivity;
	
	public WorkItem(String id, String code, int severity, String category, String description, boolean productivity) {
		super();
		this.id = id;
		this.code = code;
		this.severity = severity;
		this.category = category;
		this.description = description;
		this.productivity = productivity;
	}
	

	public WorkItem() {
		super();

	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isProductivity() {
		return productivity;
	}

	public void setProductivity(boolean productivity) {
		this.productivity = productivity;
	}

	@Override
	public String toString() {
		return "WorkItem [id=" + id + ", code=" + code + ", severity=" + severity + ", category=" + category
				+ ", description=" + description + ", productivity=" + productivity + "]";
	}
		
	
}
