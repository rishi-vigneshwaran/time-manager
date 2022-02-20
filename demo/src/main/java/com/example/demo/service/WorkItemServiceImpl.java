
package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.model.Response;
import com.example.demo.model.WorkItem;
import com.example.demo.repository.WorkItemRepository;

@Service
public class WorkItemServiceImpl implements WorkItemService{

	static Logger log = Logger.getLogger(WorkItemServiceImpl.class.getName());
	
	private WorkItemRepository repository;
	
	public WorkItemServiceImpl(WorkItemRepository repository) {
        this.repository = repository;
    }
	
	public Response getAllItems()
	{

		Response response =new Response();		
		List<WorkItem> list = null;
		
		list = repository.findAll();
		if(list != null)
		{
			response.setCode(HttpStatus.FOUND);
			response.setMessage("Data found");
			response.setObject(list);
		}
		else
		{
			response.setCode(HttpStatus.NOT_FOUND);
			response.setMessage("Data not found");
		}
		return response;
	}
	
	public Response saveItem(WorkItem workItem)
	{
		Response response =new Response();
		
		try {
			WorkItem status = repository.save(workItem);
			response.setMessage("Data successfully saved");
			response.setCode(HttpStatus.CREATED);
			response.setObject(status);
			log.info("Inside save block...");
			
		}catch(Exception e)
		{
			log.severe("Error reached... : "+e.getMessage());
			response.setMessage(e.getMessage());
			response.setCode(HttpStatus.CONFLICT);
		}
		
		return response;
	}
	
	public Response findItem(String code) {		
		Response response =new Response();
		
		WorkItem workItem = null;
		log.info("Fetching from database...");		
		workItem = repository.findItemByCode(code);
		if(workItem != null)
		{
			response.setCode(HttpStatus.FOUND);
			response.setObject(workItem);
			response.setMessage("Data found");
		}
		else {
			response.setCode(HttpStatus.NOT_FOUND);
			response.setMessage("Data not found");
		}
		return response;
	}
}
