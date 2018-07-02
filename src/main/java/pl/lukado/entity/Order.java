package pl.lukado.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	private long id;

	private String LoadComp;
	private String LoadStreet;
	private String LoadPost;
	private String LoadCity;
	private String LoadCountry;
	private Date LoadDate;
	private String UnloadComp;
	private String UnloadStreet;
	private String UnloadPost;
	private String UnloadCity;
	private String UnloadCountry;
	private Date UnloadDate;
	private String Client;
	private String Carier;
	private String Truck;
	private String Status;
	private String Remarks;
	private Double ClientPrice;
	private Double CarierPrice;
	private Date Created;
	

}
