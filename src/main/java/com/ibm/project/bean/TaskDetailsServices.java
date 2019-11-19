package com.ibm.project.bean;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TaskDetailsServices {
	
	@Autowired
	TaskDetailsRepo repo;

	Iterable<Tasks> getAllTasks() {
		return repo.findAll();
		
	}

	public void addTask(Tasks task) {
		repo.save(task);
		
	}

	Iterable<Tasks> getTaskByProjectName(String projectName) {
		return repo.findByProjectName(projectName);
		
	}

	public void updateTaskWithTaskOwner(Tasks tasks,String taskOwner) {
		String taskName=tasks.getTaskName();
		String taskDetails=tasks.getTaskDetails();
		String endDate=tasks.getEndDate();
		 repo.updateTaskWithTaskOwner(taskName,taskDetails,endDate,taskOwner);
		
	}

	public void deleteTaskWithTaskOwner(String taskOwner) {
		repo.deleteTaskWithTaskOwner(taskOwner);
		
	}

}
