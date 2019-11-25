package com.ibm.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.project.bean.Tasks;
import com.ibm.project.service.TaskDetailsServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController

@Api(value = "Task Details" , description = "CONTAINS API FOR TaskDetails")

public class TaskDetailsController {
	
	@Autowired
	TaskDetailsServices services;
	
	@Autowired
	RestTemplate restTemp;
	
	@ApiOperation(value = "Get The Tasks" , notes = "hit this url to get all tasks",response = List.class)
	@RequestMapping("/tasks")
	Iterable<Tasks> getAllTasks(){
		return services.getAllTasks();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/tasks")
	void addTask(@RequestBody Tasks task) {
		services.addTask(task);
		restTemp.put("http://localhost:8787/project",task);
		restTemp.postForObject("http://localhost:8787/emp_stat", task, String.class);
	}

	
	@RequestMapping("/tasks/{projectName}")
	Iterable<Tasks> getTaskByProjectName(@PathVariable String projectName){
		return services.getTaskByProjectName(projectName);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/{taskTitle}")
	void updateTaskWithTaskTitle(@RequestBody Tasks task,@PathVariable String taskTitle) {
		
		services.updateTaskWithTaskOwner(task,taskTitle);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks")
	void updateTaskWithDeleteEmployee(@RequestBody String employeeName) {
		
		services.updateTaskWithDeleteEmployee(employeeName);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/status/{taskTitle}")
	void updateTaskStatus(@RequestBody Tasks task,@PathVariable String taskTitle) {
		
		services.updateTaskStatus(task,taskTitle);
		restTemp.put("http://localhost:8787/project/completetask", task);
		restTemp.put("http://localhost:8787/emp_stat/completetask", task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/tasks/{taskTitle}")
	void deleteTaskWithTaskOwner(@PathVariable String taskTitle) {
		String projectName=services.findProjectName(taskTitle);
		services.deleteTaskWithTaskOwner(taskTitle);
		restTemp.delete("http://localhost:8787/project/"+projectName);
	}
	
}