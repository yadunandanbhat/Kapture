package com.kapture.springblackjack;

import java.util.List;

public class Game {
    private Player dealer;
    private Player player;
    private Deck deck;

    public List<Card> getPlayerCards() {
        return player.getCards();
    }

    public List<Card> getDealerCards() {
        return dealer.getCards();
    }

    public Card getFirstDealerCard() {
        return dealer.getCard(0);
    }

    Game() {
        dealer = new Player();
        player = new Player();
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public int getDealerScore() {
        return dealer.getScore();
    }

    public int init() {
        System.out.println("\nNew Game\n");
        System.out.println("----------------------------------------------");
        // Init a deck
        deck = new Deck();
        // Shuffle the deck
        deck.shuffle();
        // Draw 2 cards for both player and dealer
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());

        // Output their cards
        System.out.println("Dealer has: [" + dealer.getCard(0) + ", Hidden ]\n");
        System.out.println("You have: [" + player.getScore() + ", " + player.getCards() + "]\n");

        if (player.getScore() == 21) {
            // If player's score is equal to 21, then player wins automatically
            return 1;
        }

        if (dealer.getScore() == 21) {
            // If dealer's score is equal to 21, then dealer wins automatically
            System.out.println("Dealer wins with " + dealer.getCards());
            return -1;
        }
        return 0;
    }

    boolean playerStage() {
        // Deal a card to the player
        Card card = deck.dealCard();
        // Add the card to their hand
        player.addCard(card);
        // Print the card and total
        System.out.println("\nYou draw card " + card);
        System.out.println("\nYou have a total score of " + player.getScore() + " and cards: " + player.getCards());
        if (player.getScore() > 21) {
            System.out.println("\nBusted!\n");
            return false;
        }
        return true;
    }

    boolean dealerStage() {
        System.out.println("Dealer's turn");
        System.out.println("Dealer has a total score of " + dealer.getScore() + " and cards: " + dealer.getCards());

        while (dealer.getScore() < 17) {
            // If and only if the dealer score is less than 17 then only the dealer hits or else he stays
            System.out.println("\nDealer hits!");
            // Deal a card to dealer
            Card card = deck.dealCard();
            // Add it to their hand
            dealer.addCard(card);
            // Print the card and total
            System.out.println("Dealer draws card " + card + " having a total of " + dealer.getScore());
            if (dealer.getScore() > 21) {
                System.out.println("\nYou win, Dealer has " + dealer.getScore());
                return false;
            }
        }
        System.out.println("\nDealer stays!");
        return true;
    }

    int getResult() {
        // Method to get the final result only if nobody has got busted
        // Player with the highest score wins and all the draws are won by dealer
        int diff = player.getScore() - dealer.getScore();
        if (diff > 0) {
            System.out.println("\nYou win with " + player.getScore());
            return 1;
        } else if (diff < 0) {
            System.out.println("\nDealer wins with " + dealer.getScore());
            return -1;
        } else {
            System.out.println("\nDraw. But all the ties goes to Dealer. So Dealer wins!");
            return 0;
        }
    }
}