package com.stock.StockMarket;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="sector")
public class Sector {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(name="sector_name")
  private String sector_name;
  
  @Column(name="brief")
  private String brief;
  
  public Integer getId() {
	return id;
}

 public void setId(Integer id) {
	this.id = id;
}

public String getSector_name() {
	return sector_name;
}

public void setSector_name(String sector_name) {
	this.sector_name = sector_name;
}

public String getBrief() {
	return brief;
}

public void setBrief(String brief) {
	this.brief = brief;
}


  
  
  
  
}