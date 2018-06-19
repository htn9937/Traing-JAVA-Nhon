package com.example.demo.model.cassandraEntity;

import java.math.BigDecimal;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class CassSales {
	@PrimaryKey
	@Column("id")
	private int id;
	
	@Column("location_id")
	private UUID location_id;
	
	@Column("product_id")
	private UUID product_id;
	
	@Column("time_id")
	private UUID time_id;
	
	@Column("dollars")
	private BigDecimal dollars;
	
	@Column("create_at")
    private DateTime create_at;
    
	@Column("modified_at")
    private DateTime modified_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	public BigDecimal getDollars() {
		return dollars;
	}

	public void setDollars(BigDecimal dollars) {
		this.dollars = dollars;
	}

	public DateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(DateTime create_at) {
		this.create_at = create_at;
	}

	public DateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(DateTime modified_at) {
		this.modified_at = modified_at;
	}
}
