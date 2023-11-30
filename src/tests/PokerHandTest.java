package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the CardHand class, last modified Sep 2015, June 2017, July 23, August
 * 23
 * 
 * I think this a pretty good unit test, if you add any other test cases please
 * send them to me!
 * 
 * I am providing all 52 possible Cars to save you time writing @Tests
 * 
 * @author Rick Mercer and Noah Sherman
 */
public class PokerHandTest {

	// This file contains all 52 cards to save you time with names like
	// C2 for the two of clubs
	// AS for the ace of spades

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);
	
	 @Test
	    public void test1() {
	        // Create two PokerHands for testing
	        PokerHand hand1 = new PokerHand();
	        hand1.addCard(new Card(Rank.ACE, Suit.HEARTS));
	        hand1.addCard(new Card(Rank.KING, Suit.SPADES));
	        hand1.addCard(new Card(Rank.QUEEN, Suit.DIAMONDS));
	        hand1.addCard(new Card(Rank.JACK, Suit.CLUBS));
	        hand1.addCard(new Card(Rank.TEN, Suit.HEARTS));

	        PokerHand hand2 = new PokerHand();
	        hand2.addCard(new Card(Rank.KING, Suit.DIAMONDS));
	        hand2.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
	        hand2.addCard(new Card(Rank.JACK, Suit.HEARTS));
	        hand2.addCard(new Card(Rank.TEN, Suit.SPADES));
	        hand2.addCard(new Card(Rank.NINE, Suit.DIAMONDS));

	        // Test the compareTo method
	        assertTrue(hand1.compareTo(hand2) > 0);
	        assertTrue(hand2.compareTo(hand1) < 0);
	    }
	 
	 @Test
	    public void test2() {
	        // Create two PokerHands for testing
	        PokerHand hand1 = new PokerHand();
	        hand1.addCard(S9);
	        hand1.addCard(D9);
	        hand1.addCard(D3);
	        hand1.addCard(S5);
	        hand1.addCard(CK);
	        
	        PokerHand hand2 = new PokerHand();
	        hand2.addCard(D8);
	        hand2.addCard(H8);
	        hand2.addCard(HQ);
	        hand2.addCard(SK);
	        hand2.addCard(CJ);
	        
	        assertTrue(hand1.compareTo(hand2) > 0);
	        assertTrue(hand2.compareTo(hand1) < 0);
	    }
//	@Test
//	public void testStraightVsFlush() {
//		PokerHand a = new PokerHand(C3, C4, S5, C6, C7);
//		PokerHand b = new PokerHand(H6, H2, H8, H3, H10);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testHighCard1() {
//		PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
//		PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testHighCard2() {
//		PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
//		PokerHand b = new PokerHand(D3, D4, C6, C7, CA);
//		assertTrue(a.compareTo(b) == 0);
//	}
//
//	@Test
//	public void testRoyalFlush1() {
//		PokerHand a = new PokerHand(C10, CJ, CQ, CK, CA);
//		PokerHand b = new PokerHand(D10, DJ, DQ, DK, DA);
//		assertTrue(a.compareTo(b) == 0);
//	}
//
//	@Test
//	public void testRoyalFlush2() {
//		PokerHand a = new PokerHand(C10, CJ, CQ, CK, C2);
//		PokerHand b = new PokerHand(D10, DJ, DQ, DK, DA);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testRoyalFlush3() {
//		PokerHand a = new PokerHand(C10, CJ, CQ, CK, CA);
//		PokerHand b = new PokerHand(D10, DJ, DQ, DK, D2);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testRoyalFlush4() {
//		PokerHand a = new PokerHand(C10, CJ, CQ, CK, CA);
//		PokerHand b = new PokerHand(H6, H7, H8, H9, H10);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testStraightFlush1() {
//		PokerHand a = new PokerHand(C3, C4, C5, C6, C7);
//		PokerHand b = new PokerHand(H6, H7, H8, H9, H10);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testFourOfAKind1() {
//		PokerHand a = new PokerHand(C3, D3, H3, S3, CA);
//		PokerHand b = new PokerHand(C4, D4, H4, S4, C2);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testFourOfAKind2() {
//		PokerHand a = new PokerHand(C5, D5, H5, S5, CA);
//		PokerHand b = new PokerHand(C4, D4, H4, S4, C2);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testFullHouse1() {
//		PokerHand a = new PokerHand(C3, D3, H3, S6, D6);
//		PokerHand b = new PokerHand(H4, S4, C4, D7, H7);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testFullHouse2() {
//		PokerHand a = new PokerHand(CK, DK, HK, S6, D6);
//		PokerHand b = new PokerHand(H4, S4, C4, D7, H7);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testFullHouse3() {
//		PokerHand a = new PokerHand(C3, D3, H3, S10, D10);
//		PokerHand b = new PokerHand(H4, S4, C4, D7, H7);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testFlush1() {
//		PokerHand a = new PokerHand(C3, C6, C7, C9, CQ);
//		PokerHand b = new PokerHand(H2, H5, H8, HJ, HQ);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testFlush2() {
//		PokerHand a = new PokerHand(C3, C5, C8, CJ, CQ);
//		PokerHand b = new PokerHand(H2, H5, H8, HJ, HQ);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testStraight1() {
//		PokerHand a = new PokerHand(C3, D4, H5, S6, C7);
//		PokerHand b = new PokerHand(H2, C3, D4, H5, S6);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testStraight2() {
//		PokerHand a = new PokerHand(C3, D4, H5, S6, C7);
//		PokerHand b = new PokerHand(H4, C5, D6, H7, S8);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testStraight3() {
//		PokerHand a = new PokerHand(C3, D4, H5, S6, C7);
//		PokerHand b = new PokerHand(H3, C4, D5, H6, S7);
//		assertTrue(a.compareTo(b) == 0);
//	}
//
//	@Test
//	public void testThreeOfAKind1() {
//		PokerHand a = new PokerHand(C3, D3, H3, S5, D7);
//		PokerHand b = new PokerHand(C4, D4, H4, SA, H2);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testThreeOfAKind2() {
//		PokerHand a = new PokerHand(C5, D5, H5, S2, D3);
//		PokerHand b = new PokerHand(C4, D4, H4, SA, HK);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testTwoPair1() {
//		PokerHand a = new PokerHand(C3, D3, H5, S5, CA);
//		PokerHand b = new PokerHand(C4, D4, H6, S6, D2);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testTwoPair2() {
//		PokerHand a = new PokerHand(C3, D3, H7, S7, CA);
//		PokerHand b = new PokerHand(C4, D4, H6, S6, D2);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testTwoPair3() {
//		PokerHand a = new PokerHand(C3, D3, H7, S7, CA);
//		PokerHand b = new PokerHand(C4, D4, H6, S6, D2);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testTwoPair4() {
//		PokerHand a = new PokerHand(C3, D3, H5, S7, C7);
//		PokerHand b = new PokerHand(C4, D4, H6, S6, D2);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testOnePair1() {
//		PokerHand a = new PokerHand(C3, D3, H5, S7, CA);
//		PokerHand b = new PokerHand(C4, D4, H6, S8, D2);
//		assertTrue(a.compareTo(b) < 0);
//	}
//
//	@Test
//	public void testOnePair2() {
//		PokerHand a = new PokerHand(C5, D5, H2, S3, C6);
//		PokerHand b = new PokerHand(C4, D4, H6, S2, D3);
//		assertTrue(a.compareTo(b) > 0);
//	}
//
//	@Test
//	public void testOnePair3() {
//		PokerHand a = new PokerHand(H5, D5, H2, S3, C6);
//		PokerHand b = new PokerHand(C5, S5, S2, D3, D6);
//		assertTrue(a.compareTo(b) == 0);
//	}

}