package SudokuSolver;

import java.util.Scanner;

public class SudokuSolver {
    // ANSI color variables to format the output
    static final String RESET = "\033[0m";
    static final String BLACK = "\033[0;30m";
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String BLUE = "\033[0;34m";

    // Initializing a default matrix
    private static int[][] matrix = {
        {0, 0, 4, 0, 5, 0, 0, 0, 0},
        {9, 0, 0, 7, 3, 4, 6, 0, 0},
        {0, 0, 3, 0, 2, 1, 0, 4, 9},
        {0, 3, 5, 0, 9, 0, 4, 8, 0},
        {0, 9, 0, 0, 4, 0, 0, 3, 0},
        {0, 7, 6, 0, 1, 0, 9, 2, 0},
        {3, 1, 0, 9, 7, 0, 2, 0, 0},
        {0, 0, 9, 1, 8, 2, 0, 0, 3},
        {0, 0, 0, 0, 6, 0, 1, 0, 0}
    };

    /**
     * This method is used to ask the user for their own 9x9 matrix as input
     */
    public void enterMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the 9x9 matrix below. If the box is blank then enter 0");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
    }

    /**
     * @param row - Row number
     * @param number - The number which will be checked
     * @return True if the number is in the given row or false
     */
    public boolean inRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i]==number) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param col - Column number
     * @param number - The number which will be checked
     * @return True if the number is in the given column or false
     */
    public boolean inColumn(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (matrix[i][col]==number) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param row - Row number
     * @param col - Column number
     * @param number -  The number which will be checked
     * @return True if the number is in the given subgrid or false
     */
    public boolean inSubGrid(int row, int col, int number) {
        int r = row - row%3;
        int c = col - col%3;
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if (matrix[r][c]==number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Mehtod used to display the matrix
     */
    public void displayMatrix() {
        System.out.println(RED + "-------------------------" + RESET);
        for (int i = 0; i < 9; i++) {
            System.out.print(RED + "| " + RESET);
            for (int j = 0; j < 9; j++) {
                System.out.print(GREEN + matrix[i][j] + " " + RESET);
                if ((j+1) % 3==0) {
                    System.out.print(RED + "| " + RESET);
                }
            }
            System.out.println();
            if ((i+1) % 3==0) {
                System.out.println(RED + "-------------------------" + RESET);
            }
        }
    }

    /**
     * Method used to solve the given matrix using backtracking.
     * First it takes a number from 1 to 9 and checks is its in the row, column and subgrid.
     * If not, then adds that number. And starts to solve the matrix.
     * But if it encounters any error or unforeseen consequence then it returs to the
     * main call and removes that number i.e. Backtracking.
     * @return True if the matrix is completely solved or else false
     */
    public boolean solveMatrix() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j]==0) {
                    for (int x = 1; x <= 9; x++) {
                        if (!inRow(i, x) && !inColumn(j, x) && !inSubGrid(i, j, x)) {
                                matrix[i][j]=x;
                            
                            if (solveMatrix()) {
                                return true;
                            } else {
                                matrix[i][j]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        // * s.enterMatrix() -> If we want to enter custom matrix
        System.out.println("\nThe given matrix is\n");
        s.displayMatrix();
        s.solveMatrix();
        System.out.println("\nAfter solving the matrix becomes:\n");
        s.displayMatrix();
    }
}