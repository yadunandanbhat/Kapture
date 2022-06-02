package com.kapture.spring;

public class ToyotaEngine implements IEngine {
    String company;
    double cost;

    public ToyotaEngine() {
        super();
    }

    public ToyotaEngine(String company, double cost) {
        super();
        this.company = company;
        this.cost = cost;
        System.out.println("Toyota instantiated via constructor!");
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
        System.out.println("Toyota instantiated via setter!");
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
