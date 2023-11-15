package model;

/**
 * class Card represents one of the 52 poker cards. There are no comments before
 * methods because the method name says it all.
 * 
 * @author Rick Mercer and Noah Sherman
 */

public class Card implements Comparable<Card> {
	private final Rank rank;
	private final Suit suit;

	// Constructor
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return rank.getValue();
	}

	public String toString() {
		// Use these four Unicode icons for the solid suit icons.
		char suitIcon = '\u2663';
		if (suit == Suit.DIAMONDS)
			suitIcon = '\u2666';
		if (suit == Suit.HEARTS)
			suitIcon = '\u2665';
		if (suit == Suit.SPADES)
			suitIcon = '\u2660';

		String rankString;
		int rankValue = rank.getValue();
		if (rankValue >= 2 && rankValue <= 10) {
			rankString = String.valueOf(rankValue);
		} else {
			// Handle special ranks like Jack, Queen, King, Ace
			switch (rank) {
			case JACK:
				rankString = "J";
				break;
			case QUEEN:
				rankString = "Q";
				break;
			case KING:
				rankString = "K";
				break;
			case ACE:
				rankString = "A";
				break;
			default:
				rankString = ""; // Handle unexpected cases
			}
		}

		return rankString + "" + suitIcon;
	}

	@Override
	public int compareTo(Card other) {
		return Integer.compare(this.getRank().getValue(), other.getRank().getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		return this.getRank() == other.getRank() && this.getSuit() == other.getSuit();
	}
}