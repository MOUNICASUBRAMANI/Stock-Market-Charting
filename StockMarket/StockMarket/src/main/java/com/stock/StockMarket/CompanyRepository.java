package com.stock.StockMarket;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	Company findStockcodeByCompnameAndStockexchange(String compname,String Stockexchange);
	
	Company findByCompname(String compname);

} 