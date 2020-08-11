package com.stock.StockMarket;

//import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface IPORepository extends CrudRepository<IPO, Integer> {
	Iterable<IPO> findAllByOpendateGreaterThan(Date opendate);
}
