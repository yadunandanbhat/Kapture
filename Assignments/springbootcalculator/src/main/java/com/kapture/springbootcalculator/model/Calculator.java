package com.kapture.springbootcalculator.model;

public class Calculator {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculateResult() {
        double result = switch (this.operator) {
            case "+" -> this.leftOperand + this.rightOperand;
            case "-" -> this.leftOperand - this.rightOperand;
            case "*" -> this.leftOperand * this.rightOperand;
            case "/" -> this.leftOperand / this.rightOperand;
            case "%" -> (this.leftOperand / this.rightOperand) * 100.00;
            case "^" -> Math.pow(this.leftOperand, this.rightOperand);
            default -> 0;
        };

        return result;
    }
}