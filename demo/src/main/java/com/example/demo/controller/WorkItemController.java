package com.example.demo.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Response;
import com.example.demo.model.WorkItem;
import com.example.demo.repository.WorkItemRepository;
import com.example.demo.service.WorkItemServiceImpl;


@RestController
public class WorkItemController {

	static Logger log = Logger.getLogger(WorkItemController.class.getName());      

	WorkItemServiceImpl workItemService;
	
    public WorkItemController(WorkItemServiceImpl workItemService) {
		super();
		this.workItemService = workItemService;
	}

	@GetMapping("/hello")
    public ResponseEntity<?> hello()
    {
    	return new ResponseEntity<>("Hello World!", HttpStatus.FOUND);
    }
    
    @GetMapping("/workitems")
    public ResponseEntity<?> getAllItems() {
    	log.info("Fetching work items...");
    	Response response = workItemService.getAllItems();
        return new ResponseEntity<>(response,response.getCode());
    }
    
    @PostMapping("/workitem")
    public ResponseEntity<?> saveItem(@RequestBody WorkItem workitem) {
    	log.info("Saving data into database..."+workitem);
    	Response response = workItemService.saveItem(workitem);
    	return new ResponseEntity<>(response,response.getCode());
    }
    
    @GetMapping("/workitem/{code}")
    public ResponseEntity<?> findItem(@PathVariable String code)
    {
    	log.info("Searching for task : "+code);
    	Response response = workItemService.findItem(code);
    	return new ResponseEntity<>(response,response.getCode());
    }
}
