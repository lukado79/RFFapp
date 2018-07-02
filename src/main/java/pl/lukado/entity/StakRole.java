package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stakeholder_role")
public class StakRole {

	private long id;
	private String roleName;

}
