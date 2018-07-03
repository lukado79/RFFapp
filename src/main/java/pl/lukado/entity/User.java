package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "app_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Size(min = 2, max = 40)
	private String firstName;
	@NotEmpty
	@Size(min = 2, max = 60)
	private String lastName;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min = 6)
	private String password;
	@NotBlank
	private boolean enabled;
	@NotEmpty
	private String role;

}
