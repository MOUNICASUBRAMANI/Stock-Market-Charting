package com.stock.StockMarket;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="IPO")
public class IPO {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(name="comp_name")
  private String comp_name;
  
  @Column(name="stock_exchange")
  private String stock_exchange;
  
  @Column(name="price")
  private String price;
  
  @Column(name="no_of_shares")
  private String no_of_shares ;
  
  @Column(name="opendate")
  private Date opendate;
  
  @Column(name="remarks")
  private String remarks;
  
  
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getComp_name() {
	return comp_name;
}

public void setComp_name(String comp_name) {
	this.comp_name = comp_name;
}

public String getStock_exchange() {
	return stock_exchange;
}

public void setStock_exchange(String stock_exchange) {
	this.stock_exchange = stock_exchange;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getNo_of_shares() {
	return no_of_shares;
}

public void setNo_of_shares(String no_of_shares) {
	this.no_of_shares = no_of_shares;
}

public Date getOpendate() {
	return opendate;
}

public void setOpendate(Date opendate) {
	this.opendate = opendate;
}

public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}


  
  
  
  
}