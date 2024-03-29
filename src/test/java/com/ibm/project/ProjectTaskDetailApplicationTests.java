package com.ibm.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.project.bean.Tasks;
import com.ibm.project.service.TaskDetailsServices;

@SpringBootTest
class ProjectTaskDetailApplicationTests {

	@Autowired
	TaskDetailsServices service;


	
	@Test
	void testTask() {
		Tasks task=new Tasks("Billing System","task67","Jaspreet Bhatti","Just to work with code",
				"2019-11-27","2019-11-28","Complete",104);
		Iterable<Tasks> taska=service.getTaskByProjectName("Billing System");
		Iterator t1=taska.iterator();
		Tasks t2=null;
		while(t1.hasNext()) {
			t2=(Tasks) t1.next();
			break;
			
		}
	
		assertThat(task).isEqualToComparingFieldByField(t2);
		
		
	}
//	@Test
//	void testTask2() {
//		Tasks task=new Tasks("Music System","play music","Rupinder Singh","Just to play music",
//				"2019-08-17","2019-11-29","Completed",86);
//		Iterable<Tasks> taska=service.getTaskByProjectName("Music System");
//		Iterator t1=taska.iterator();
//		Tasks t2=null;
//		while(t1.hasNext()) {
//			t2=(Tasks) t1.next();
//			break;
//			
//		}
//	
//		assertThat(task).isEqualToComparingFieldByField(t2);
//		
//		
//	}
}
