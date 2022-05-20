## Getting Started

Write a program that takes a 9x9 valid sudoku matrix and solves the sudoku matrix and prints the matrix.

## How to go about coding this

- Using 3 nested for loops?! Probably not!
- One thing that comes to mind is using backtracking or recursion to solve it
- Basically for each box (`matrix[i][j]`) we have to check if the element consists in any of the `matrix[i][1..9]` and `matrix[1..9][j]`
- Also check that index's `3x3` box has all the numbers from `1..9`
- If it is not there then add the number or else add the next number which is not in the group of `1..9`
- And start solving in that path, if any unwanted consequence then return to parent and remove that number and move to next iteration