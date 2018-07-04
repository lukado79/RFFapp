package pl.lukado.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "Load_Place")
	private String loadComp;

	@NotEmpty
	@Column(name = "Load_Street")
	@Size(min = 3, max = 60)
	private String LoadStreet;

	@NotEmpty
	@Column(name = "Load_Post_Code")
	@Size(min = 3, max = 8)
	private String loadPost;

	@NotEmpty
	@Column(name = "Load_City")
	@Size(min = 3, max = 60)
	private String loadCity;

	@NotEmpty
	@Column(name = "Load_Country")
	@Size(min = 3, max = 60)
	private String loadCountry;

	@NotNull
	@Column(name = "Loading_Date")
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date loadDate;

	@NotEmpty
	@Column(name = "Unload_Place")
	@Size(min = 3, max = 60)
	private String unloadComp;

	@NotEmpty
	@Column(name = "Unload_Street")
	@Size(min = 3, max = 60)
	private String UnloadStreet;

	@NotEmpty
	@Column(name = "Unload_Post_Code")
	@Size(min = 3, max = 8)
	private String unloadPost;

	@NotEmpty
	@Column(name = "Unload_City")
	@Size(min = 3, max = 60)
	private String unloadCity;

	@NotEmpty
	@Column(name = "Unload_Country")
	@Size(min = 3, max = 60)
	private String unloadCountry;

	@NotNull
	@Column(name = "Unloading_Date")
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date unloadDate;

	@OneToOne
	@NotEmpty
	private Stakeholder carier;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotEmpty
	private List<Truck> truck = new ArrayList<>();

	@OneToOne
	@NotEmpty
	private OrderStatus status;

	@NotEmpty
	@Size(min = 3, max = 300)
	private String remarks;

	@NotNull
	@Column(name = "Client_Price", scale = 2)
	private Double clientPrice;

	@NotNull
	@Column(name = "Rate", scale = 2)
	private Double carierPrice;

	@NotEmpty
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date created = new Date();

	@ManyToOne
	private User user;

	@ManyToOne
	private Stakeholder client;

}
