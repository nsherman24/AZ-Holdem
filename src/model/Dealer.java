package model;

import java.util.List;

public class Dealer {
	private Deck deck;

	public Dealer(Deck deck) {
		this.deck = deck;
	}

	public void dealCards(List<Player> players, int numCards) {
		for (int i = 0; i < numCards; i++) {
			for (Player player : players) {
				Card card = deck.drawCard();
				player.addCard(card);
			}
		}
	}
	

	public List<Card> dealCommunityCards(int numCommunityCards) {
		List<Card> communityCards = deck.drawCards(numCommunityCards);
		return communityCards;
	}
}
