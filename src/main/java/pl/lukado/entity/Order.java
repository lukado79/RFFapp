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
	private String loadStreet;

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
	private String unloadStreet;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoadComp() {
		return loadComp;
	}

	public void setLoadComp(String loadComp) {
		this.loadComp = loadComp;
	}

	public String getLoadStreet() {
		return loadStreet;
	}

	public void setLoadStreet(String loadStreet) {
		this.loadStreet = loadStreet;
	}

	public String getLoadPost() {
		return loadPost;
	}

	public void setLoadPost(String loadPost) {
		this.loadPost = loadPost;
	}

	public String getLoadCity() {
		return loadCity;
	}

	public void setLoadCity(String loadCity) {
		this.loadCity = loadCity;
	}

	public String getLoadCountry() {
		return loadCountry;
	}

	public void setLoadCountry(String loadCountry) {
		this.loadCountry = loadCountry;
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getUnloadComp() {
		return unloadComp;
	}

	public void setUnloadComp(String unloadComp) {
		this.unloadComp = unloadComp;
	}

	public String getUnloadStreet() {
		return unloadStreet;
	}

	public void setUnloadStreet(String unloadStreet) {
		this.unloadStreet = unloadStreet;
	}

	public String getUnloadPost() {
		return unloadPost;
	}

	public void setUnloadPost(String unloadPost) {
		this.unloadPost = unloadPost;
	}

	public String getUnloadCity() {
		return unloadCity;
	}

	public void setUnloadCity(String unloadCity) {
		this.unloadCity = unloadCity;
	}

	public String getUnloadCountry() {
		return unloadCountry;
	}

	public void setUnloadCountry(String unloadCountry) {
		this.unloadCountry = unloadCountry;
	}

	public Date getUnloadDate() {
		return unloadDate;
	}

	public void setUnloadDate(Date unloadDate) {
		this.unloadDate = unloadDate;
	}

	public Stakeholder getCarier() {
		return carier;
	}

	public void setCarier(Stakeholder carier) {
		this.carier = carier;
	}

	public List<Truck> getTruck() {
		return truck;
	}

	public void setTruck(List<Truck> truck) {
		this.truck = truck;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getClientPrice() {
		return clientPrice;
	}

	public void setClientPrice(Double clientPrice) {
		this.clientPrice = clientPrice;
	}

	public Double getCarierPrice() {
		return carierPrice;
	}

	public void setCarierPrice(Double carierPrice) {
		this.carierPrice = carierPrice;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Stakeholder getClient() {
		return client;
	}

	public void setClient(Stakeholder client) {
		this.client = client;
	}
	
	

}
