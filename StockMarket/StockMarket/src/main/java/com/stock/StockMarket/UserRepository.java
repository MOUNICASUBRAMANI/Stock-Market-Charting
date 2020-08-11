package com.stock.StockMarket;

import com.stock.StockMarket.User;


import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT name,password FROM user WHERE user_type=?1" , nativeQuery = true)
	  List<String> findByuser_type(String user_type);
	
	/*@Query(value = "SELECT confirmed FROM user WHERE email=?1 and password=?2 and user_type='admin'" , nativeQuery = true)
	  Boolean check(String email,String password);*/


	User getByEmailAndPassword(String email, String password);
	User getByEmail(String email);
	
	
}
