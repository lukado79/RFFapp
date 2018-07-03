package pl.lukado.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Size(min = 3, max = 60)
	@Column(name = "Load Place")
	private String LoadComp;

	@NotEmpty
	@Column(name = "Load Street")
	@Size(min = 3, max = 60)
	private String LoadStreet;

	@NotEmpty
	@Column(name = "Load Post Code")
	@Size(min = 3, max = 8)
	private String LoadPost;

	@NotEmpty
	@Column(name = "Load City")
	@Size(min = 3, max = 60)
	private String LoadCity;

	@NotEmpty
	@Column(name = "Load Country")
	@Size(min = 3, max = 60)
	private String LoadCountry;

	@NotNull
	@Column(name = "Loading Date")
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date LoadDate;

	@NotEmpty
	@Column(name = "Unload Place")
	@Size(min = 3, max = 60)
	private String UnloadComp;

	@NotEmpty
	@Column(name = "Unload Street")
	@Size(min = 3, max = 60)
	private String UnloadStreet;

	@NotEmpty
	@Column(name = "Unload Post Code")
	@Size(min = 3, max = 8)
	private String UnloadPost;

	@NotEmpty
	@Column(name = "Unload City")
	@Size(min = 3, max = 60)
	private String UnloadCity;

	@NotEmpty
	@Column(name = "Unload Country")
	@Size(min = 3, max = 60)
	private String UnloadCountry;

	@NotNull
	@Column(name = "Unloading Date")
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date UnloadDate;

	@NotEmpty
	private String Client;

	@NotEmpty
	private String Carier;

	@NotEmpty
	private String Truck;
	
	@OneToOne
	@JoinColumn(name = "status_id")
	@NotEmpty
	private OrderStatus Status;

	@NotEmpty
	@Size(min = 3, max = 300)
	private String Remarks;

	@NotNull
	@Column(name = "Client Price", scale = 2)
	private Double ClientPrice;

	@NotNull
	@Column(name = "Rate", scale = 2)
	private Double CarierPrice;

	@NotEmpty
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date Created = new Date();
	
	@ManyToOne
	private User user;

}
