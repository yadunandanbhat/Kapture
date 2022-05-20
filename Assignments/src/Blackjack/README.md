## Getting Started

Write a program that allows a user to play a simplified version of Blackjack against a computer opponent.

## Outline

- So the cards will be from 2 to 11. And all are *equally likely*.
- First, draw 2 cards for the user and display it to him and then draw 2 for the dealer and just display one and keep another hidden.
- Ask player if he wants to hit it as many times as he likes or stay.
- If player gets a sum over 21, he is busted, and the dealer automatically wins.
- If player chooses stay, then his chance is over and the dealer now gets to hit or stay.
- The dealer can also hit as many times as they like. But should porbably stop if the sum is > 16.
- And while hitting, if the total of dealer becomes >= 21, then player wins.
- If no one is busted, and both have hit stay, then the player with the highest total wins.
- If there is a tie, then the dealer always wins.

## How to go about coding this

- Maybe use classes and objects?
- The program shouldn't stop until either one of the players win.
- Maybe use a while loop for the user input and a switch case for the hit or stay.
- Use the same for the dealer too. Maybe a random function to get a number in the range of 0 to 3? Like if its 0 then stay, and if `1<=rand<=3` then that will be number of times the dealer will get hit.
- For each time dealer and player hits, display the total and use a conditional to check if its >=21, and if yes then exit the loops and display the winner and exit the program.
- And for each time the dealer stays, print that too. And exit the loop to check who has won.
- Print the winning output in captial letters. And exit the program.


## Grading

- Functionality - Does your program fulfill the basic requirements? Is it done? And what else does it do? (50%)
- Overall Impression - Is your program efficiently organized, or is there a lot of duplicated code? Does it look well-written, or barely finished? (25%)
- Bugs - does it compile? Are there obvious errors? Are there subtle errors? (10%)
- Internal Documentation - How easy is your code to understand? Are you using good variable names? Are there any comments? (10%)
- Readability - Is your program consistently indented in a manner that reflects the structure of your code? Is it easy to read? Are there blank lines which break up the major sections of your code? (5%)
