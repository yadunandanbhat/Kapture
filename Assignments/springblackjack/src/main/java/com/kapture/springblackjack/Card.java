package com.kapture.springblackjack;

public class Card {
    private final static int SPADES = 0, HEARTS = 1, DIAMONDS = 2, CLUBS = 3;
    private final int suit;
    private final int rank;

    public Card(int val, int suit) {
        // This constructs a card from the given rank the suit
        rank = val;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuitAsString() {
        // For easy printing and accessing. This follows the variables in the above lines
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "noSuit";
        }
    }

    public String getValueAsString() {
        // For easy printing and accessing the rank of a card
        switch (rank) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return "noValue";
        }
    }

    public String toString() {
        // To print the given card's rank and suit
        return getValueAsString() + " of " + getSuitAsString();
    }
}