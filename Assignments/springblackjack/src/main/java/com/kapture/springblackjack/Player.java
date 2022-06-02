package com.kapture.springblackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Player {

    // List of cards in the player's hand currently
    private List<Card> hand;

    // Init a player's hand, i.e an ArrayList of Cards
    public Player() {
        hand = new ArrayList<Card>();
    }

    // This fucntion returns the player's current score
    public int getScore() {
        int val = 0;
        boolean ace = false;
        int cards = getCardCount();

        for (int i = 0; i < cards; i++) {
            // Get single card from the player's hand
            Card card = getCard(i);
            // Get rank
            int cardVal = card.getRank();
            if (cardVal > 10) {
                // If its J, K or Q then also its value will only be 10
                cardVal = 10;
            }
            if (cardVal == 1) {
                // If the card is ace, then put ace is true
                ace = true;
            }
            // Increase the total value by the card value
            val = val + cardVal;
        }

        /*if (ace == true && val + 10 <= 21) {
            // Add ace only if the total value will be less than 21 after adding or else dont add
            val = val + 10;
        }*/
        return val;
    }

    public void addCard(Card c) {
        if (c != null) {
            // If only the card is not null then add the card
            hand.add(c);
        }
    }

    public int getCardCount() {
        // Number of cards in the player's hand
        return hand.size();
    }

    public Card getCard(int position) {
        if (position >= 0 && position < hand.size()) {
            // Only return if the position is valid else null
            return hand.get(position);
        } else {
            return null;
        }
    }

    public List<Card> getCards() {
        int i = 0;
        List<Card> v = new Vector<Card>();
        // Because its vector, it can grow when player draws a card and shrinks when the player submits a card
        while (i < hand.size()) {
            v.add(hand.get(i));
            i++;
        }
        return v;
    }
}