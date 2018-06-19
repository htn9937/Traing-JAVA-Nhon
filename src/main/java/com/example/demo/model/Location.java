package com.example.demo.model;

//import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "location")
public class Location {
	
    @Id
	@Column(name = "location_id")
    private UUID location_id;

	@Column(name = "city")
    private String city;

	@Column(name = "country")
    private String country;

	@Column(name = "create_at")
    private DateTime create_at;
    
	@Column(name = "modified_at")
    private DateTime modified_at;
	
	public Location() {
		
	}
	
	public Location(UUID uuid) {
		this.location_id=uuid;
	}
	
	public Location(UUID uuid, String city, String country, DateTime create_at, DateTime modified_at) {
		this.location_id =uuid;
		this.city=city;
		this.country=country;
		this.modified_at=modified_at;
		this.create_at=create_at;
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
