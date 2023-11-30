package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
	private Deck deck;
	private Dealer dealer;
	private List<Player> players;
	private double pot;

	public Game() {
		// Initialize the deck, dealer, players, and pot
		deck = new Deck();
		dealer = new Dealer(deck);
		players = new ArrayList<>();
		pot = 0.0;
	}

	public void start() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Player.resetPlayerNumber();
			System.out.print("How many players? ");
			int numPlayers = scanner.nextInt();
			initializePlayers(numPlayers);
			
            deductAnte();
            
			// Deal initial cards
			dealer.dealCards(players, 2);

			// Deal community cards
			List<Card> communityCards = dealer.dealCommunityCards(5);

			// Show community cards
			System.out.println("\nCommunity Cards: " + formatCards(communityCards));

		    Map<Player, PokerHand> bestHands = determineHands(communityCards);

			// Evaluate and display best hands
			evaluateAndDisplayBestHands(bestHands);
			
			// Determine the winner
//			Player winner = determineWinner(communityCards);
		    Player winner = determineOverallWinner(bestHands);
		    updatePot(winner);
		    
			// Show the winner
			System.out.println("\nWinner: Player " + winner.getPlayerNumber() + " $" + winner.getBalance());

			// Prompt to play another game
			System.out.print("\nPlay another game? (y/n) ");
			String playAgain = scanner.next().toLowerCase();
			if (!playAgain.equals("y")) {
				break;
			}
		}

		System.out.println("\nGame Over. Thanks for playing!");
	}

	private void initializePlayers(int numPlayers) {
		players.clear();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player(100.0)); // Assuming starting balance is $100.0
		}
	}
	
	 private void deductAnte() {
	        for (Player player : players) {
	            player.deductBalance(2.0);
	            pot += 2.0; // Add the ante to the pot
	        }
	    }

    private void updatePot(Player winner) {
        winner.addBalance(pot);
        pot = 0.0; // Reset the pot for the next round
    }

	private void evaluateAndDisplayBestHands(Map<Player, PokerHand> bestHands) {	
		for (Map.Entry<Player, PokerHand> entry : bestHands.entrySet()) {
	        Player player = entry.getKey();
	        PokerHand bestHand = entry.getValue();

	        System.out.println("\n" + player);
	        System.out.println("Best Hand: " + formatCards(bestHand.getCards()) + "    Rank: " + bestHand.getHandRank());
	    }
	}
	
	private Map<Player, PokerHand> determineHands(List<Card> communityCards) {
	    Map<Player, PokerHand> bestHands = new LinkedHashMap<>();
	    PokerHand bestHand = null;

	    for (Player player : players) {
	        PokerHand playerBestHand = player.evaluateBestHand(communityCards);
	        bestHands.put(player, playerBestHand);

	        if (bestHand == null || playerBestHand.compareTo(bestHand) > 0) {
	            bestHand = playerBestHand;
	        }
	    }    
	    return bestHands;
	}
	
	private Player determineOverallWinner(Map<Player, PokerHand> bestHands) {
		Player winner = null;
	    int bestRank = -1;

	    for (Map.Entry<Player, PokerHand> entry : bestHands.entrySet()) {
	        Player player = entry.getKey();
	        PokerHand playerBestHand = entry.getValue();
	        int playerRank = playerBestHand.getRank();

	        if (playerRank > bestRank) {
	            bestRank = playerRank;
	            winner = player;
	        } else if (playerRank == bestRank) {
	        	List<Card> playerCards = player.getHand().getCards();
	            List<Card> winnerCards = winner.getHand().getCards();

	            for (int i = playerCards.size() - 1; i >= 0; i--) {
	                int cardComparison = playerCards.get(i).compareTo(winnerCards.get(i));

	                if (cardComparison > 0) {
	                    // Player has a higher card, update winner
	                    winner = player;
	                    break;
	                } else if (cardComparison < 0) {
	                	break;
	                }
	            }
	        }
	    }

	    return winner;
	}

	private String formatCards(List<Card> cards) {
		StringBuilder formattedCards = new StringBuilder();
		for (Card card : cards) {
			formattedCards.append(card).append(" ");
		}
		return formattedCards.toString();
	}

}
