package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "new_emps")

public class Employee extends BaseEntity {
	
	@Column(name = "FirstName",length = 30)
	private String firstName;
	@Column(name = "LastName",length = 30)
	private String lastName;
	@Column(name="Email",unique = true)
	private String email;
	
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
}
