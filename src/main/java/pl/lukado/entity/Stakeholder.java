package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "stakeholders")
public class Stakeholder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Size(min = 3, max = 40)
	private String name;
	
	@NotEmpty
	@Size(min = 2, max = 60)
	private String street;
	
	@NotEmpty
	@Size(min = 3, max = 60)
	private String city;
	
	@NotEmpty
	@Size(min = 3, max = 8)
	private String post;
	
	@NotEmpty
	@Size(min = 3, max = 40)
	private String country;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String StakeRole;

}
