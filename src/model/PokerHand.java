package model;

/**
 * @author Rick Mercer and Noah Sherman
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {
	private List<Card> cards;

	public PokerHand() {
		cards = new ArrayList<>();
	}

	public void setCards(List<Card> cards) {
		this.cards = new ArrayList<>(cards);
		Collections.sort(this.cards);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);

	}

	public int getRank() {
		if (isRoyalFlush()) {
			return PokerHandRanking.ROYAL_FLUSH;
		} else if (isStraightFlush()) {
			return PokerHandRanking.STRAIGHT_FLUSH;
		} else if (isFourOfAKind()) {
			return PokerHandRanking.FOUR_OF_A_KIND;
		} else if (isFullHouse()) {
			return PokerHandRanking.FULL_HOUSE;
		} else if (isFlush()) {
			return PokerHandRanking.FLUSH;
		} else if (isStraight()) {
			return PokerHandRanking.STRAIGHT;
		} else if (isThreeOfAKind()) {
			return PokerHandRanking.THREE_OF_A_KIND;
		} else if (isTwoPair()) {
			return PokerHandRanking.TWO_PAIR;
		} else if (isOnePair()) {
			return PokerHandRanking.ONE_PAIR;
		} else {
			return PokerHandRanking.HIGH_CARD;
		}
	}

	public HandRank getHandRank() {
		if (isStraightFlush()) {
			return HandRank.STRAIGHT_FLUSH;
		} else if (isFourOfAKind()) {
			return HandRank.FOUR_OF_A_KIND;
		} else if (isFullHouse()) {
			return HandRank.FULL_HOUSE;
		} else if (isFlush()) {
			return HandRank.FLUSH;
		} else if (isStraight()) {
			return HandRank.STRAIGHT;
		} else if (isThreeOfAKind()) {
			return HandRank.THREE_OF_A_KIND;
		} else if (isTwoPair()) {
			return HandRank.TWO_PAIR;
		} else if (isOnePair()) {
			return HandRank.ONE_PAIR;
		} else {
			return HandRank.HIGH_CARD;
		}
	}

	@Override
	public int compareTo(PokerHand other) {
		int rankComparison = compareHandRanks(other);

		if (rankComparison != 0) {
			return rankComparison;
		} else {
			// Compare all cards for other hand types
			for (int i = 4; i >= 0; i--) {
				int cardComparison = this.cards.get(i).compareTo(other.cards.get(i));
				if (cardComparison != 0) {
					return cardComparison;
				}
			}
		}
		return 0; // Equal hands
	}

	private int compareHandRanks(PokerHand other) {
		if (isRoyalFlush()) {
			return other.isRoyalFlush() ? 0 : 1;
		}
		if (isStraightFlush() || isFlush() || isStraight()) {
			return getHighestCard().compareTo(other.getHighestCard());
		}
		if (isFourOfAKind() || isFullHouse() || isThreeOfAKind()) {
			return cards.get(2).compareTo(other.cards.get(2));
		}
		if (isTwoPair()) {
			int higherPairComparison = cards.get(3).compareTo(other.cards.get(3));
			if (higherPairComparison != 0) {
				return higherPairComparison;
			}
//        return cards.get(1).compareTo(other.cards.get(1));
		}
		if (isOnePair()) {
			return cards.get(1).compareTo(other.cards.get(1)); // issue is here we need to see where the pair is
		}
		return compareHighCard(other);
	}

	private Card getHighestCard() {
		return cards.get(cards.size() - 1);
	}

	private boolean isRoyalFlush() {
		return isStraightFlush() && getHighestCard().getRank() == Rank.ACE;
	}

	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isFourOfAKind() {
		for (int i = 0; i <= 1; i++) {
			if (cards.get(i).getRank() == cards.get(i + 1).getRank()
					&& cards.get(i).getRank() == cards.get(i + 2).getRank()
					&& cards.get(i).getRank() == cards.get(i + 3).getRank()) {
				return true;
			}
		}
		return false;
	}

	private boolean isFlush() {
		Suit firstSuit = cards.get(0).getSuit();
		for (Card card : cards) {
			if (card.getSuit() != firstSuit) {
				return false;
			}
		}
		return true;
	}

	private boolean isStraight() {
		for (int i = 1; i < cards.size(); i++) {
			if (cards.get(i).getRank().getValue() != cards.get(i - 1).getRank().getValue() - 1) {
				return false;
			}
		}
		return true;
	}

	private boolean isFullHouse() {
		// Check for a three of a kind and a pair
		return (cards.get(0).getRank() == cards.get(1).getRank() && cards.get(2).getRank() == cards.get(3).getRank()
				&& cards.get(3).getRank() == cards.get(4).getRank())
				|| (cards.get(0).getRank() == cards.get(1).getRank() && cards.get(1).getRank() == cards.get(2).getRank()
						&& cards.get(3).getRank() == cards.get(4).getRank());
	}

	private boolean isThreeOfAKind() {
		// Check if there are three cards with the same rank
		for (int i = 0; i <= 2; i++) {
			if (cards.get(i).getRank() == cards.get(i + 1).getRank()
					&& cards.get(i).getRank() == cards.get(i + 2).getRank()) {
				return true;
			}
		}
		return false;
	}

	private boolean isTwoPair() {
		// Check for two pairs of cards with the same rank
		return (cards.get(0).getRank() == cards.get(1).getRank() && cards.get(2).getRank() == cards.get(3).getRank())
				|| (cards.get(0).getRank() == cards.get(1).getRank()
						&& cards.get(3).getRank() == cards.get(4).getRank())
				|| (cards.get(1).getRank() == cards.get(2).getRank()
						&& cards.get(3).getRank() == cards.get(4).getRank());
	}

	private boolean isOnePair() {
		// Check for a pair of cards with the same rank
		for (int i = 0; i <= 3; i++) {
			if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
				return true;
			}
		}
		return false;
	}

	private int compareHighCard(PokerHand other) {
		// Compare based on the highest card
		return getHighestCard().compareTo(other.getHighestCard());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Card card : cards) {
			sb.append(card).append(" ");
		}

		return sb.toString();
	}
}
