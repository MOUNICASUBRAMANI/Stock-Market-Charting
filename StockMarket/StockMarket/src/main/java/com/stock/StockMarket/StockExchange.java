package com.stock.StockMarket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="stock_exchange")
public class StockExchange {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(name="stock_exchange")
  private String stock_exchange;
  
  @Column(name="brief")
  private String brief;
  
  @Column(name="address")
  private String address;
  
  @Column(name="remarks")
  private String remarks;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getStock_exchange() {
	return stock_exchange;
}

public void setStock_exchange(String stock_exchange) {
	this.stock_exchange = stock_exchange;
}

public String getBrief() {
	return brief;
}

public void setBrief(String brief) {
	this.brief = brief;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}
  
  
  
}