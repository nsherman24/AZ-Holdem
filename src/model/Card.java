package model;

/** 
 * class Card represents one of the 52 poker cards. There are
 * no comments before methods because the method name says it all.
 * 
 * @author Rick Mercer and YOUR NAME
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
    return null;
  }

  public Rank getRank() {
    return null;
  }

  public int getValue() {
    return Integer.MAX_VALUE;
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

    // Need to get the value instead of "?"
    return "?" + suitIcon;
  }

  @Override
  public int compareTo(Card other) {
    return Integer.MAX_VALUE;
  }

}