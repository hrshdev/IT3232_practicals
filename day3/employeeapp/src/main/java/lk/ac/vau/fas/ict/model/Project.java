package lk.ac.vau.fas.ict.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private String projId;
	private String projName;
	private long totalCost;
	@ManyToMany
	private List<Employee>employees;
}
