package com.example.demo.model.cassandraEntity;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class CassProduct {
	
	@PrimaryKey
	@Column("product_id")
    private UUID product_id;

	@Column("class")
    private String clazz;
	
	@Column("investory")
    private String investory;
    
	@Column("item")
    private int item;
	
	@Column("create_at")
    private DateTime create_at;
    
	@Column("modified_at")
    private DateTime modified_at;

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
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

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
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
