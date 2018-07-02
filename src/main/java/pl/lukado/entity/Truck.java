package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "trucks")
public class Truck {
	
	private long id;
	
	private String plateNumber;
	
	private String carier;

}
