package com.kapture.spring;

public class Tyres {
	String name;
	String dimension;
	String gripType;
	
	public Tyres() {
		super();
	}

	public Tyres(String name, String dimension, String gripType) {
		super();
		this.name = name;
		this.dimension = dimension;
		this.gripType = gripType;
		System.out.println("Tyres instantiated via constructor!");
	}

	public String getName() {
		return name;
	}

	public String getDimension() {
		return dimension;
	}

	public String getGripType() {
		return gripType;
	}

	public void setName(String name) {
		System.out.println("Tyres instantiated via setter!");
		this.name = name;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public void setGripType(String gripType) {
		this.gripType = gripType;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nThis tyre's name is " + this.name + " and its dimensions are " + this.dimension
				+ " and its grip type is " + this.gripType;
	}
}