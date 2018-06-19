package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sales")
public class Sales {

	@Id
	@Column(name = "sales_id")
	private UUID sales_id;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="location_id" )
	private Location location;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="time_id")
	private Time time;

	@Column(insertable=false, updatable=false)
	private UUID product_id;
	@Column(insertable=false, updatable=false)
	private UUID location_id;
	@Column(insertable=false, updatable=false)
	private UUID time_id;
	
	@Column(name = "dollars")
	private BigDecimal dollars;
	
	@Column(name = "create_at")
    private Date create_at;
    
	@Column(name = "modified_at")
    private Date modified_at;

	public UUID getId() {
		return sales_id;
	}

	public void setId(UUID id) {
		this.sales_id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
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

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}
}
