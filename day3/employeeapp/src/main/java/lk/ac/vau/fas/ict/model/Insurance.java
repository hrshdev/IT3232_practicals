package lk.ac.vau.fas.ict.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Insurance {
	@Id
	private String insuranceId;
	private String Benefee;
	@OneToOne
	private Employee employee;
}
