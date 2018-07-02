package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	
	private long id;
	private String roleName;

}
