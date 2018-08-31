package com.weeks.routine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.routine.repository.RoutineReposiroty;
import com.weeks.routine.vo.Routine;
import com.weeks.util.payload.APIResponse;

@RestController
public class RoutineController {
	@Autowired
	RoutineReposiroty routineReposiroty;
	
	public APIResponse addRoutine(Routine routine) {
		if(routineReposiroty.saveAndFlush(routine) == null) return new APIResponse(false, "add routine failed");
		return new APIResponse(true, "add routine success");
	}
	public List<Routine> getAllRoutine() {
		return null;
	}
	public APIResponse updateRoutine() {
		return null;
	}
	public APIResponse deleteRouinte() {
		return null;
	}
}
