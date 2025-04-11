package lk.ac.vau.fas.ict.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name = "dept_id")
	private String id;
	@Column(nullable = false)
	private String deptName;
	private Date eshtablished;
	@OneToMany(mappedBy = "department")
	private List<Employee>employees;
}
