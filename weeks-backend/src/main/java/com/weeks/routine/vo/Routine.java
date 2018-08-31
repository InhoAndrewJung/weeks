package com.weeks.routine.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Routine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long routineId;

	private String routineLoopConddition;
	private String routineContent;
	private String routineUid;

	public Routine() {
		
	}
}
