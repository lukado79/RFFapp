package pl.lukado.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "addresses")

								//Not using on this stage of app development//
public class Address {
	
	private long id;
	
	private String name;
	
	private String street;
	
	private String city;
	
	private String post;
	
	private String country;

}
