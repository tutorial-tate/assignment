package com.learning.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.subscription.model.Plan;
import com.learning.subscription.service.PlanService;

@Controller
public class PlanController {
	@Autowired
	PlanService planService;
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getAllPlans()
	{
		List<Plan> list=planService.getPlanList();
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/plan")
	public ResponseEntity<Plan> getById(@RequestParam long id)
	{
		
		return new ResponseEntity(planService.getPlanbyID(null), HttpStatus.OK);
		
	}
	

}
