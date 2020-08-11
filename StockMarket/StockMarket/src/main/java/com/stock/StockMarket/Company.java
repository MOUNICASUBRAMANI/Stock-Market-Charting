package com.stock.StockMarket;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="company")
public class Company {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(name="compname") 
  private String compname;
  
  @Column(name="turnover")
  private String turnover;
  
  @Column(name="CEO")
  private String CEO;
  
  @Column(name="board_of_dir")
  private String board_of_dir ;
  
  @Column(name="stockexchages")
  private String stockexchange;
  
  @Column(name="sector")
  private String sector;
  
  @Column(name="writeup")
  private String writeup;
  
  @Column(name="stockcode")
  private String stockcode;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public String getStockexchange() {
	return stockexchange;
}

public void setStockexchange(String stockexchange) {
	this.stockexchange = stockexchange;
}

public String getStockcode() {
	return stockcode;
}

public void setStockcode(String stockcode) {
	this.stockcode = stockcode;
}

public String getCompname() {
	return compname;
}

public void setCompname(String compname) {
	this.compname = compname;
}

public String getTurnover() {
	return turnover;
}

public void setTurnover(String turnover) {
	this.turnover = turnover;
}

public String getCEO() {
	return CEO;
}

public void setCEO(String cEO) {
	CEO = cEO;
}

public String getBoard_of_dir() {
	return board_of_dir;
}

public void setBoard_of_dir(String board_of_dir) {
	this.board_of_dir = board_of_dir;
}


public String getSector() {
	return sector;
}

public void setSector(String sector) {
	this.sector = sector;
}

public String getWriteup() {
	return writeup;
}

public void setWriteup(String writeup) {
	this.writeup = writeup;
}


  
  
  
}