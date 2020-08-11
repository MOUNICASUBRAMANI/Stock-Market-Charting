package com.stock.StockMarket;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StockPriceRepository extends CrudRepository<StockPrice, Integer> {
	
	List<StockPrice> findAllByCompanycodeAndDateBetween(String companycode, Date date, Date date1);

}
