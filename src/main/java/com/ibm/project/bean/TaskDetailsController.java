package com.ibm.project.bean;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TaskDetailsController {
	
	@Autowired
	TaskDetailsServices services;
	
	@RequestMapping("/tasks")
	Iterable<Tasks> getAllTasks(){
		return services.getAllTasks();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/tasks")
	void addTask(@RequestBody Tasks task) {
		task.toString();
		services.addTask(task);
	}

	
	@RequestMapping("/tasks/{projectName}")
	Iterable<Tasks> getTaskByProjectName(@PathVariable String projectName){
		return services.getTaskByProjectName(projectName);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/{taskOwner}")
	void updateTaskWithTaskOwner(@RequestBody Tasks task,@PathVariable String taskOwner) {
		
		services.updateTaskWithTaskOwner(task,taskOwner);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/tasks/{taskOwner}")
	void deleteTaskWithTaskOwner(@PathVariable String taskOwner) {
		services.deleteTaskWithTaskOwner(taskOwner);
	}
	
}
