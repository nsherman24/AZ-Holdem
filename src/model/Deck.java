package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		initializeDeck();
		shuffle();
	}

	private void initializeDeck() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}

	public Card drawCard() {
		if (cards.isEmpty()) {
			throw new IllegalStateException("Deck is empty. Cannot draw a card.");
		}
		return cards.remove(cards.size() - 1);
	}

	public List<Card> drawCards(int numCards) {
		if (numCards > cards.size()) {
			throw new IllegalStateException("Not enough cards in the deck to draw " + numCards + " cards.");
		}

		List<Card> drawnCards = new ArrayList<>();
		for (int i = 0; i < numCards; i++) {
			drawnCards.add(drawCard());
		}

		return drawnCards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
}
