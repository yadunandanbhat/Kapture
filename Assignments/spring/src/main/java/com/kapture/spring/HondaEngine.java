package com.kapture.spring;

public class HondaEngine implements IEngine {
    String company;
    double cost;

    public HondaEngine() {
        super();
    }

    public HondaEngine(String company, double cost) {
        super();
        this.company = company;
        this.cost = cost;
        System.out.println("Honda instantiated via constructor!");
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        System.out.println("Honda instantiated via setter!");
        this.company = company;
    }

    public String importCountry() {
        return "Japan";
    }

    public double cost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return "This engine is from " + this.company;
    }
}