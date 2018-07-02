package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "stakeholders")
public class Stakeholder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String post;
	
	@NotEmpty
	private String country;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String StakeRole;

}
