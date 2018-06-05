package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
public class Sales {

	@Id
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="location_id")
	private Product location;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="time_id")
	private Product time;
	
	@Column(name = "dollars")
	private BigDecimal dollars;
	
	@Column(name = "create_at")
    private Date create_at;
    
	@Column(name = "modified_at")
    private Date modified_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getLocation() {
		return location;
	}

	public void setLocation(Product location) {
		this.location = location;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getTime() {
		return time;
	}

	public void setTime(Product time) {
		this.time = time;
	}

	public BigDecimal getDollars() {
		return dollars;
	}

	public void setDollars(BigDecimal dollars) {
		this.dollars = dollars;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}
	
}
