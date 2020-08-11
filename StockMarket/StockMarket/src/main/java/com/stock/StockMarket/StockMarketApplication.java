package com.stock.StockMarket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class StockMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketApplication.class, args);
	}
//	@Configuration
//	@EnableWebSecurity
//	public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.csrf().
//	        disable()
//	            .authorizeRequests()
//	            .antMatchers(HttpMethod.OPTIONS, "/**")
//	            .permitAll()
//	            .anyRequest()
//	            .authenticated()
//	            .and()
//	            .httpBasic();
//	    }
//	}
}

