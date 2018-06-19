package com.example.demo.model.cassandraEntity;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("location")
public class CassLocation {
	
	@PrimaryKey
	@Column("location_id")
    private UUID location_id;

	@Column("city")
    private String city;

	@Column("country")
    private String country;
    
	@Column("create_at")
    private DateTime create_at;
    
	@Column("modified_at")
    private DateTime modified_at;
	
	public CassLocation() {
		
	}
	
	public CassLocation(UUID uuid, String city, String country) {
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
