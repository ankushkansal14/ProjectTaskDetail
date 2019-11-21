package com.ibm.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.project.bean.Tasks;
import com.ibm.project.repo.TaskDetailsRepo;

@Service

public class TaskDetailsServices {
	
	@Autowired
	TaskDetailsRepo repo;

	public Iterable<Tasks> getAllTasks() {
		return repo.findAll();
		
	}

	public void addTask(Tasks task) {
		repo.save(task);
		
	}

	public Iterable<Tasks> getTaskByProjectName(String projectName) {
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
