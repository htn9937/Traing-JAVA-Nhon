package com.example.demo.Entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
	@Column(name = "product_id")
    private UUID product_id;

	@Column(name = "item")
    private int item;

	@Column(name = "clazz")
    private String clazz;
	
	@Column(name = "investory")
    private String investory;
    
	@Column(name = "create_at")
    private DateTime create_at;
    
	@Column(name = "modified_at")
    private DateTime modified_at;

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getInvestory() {
		return investory;
	}

	public void setInvestory(String investory) {
		this.investory = investory;
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
