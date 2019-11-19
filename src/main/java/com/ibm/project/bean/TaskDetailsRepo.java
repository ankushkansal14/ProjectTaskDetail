package com.ibm.project.bean;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface TaskDetailsRepo extends CrudRepository<Tasks, Integer> {

	Iterable<Tasks> findByProjectName(String projectName);

	@Modifying
	@Transactional
	@Query(value = "delete from tasks where task_owner= :taskOwner", nativeQuery = true)
	void deleteTaskWithTaskOwner(@Param(value = "taskOwner") String taskOwner);

	@Modifying
	@Transactional
	@Query(value = "update tasks set task_name = :taskName,task_details = :taskDetails"
			+ ",end_date = :endDate WHERE task_owner = :taskOwner", nativeQuery = true)
	void updateTaskWithTaskOwner(@Param(value = "taskName") String taskName,
								@Param(value = "taskDetails") String taskDetails,
								@Param(value = "endDate") String endDate,
								@Param(value = "taskOwner") String taskOwner
								
								);

}
