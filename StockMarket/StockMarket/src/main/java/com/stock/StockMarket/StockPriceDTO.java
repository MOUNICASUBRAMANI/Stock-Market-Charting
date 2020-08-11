package com.stock.StockMarket;

import java.sql.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StockPriceDTO {

		  private String com;
		private String company_name;
		  
		  private String stock_exchange;
		  
		  @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
		  private Date FromDate;
		  
		  @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
		  private Date ToDate;
		  
		  public String getCom() {
				return com;
			}

			public void setCom(String com) {
				this.com = com;
			}

		public String getCompany_name() {
			return company_name;
		}

		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}

		public String getStock_exchange() {
			return stock_exchange;
		}

		public void setStock_exchange(String stock_exchange) {
			this.stock_exchange = stock_exchange;
		}

		public Date getFromDate() {
			return FromDate;
		}

		public void setFromDate(Date fromDate) {
			FromDate = fromDate;
		}

		public Date getToDate() {
			return ToDate;
		}

		public void setToDate(Date toDate) {
			ToDate = toDate;
		}
		 


}
