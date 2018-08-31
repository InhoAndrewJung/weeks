package com.weeks.routine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weeks.routine.vo.Routine;

public interface RoutineReposiroty extends JpaRepository<Routine, Long>{

}
