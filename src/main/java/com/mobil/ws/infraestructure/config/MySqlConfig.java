package com.mobil.ws.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("mySql")
public class MySqlConfig {

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@172.21.50.10:60135:ADBOBRBA");
		driverManagerDataSource.setUsername("PROCCACUC1");
		driverManagerDataSource.setPassword("Meve_123");
		return driverManagerDataSource;
	}
}
