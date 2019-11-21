package com.ibm.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.project.bean.Tasks;
import com.ibm.project.service.TaskDetailsServices;

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
		services.addTask(task);
	}

	
	@RequestMapping("/tasks/{projectName}")
	Iterable<Tasks> getTaskByProjectName(@PathVariable String projectName){
		return services.getTaskByProjectName(projectName);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/{taskTitle}")
	void updateTaskWithTaskTitle(@RequestBody Tasks task,@PathVariable String taskTitle) {
		
		services.updateTaskWithTaskOwner(task,taskTitle);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/status/{taskTitle}")
	void updateTaskStatus(@RequestBody Tasks task,@PathVariable String taskTitle) {
		
		services.updateTaskStatus(task,taskTitle);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/tasks/{taskTitle}")
	void deleteTaskWithTaskOwner(@PathVariable String taskTitle) {
		services.deleteTaskWithTaskOwner(taskTitle);
	}
	
}