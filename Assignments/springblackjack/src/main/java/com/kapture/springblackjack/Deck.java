package com.kapture.springblackjack;

public class Deck {
    private Card[] deck;
    // Declare a array of cards called as a Deck
    private int cardsUsed;
    // Variable used to keep track of the used cards

    public Deck() {
        deck = new Card[52];
        // Init a deck of 52 cards
        int cardCount = 0;
        // Increase the card count by 1 for each inner loop iteration
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value < 14; value++) {
                deck[cardCount] = new Card(value, suit);
                // Create a card from the given rank and suit values
                cardCount++;
            }
        }
    }

    public void shuffle() {
        // Shuffling function used to shuffle the cards in a random manner
        for (int i = 51; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            // Swap the cards in the given deck after shuffling
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public Card dealCard() {
        // Use this to deal a card and then decrease the card count in the deck by 1
        if (cardsUsed == 52) {
            System.out.println("\nNo more cards\n");
            return null;
        }
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
}