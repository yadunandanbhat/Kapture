package Calculator;

import java.util.Scanner;

public class Calculator {
    // Initializing the scanner class and the operand variables
    static Scanner input = new Scanner(System.in);
    static double operand1, operand2, result;

    // ANSI color variables to format the output
    static final String RESET = "\033[0m";
    static final String BLACK = "\033[0;30m";
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String BLUE = "\033[0;34m";

    /**
     * This function calculates the fatorial of a given integer using recursive
     * calls.
     * @param operand12 should be an integer.
     * @return the total factorial of the given operand.
     */
    private int factorial(int operand12) {
        if (operand12 == 0) {
            return 1;
        } else {
            return operand12 * factorial(operand12 - 1);
        }
    }

    /**
     * @param operand12 should be a double
     * @param operand22 should be a double
     * @return the modulus of the two operands
     */
    private double modulo(double operand12, double operand22) {
        return operand12 % operand22;
    }

    /**
     * @param operand12 should be a double
     * @param operand22 should be a double
     * @return the operand1 which is raised to the power operand2
     */
    private double exponentiate(double operand12, double operand22) {
        return Math.pow(operand12, operand22);
    }

    /**
     * @param operand12 should be a double
     * @param operand22 should be a double
     * @return the remainder of the division between operand1 and operand2
     */
    private double division(double operand12, double operand22) {
        return operand12 / operand22;
    }

    /**
     * @param operand12 should be a double
     * @param operand22 should be a double
     * @return the operand1 multiplied by operand2
     */
    private double multiplication(double operand12, double operand22) {
        return operand12 * operand22;
    }

    /**
     * @param operand12 should be a double
     * @param operand22 should be a double
     * @return the operand1 subtracted by operand2
     */
    private double subtraction(double operand12, double operand22) {
        return operand12 - operand22;
    }

    /**
     * @param operand12 should be a double
     * @param operand22 should be a double
     * @return the sum of operand1 and operand2
     */
    private double addition(double operand12, double operand22) {
        return operand12 + operand22;
    }

    public static void main(String[] args) {
        // Creating the instance of the calculator class
        Calculator c = new Calculator();
        
        while (true) { // Infinite looping
            System.out.print(GREEN + "> " + RESET); // Printing the prompt
            operand1 = input.nextDouble(); // Stores the first integer
            
            if (operand1 == 0) { // If the first integer is 0 then the program exits
                System.out.println(RED + "Exiting the program. Thank you!" + RESET);
                break;
            }
            
            String operator = input.next();
            if (operator.equals("!")) { // If the operator is ! then no need to take the next operand
                result = c.factorial((int) operand1); // Call the factorial function
                System.out.println("" + GREEN + operand1 + operator + " = " + BLUE + result + RESET);
                continue; // Go to the next iteration of the loop
            }
            
            operand2 = input.nextDouble();
            switch (operator) {
                case "+":
                    result = c.addition(operand1, operand2);
                    break;

                case "-":
                    result = c.subtraction(operand1, operand2);
                    break;

                case "*":
                    result = c.multiplication(operand1, operand2);
                    break;

                case "/":
                    result = c.division(operand1, operand2);
                    break;

                case "^":
                    result = c.exponentiate(operand1, operand2);
                    break;

                case "%":
                    result = c.modulo(operand1, operand2);
                    break;

                default:
                    // Print an errot message if the operator is not defined in the switch case
                    System.out.println(RED + "Please enter correct operands" + RESET);
                    continue;
            }
            // Print the output
            System.out.println("" + GREEN + operand1 + " " + operator + " " + operand2 + " = " + BLUE + result + RESET);
        }
    }
}
