package com.axis.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="currency")
public class Currency {
	
//    private int id;
//	
//	@Indexed(unique = true)
	@Id
	private int id;
//	@JsonFormat(pattern = ("dd/MM/yyyy")

	@Indexed(unique = true)
	@JsonFormat(pattern = ("dd/MM/yyyy"))
	private LocalDate date;
	private long currency;
	private String currencyType;
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Currency( LocalDate date, long currency,String currencyType,int id) {
		super();
		this.date = date;
		this.currency = currency;
		this.currencyType=currencyType;
		this.id=id;
	}
	
	public Currency(long currency,String currencyType) {
		super();
		this.currency = currency;
		this.currencyType=currencyType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public Currency(LocalDate date) {
		super();
		this.date = date;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getCurrency() {
		return currency;
	}
	public void setCurrency(long currency) {
		this.currency = currency;
	}
	
	

}
