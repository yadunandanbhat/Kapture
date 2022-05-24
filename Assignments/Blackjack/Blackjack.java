package Blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Blackjack {
    // Initializing the reader class and the random class
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Random random = new Random();

    // Declaring the user and dealer total variables
    static int userTotal;
    static int dealerTotal;

    // ANSI color variables to format the output
    static final String RESET = "\033[0m";
    static final String BLACK = "\033[0;30m";
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String BLUE = "\033[0;34m";

    int userFirst, userSecond, dealerFirst, dealerHidden;

    /**
     * This method returns a random number between 2 and 11.
     * The return is added with 2 because we can't specify a range
     * for the random function.
     * @return 2 + 0<=randomNumber<10
     */
    private int draw() {
        return 2 + random.nextInt(10);
    }

    /**
     * This method is used to initialize the game.
     * First it draws 2 cards each for user and dealer and then updates their
     * totals. Then checks if user's total is already greater than 21.
     * And prints the dealer's visible card.
     */
    private void init() {
        userFirst = draw();
        userSecond = draw();
        dealerFirst = draw();
        dealerHidden = draw();
        userTotal = userFirst + userSecond;
        dealerTotal = dealerFirst + dealerHidden;
        System.out.println("You drew a " + GREEN + userFirst + RESET + " and a " + GREEN + userSecond + RESET);
        userTotal();
        check("user");
        System.out.println("The dealer has drew a " + GREEN + dealerFirst + RESET + " showing and a hidden card");
        System.out.println("The dealer's total is hidden\n");
    }

    /**
     * This function is used to ask user for their input, i.e. hit or stay and
     * progress based on it. If user says hit, then draws a card and updates
     * their total and checks their total. If stay then return. And if some
     * other input then prints a message to input correct command.
     * 
     * @throws IOException
     */
    private void user() throws IOException {
        String input = "";
        while (true) {
            System.out.print("Would you like to hit or stay? ");
            input = br.readLine().strip().toLowerCase();
            // * This above line is used to strip the string of its whitespace
            // * And then if not in lowercase then convert it to it, to be consistent with
            // * the switch case
            switch (input) {
                case "hit":
                    int drawn = draw();
                    System.out.println("You drew a " + GREEN + drawn + RESET);
                    userTotal += drawn;
                    userTotal();
                    check("user");
                    break;

                case "stay":
                    return;

                default:
                    System.out.println("\nYou input a wrong command. Please input either hit or stay");
            }
        }
    }

    /**
     * This function plays the game from the dealer side. First shows the hidden
     * cards of the dealer and prints the total and also checks it. Then, to get
     * how much play the dealer should make, it calls random integer less than 3,
     * because more than is less likely to be less than 21. While playing if the
     * dealerTotal becomes greater than 18 it immediately stays.
     */
    private void dealer() {
        System.out.println("\nOkay, dealer's turn");
        System.out.println("His hidden card was " + GREEN + dealerHidden + RESET);
        dealerTotal();
        check("dealer");
        int timesToHit = random.nextInt(3);
        while (timesToHit-- > 0) {
            if (dealerTotal > 18) {
                break;
            }
            System.out.println("Dealer chooses to hit");
            int drawn = draw();
            System.out.println("He draws a " + GREEN + drawn + RESET);
            dealerTotal += drawn;
            dealerTotal();
            check("dealer");
        }
        System.out.println("Dealer stays\n");
        return;
    }

    /**
     * This function is used to check if the input player's total >= 21.
     * If yes, then print they are busted and that the opponent has won.
     * And exit the program.
     * 
     * @param player = Player name
     */
    private void check(String player) {
        switch (player) {
            case "user":
                if (userTotal > 21) {
                    System.out.println(BLUE + "==========================================");
                    System.out.println("Your total exceeded 21");
                    System.out.println("You got busted!");
                    System.out.println("The dealer wins!");
                    System.out.println("==========================================" + RESET);
                    System.exit(1);
                }
                break;

            case "dealer":
                if (dealerTotal > 21) {
                    System.out.println(BLUE + "==========================================");
                    System.out.println("Dealer total exceeded 21");
                    System.out.println("Dealer got busted!");
                    System.out.println("You win!");
                    System.out.println("==========================================" + RESET);
                    System.exit(1);
                }
                break;
        }
    }

    /**
     * This is used to print the total of the user.
     */
    private void userTotal() {
        System.out.println("Your total is " + GREEN + userTotal + RESET + "\n");
        return;
    }

    /**
     * This is used to print the total of the dealer.
     */
    private void dealerTotal() {
        System.out.println("Dealer's total is " + GREEN + dealerTotal + RESET + "\n");
        return;
    }

    /**
     * Public constructor used to initialize the user and dealer's totals to 0.
     */
    public Blackjack() {
        userTotal = 0;
        dealerTotal = 0;
    }

    public static void main(String[] args) throws IOException {
        // Create a new instance of the Blackjack class
        Blackjack bj = new Blackjack();
        System.out.println(RED + "Welcome to " + BLACK + "Black" + RED + "jack program!");
        System.out.println(BLUE + "-------------------------------------------------------\n" + RESET);
        bj.init();
        bj.user();
        bj.dealer();
        bj.dealerTotal();
        bj.userTotal();
        System.out.println(BLUE + "==========================================");
        if (dealerTotal == userTotal) {
            // * If there is a tie, the dealer always wins.
            System.out.println("The total is tied. So the dealer wins!");
        } else if (dealerTotal < userTotal) {
            System.out.println("You win!");
        } else {
            System.out.println("Dealer wins!");
        }
        System.out.println("==========================================" + RESET);
    }
}