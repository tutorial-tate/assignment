package com.learning.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.subscription.model.Plan;
import com.learning.subscription.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	PlanRepository planRepository;

	public List<Plan> getPlanList() {
		return planRepository.findAll();
	}

	public Plan getPlanbyID(Long Id) {
		return planRepository.getById(Id);
	}

}
