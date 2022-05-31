package com.kapture.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.kapture.spring")
public class Appconfig {
//	@Bean
//	public Vehicle getVehicle() {
//		return new Vehicle(getToyota(), getBridgestone());
//	}
//	
//	@Bean
//	@Primary
//	public Tyres getPirelli() {
//		return new Tyres("Pirelli", "112", "Soft");
//	}
//	
//	@Bean
//	public Tyres getBridgestone() {
//		return new Tyres("Bridgestone", "126", "Medium");
//	}
//	
//	@Bean
//	@Primary
//	public IEngine getToyota() {
//		return new ToyotaEngine("Japan", 760000);
//	}
//	
//	@Bean
//	public IEngine getHonda() {
//		return new HondaEngine("Japan", 920000);
//	}
}