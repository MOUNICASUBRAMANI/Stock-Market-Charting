package com.stock.StockMarket;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity 
@Table(name="user")
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="password")
  private String password;
  
  @Column(name="user_type")
  private String user_type;
  
  @Column(name="email")
  private String email;
  
  @Column(name="mobile_no")
  private String mobile_no;
  
  @Column(name="confirmed")
  private boolean confirmed;
  
  

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
	return password;
}

  public void setPassword(String password) {
	this.password = password;
}

  public String getUser_type() {	
	  return user_type;
}

 public void setUser_type(String user_type) {
	this.user_type = user_type;
}

  public String getMobile_no() {
	return mobile_no;
}

  public void setMobile_no(String mobile_no) {
	this.mobile_no = mobile_no;
}

//  public boolean isConfirmed() {
//	return confirmed;
//}
//
//  public void setConfirmed(boolean confirmed) {
//	this.confirmed = confirmed;
//}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}