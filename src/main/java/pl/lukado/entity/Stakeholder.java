package pl.lukado.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne
	private StakRole stakeRole;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StakRole getStakeRole() {
		return stakeRole;
	}

	public void setStakeRole(StakRole stakeRole) {
		this.stakeRole = stakeRole;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
