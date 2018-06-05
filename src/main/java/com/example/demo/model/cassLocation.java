package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("location")
public class cassLocation {
	
	@PrimaryKey
	@Column("location_id")
    private UUID location_id;

	@Column("city")
    private String city;

	@Column("country")
    private String country;
    
	@Column("create_at")
    private Date create_at;
    
	@Column("modified_at")
    private Date modified_at;
	
	public cassLocation() {
		
	}
	
	public cassLocation(UUID uuid, String city, String country) {
		this.location_id=uuid;
		this.city=city;
		this.country=country;
	}
	@Override
	public String toString() {
		String a="";
		a+=location_id;
		if(modified_at!=null) {
		a+=modified_at.toString();}
		return a;
	}

	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
