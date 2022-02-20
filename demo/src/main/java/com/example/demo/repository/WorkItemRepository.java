package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WorkItem;

@Repository
public interface WorkItemRepository extends MongoRepository<WorkItem, String> {
	
	@Query("{'code':?0}")
	WorkItem findItemByCode(String code);
}