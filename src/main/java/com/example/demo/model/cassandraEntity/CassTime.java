package com.example.demo.model.cassandraEntity;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("time")
public class CassTime {
	
	@PrimaryKey
	@Column("time_id")
    private UUID time_id;

	@Column("month")
    private int month;

	@Column("year")
    private int year;
	
	@Column("quater")
    private int quater;
    
	@Column("create_at")
    private DateTime create_at;
    
	@Column("modified_at")
    private DateTime modified_at;

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuater() {
		return quater;
	}

	public void setQuater(int quater) {
		this.quater = quater;
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
