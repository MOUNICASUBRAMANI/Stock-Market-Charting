package com.stock.StockMarket;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="stockPrice")
public class StockPrice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(name="companycode")
  private String companycode;
  
  @Column(name="stockexchage")
  private String stockexchange;
  
  @Column(name="currentprice")
  private double currentprice;
  
  @Column(name="date")
  private Date date;
  
  @Column(name="time")
  private String time;
  
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public String getCompanycode() {
	return companycode;
}

public void setCompanycode(String companycode) {
	this.companycode = companycode;
}

public String getStockexchange() {
	return stockexchange;
}

public void setStockexchange(String stockexchange) {
	this.stockexchange = stockexchange;
}

public double getCurrentprice() {
	return currentprice;
}

public void setCurrentprice(double currentprice) {
	this.currentprice = currentprice;
}

public Date getDate() {
	return date;
}

public void setDate(Date date2) {
	this.date = date2;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}


  
}
