package com.kapture.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle {
	IEngine engine;
	Tyres tyre;

	public IEngine getEngine() {
		return engine;
	}

	public void setEngine(IEngine engine) {
		System.out.println("Vehicle instantiated via setter!");
		this.engine = engine;
	}

	public Tyres getTyre() {
		return tyre;
	}

	public void setTyre(Tyres tyre) {
		this.tyre = tyre;
	}

	public Vehicle() {
	}

	public Vehicle(IEngine engine, Tyres tyre) {
		System.out.println("Vehicle instantiated via constructor!");
		this.engine = engine;
		this.tyre = tyre;
	}

	@Override
	public String toString() {
		return engine + " " + tyre;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext rootContext = new ClassPathXmlApplicationContext("/springContext.xml");
		Vehicle obj1 = (Vehicle) rootContext.getBean("InjectWithConstructor");
		Vehicle obj2 = (Vehicle) rootContext.getBean("InjectWithSetter");

		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1.equals(obj2));
	}
}
