## Getting Started

Write a calculator program. 

## Outline

A minimal calculator will support the following functions:

- numbers with decimals (not just integers)
- addition (1 + 2 is 3)
- subtraction (12 - 4 is 8)
- multiplication (33 * 2 is 66)
- division (3 / 8 is 0.375)
- exponents (2 ^ 3 is 8)
- error messages when you do something wrong

Your calculator should keep on running until explicitly told to quit.

## How to go about coding this

- Maybe store everything as a string
- Then check if the first operand is number or is alpha and then make the calculation decision
- Maybe use strategy pattern for the design of operations
- And also singleton pattern to just make a single instance of the class

## Other addable features

Programs may support other features if desired. Suggested other functions to add include:

- modulus (10 % 3 is 1)
- factorials (4 ! is 4*3*2*1, a.k.a. 24)
- trigonometric functions (sin,cos,tan)
- square roots
- negation (- -3 is 3)
- angles in degrees or radians
- a help feature to display legal syntax and supported functions
- previous result used as first operand
- the ability to store and recall results
- rounding
- logarithms
- arbitrary roots
- conversion from base 10 to binary (for integers only)
