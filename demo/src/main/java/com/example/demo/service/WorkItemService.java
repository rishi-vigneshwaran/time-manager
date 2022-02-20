package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Response;
import com.example.demo.model.WorkItem;

public interface WorkItemService {
	
	public Response getAllItems();
	
	public Response saveItem(WorkItem workitem);
	
	public Response findItem(String code);

}
