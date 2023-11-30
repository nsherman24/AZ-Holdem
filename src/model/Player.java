package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private static int nextPlayerNumber = 1;
	private int playerNumber;
	private double balance;
	private PokerHand hand;
	private List<Card> initialCards;

	public Player(double balance) {
		this.playerNumber = nextPlayerNumber++;
		this.balance = balance;
		this.hand = new PokerHand();
		this.initialCards = new ArrayList<>();
	}
	
	public List<Card> getInitialCards() {
        return initialCards;
    }
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	public static void resetPlayerNumber() {
        nextPlayerNumber = 1;
    }
	
	public double getBalance() {
		return balance;
	}

	public PokerHand getHand() {
		return hand;
	}

	public void setHand(PokerHand hand) {
		this.hand = hand;
	}

	public PokerHand evaluateBestHand(List<Card> communityCards) {
		List<Card> allCards = combineCardsWithCommunityCards(communityCards);
		hand.setCards(allCards);

		// Generate all possible combinations of 5 cards
		List<List<Card>> combinations = generateCombinations(allCards);

		// Evaluate the best hand among all combinations
		PokerHand bestHand = evaluateBestHandAmongCombinations(combinations);

		// Set the best hand in the player's hand
		hand.setCards(bestHand.getCards());

		return hand;
	}

	private List<Card> combineCardsWithCommunityCards(List<Card> communityCards) {
		List<Card> allCards = new ArrayList<>(hand.getCards());
		allCards.addAll(communityCards);
		return allCards;
	}

	private List<List<Card>> generateCombinations(List<Card> cards) {
		List<List<Card>> result = new ArrayList<>();
		generateCombinationsHelper(cards, 0, new ArrayList<>(), result);
		return result;
	}

	private void generateCombinationsHelper(List<Card> cards, int start, List<Card> currentCombination,
			List<List<Card>> result) {
		if (currentCombination.size() == 5) {
			result.add(new ArrayList<>(currentCombination));
			return;
		}

		for (int i = start; i < cards.size(); i++) {
			currentCombination.add(cards.get(i));
			generateCombinationsHelper(cards, i + 1, currentCombination, result);
			currentCombination.remove(currentCombination.size() - 1);
		}
	}

	private PokerHand evaluateBestHandAmongCombinations(List<List<Card>> combinations) {
		PokerHand bestHand = null;
		for (List<Card> combination : combinations) {
			PokerHand currentHand = new PokerHand();
			for (Card card : combination) {
				currentHand.addCard(card);
			}
			if (bestHand == null || currentHand.compareTo(bestHand) > 0) {
				bestHand = currentHand;
			}
		}
		return bestHand;
	}

	public void addCard(Card card) {
		 if (initialCards.size() < 2) {
	            initialCards.add(card);
	        }
		hand.addCard(card);
	}
	
	private String formatInitialCards() {
		 List<Card> sortedCards = new ArrayList<>(initialCards);
		    Collections.sort(sortedCards); // Assuming Card implements Comparable

		    StringBuilder formattedCards = new StringBuilder();
		    for (Card card : sortedCards) {
		        formattedCards.append(card).append(" ");
		    }
		    return formattedCards.toString();
    }

	@Override
	public String toString() {
		return String.format("Player %d: $%.2f - %s", playerNumber, balance, formatInitialCards());
	}

	public void deductBalance(double d) {
		balance = balance - d;
		
	}

	public void addBalance(double pot) {
		balance = balance + pot;

	}
}
