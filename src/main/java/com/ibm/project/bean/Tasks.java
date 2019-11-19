package com.ibm.project.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {
	
	String projectName,taskName,taskOwner,taskDetails;
	String startDate,endDate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public Tasks() {
		
	}
	public Tasks(String projectName, String taskName, String taskOwner, String taskDetails, String startDate,
			String endDate) {
		this.projectName = projectName;
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.taskDetails = taskDetails;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskOwner() {
		return taskOwner;
	}
	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}
	public String getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Tasks [projectName=" + projectName + ", taskName=" + taskName + ", taskOwner=" + taskOwner
				+ ", taskDetails=" + taskDetails + ", startDate=" + startDate + ", endDate=" + endDate + ", id=" + id
				+ "]";
	}
	
	

}