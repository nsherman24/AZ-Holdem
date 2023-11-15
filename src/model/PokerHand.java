package model;

/**
 * @author Rick Mercer and Noah Sherman
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {
	private List<Card> cards;

	public PokerHand(Card s6, Card d7, Card da, Card ca, Card ha) {
		cards = new ArrayList<>();
		cards.add(s6);
		cards.add(d7);
		cards.add(da);
		cards.add(ca);
		cards.add(ha);
		Collections.sort(cards);
		// TODO Complete this constructor.
		// Recommended: Store 5 Card objects in a sorted ArrayList<Card>
	}

	@Override
	public int compareTo(PokerHand other) {
		int rankComparison = compareHandRanks(other);

		if (rankComparison != 0) {
			return rankComparison;
		} else {
			// Same rank, break ties by comparing individual cards
			for (int i = 4; i >= 0; i--) {
				int cardComparison = this.cards.get(i).compareTo(other.cards.get(i));
				if (cardComparison != 0) {
					return cardComparison;
				}
			}
			return 0; // Equal hands
		}
	}

	private int compareHandRanks(PokerHand other) {
//	if (isRoyalFlush()) {
//        return other.isRoyalFlush() ? 0 : 1;
//    }
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
			return cards.get(1).compareTo(other.cards.get(1));
		}
		return compareHighCard(other);
	}

	private Card getHighestCard() {
		// Return the highest card in the hand
		return cards.get(cards.size() - 1);
	}

//private boolean isRoyalFlush() {
//	return isStraightFlush() && getHighestCard().getRank() == Rank.ACE;
//}

	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isFourOfAKind() {
		// Check if there are four cards with the same rank
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
}
