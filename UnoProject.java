import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UnoProject {
	
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		String[] sortedDeckOfCards = {
				
				// All colors have 2 of every number BESIDES 0's.
				
				"Red 0", "Red 1", "Red 2", "Red 3", "Red 4", "Red 5", "Red 6", "Red 7", "Red 8", "Red 9",
						 "Red 1", "Red 2", "Red 3", "Red 4", "Red 5", "Red 6", "Red 7", "Red 8", "Red 9",
				
				"Yellow 0", "Yellow 1", "Yellow 2", "Yellow 3", "Yellow 4", "Yellow 5", "Yellow 6", "Yellow 7", "Yellow 8", "Yellow 9",
							"Yellow 1", "Yellow 2", "Yellow 3", "Yellow 4", "Yellow 5", "Yellow 6", "Yellow 7", "Yellow 8", "Yellow 9",
				
				"Blue 0", "Blue 1", "Blue 2", "Blue 3", "Blue 4", "Blue 5", "Blue 6", "Blue 7", "Blue 8", "Blue 9",
						  "Blue 1", "Blue 2", "Blue 3", "Blue 4", "Blue 5", "Blue 6", "Blue 7", "Blue 8", "Blue 9",
				
				"Green 0", "Green 1", "Green 2", "Green 3", "Green 4", "Green 5", "Green 6", "Green 7", "Green 8", "Green 9",
						   "Green 1", "Green 2", "Green 3", "Green 4", "Green 5", "Green 6", "Green 7", "Green 8", "Green 9",
								};
		
		List<String> deckOfCards = new ArrayList<>(Arrays.asList(sortedDeckOfCards));
		
		// Creating the 2 players and placeholders for their cards
		
		ArrayList<String> player1 = new ArrayList<>();
		ArrayList<String> player2 = new ArrayList<>();
		
		
		
		// This FOR loop deals cards to the 2 players and removes those cards from the deck
		for (int i = 0; i != 7; i++) {
			
			// Picking a random card in the deck
			int pickRandomCard = random.nextInt(deckOfCards.size());
			// Adding the random card to the player's deck
			player1.add(deckOfCards.get(pickRandomCard));
			// Removes card picked from deck
			deckOfCards.remove(pickRandomCard);
			
			
			// Picking a random card in the deck
			pickRandomCard = random.nextInt(deckOfCards.size());
			// Adding the random card to the player's deck
			player2.add(deckOfCards.get(pickRandomCard));
			// Removes card picked from deck
			deckOfCards.remove(pickRandomCard);
		}
		
		
		System.out.println("Player 1 Deck: " + player1);
		System.out.println("Player 2 Deck: " + player2);
		
		
		// This block of code will pick a random card from the deck as a starting card
		int pickRandomCard = random.nextInt(deckOfCards.size());
		String cardOnTop = (deckOfCards.get(pickRandomCard));
		deckOfCards.remove(pickRandomCard);
		
		// the \n\n in the print statement creates a blank space. Helps read the console
		System.out.println("The starting card from the deck is a " + cardOnTop + "\n\n");
		
		// This block of code will find out the color of firstCardFromDeck and ensure only cards of the same color can be placed on each other
		String color;
		if (cardOnTop.contains("Red")) {
		    color = "Red";
		} else if (cardOnTop.contains("Blue")) {
		    color = "Blue";
		} else if (cardOnTop.contains("Yellow")) {
		    color = "Yellow";
		} else if (cardOnTop.contains("Green")) {
		    color = "Green";
		} else {
		    color = "Something is wrong with the game";
		}
		
		// if playerDeckContainsColor is 0 after for loop, player1 does not have that color. If it is greater than 0, player1 has that color.
		int playerDeckContainsColor = 0;
		
		while (deckOfCards.size() != 0) {

		for (int i = 0; i < player1.size(); i++) {
			if (player1.get(i).contains(color)) {
				System.out.println("Player 1 has a " + player1.get(i) + " and has placed it down! \n\n");
				playerDeckContainsColor += 1;
				cardOnTop = player1.get(i);
				player1.remove(i);
				break;
			}
		}
			if (playerDeckContainsColor == 0) {
				pickRandomCard = random.nextInt(deckOfCards.size());
				player1.add(deckOfCards.get(pickRandomCard));
				System.out.println("Player 1 did not have a " + color + ". He drew a " + deckOfCards.get(pickRandomCard) + "\n\n");
				deckOfCards.remove(pickRandomCard);
			}	
			
			
			
			playerDeckContainsColor = 0;

			for (int i = 0; i < player2.size(); i++) {
				if (player2.get(i).contains(color)) {
					System.out.println("Player 2 has a " + player2.get(i) + " and has placed it down! \n\n");
					playerDeckContainsColor += 1;
					cardOnTop = player2.get(i);
					player2.remove(i);
					break;
				}
			}
				if (playerDeckContainsColor == 0) {
					pickRandomCard = random.nextInt(deckOfCards.size());
					player2.add(deckOfCards.get(pickRandomCard));
					System.out.println("Player 2 did not have a " + color + ". He drew a " + deckOfCards.get(pickRandomCard) + "\n\n");
					deckOfCards.remove(pickRandomCard);
				}	
				
		}
		
		if (player1.size() > player2.size()) {
			int difference = player1.size() - player2.size();
			System.out.println("Player 2 wins by " + difference + " cards!");
			
		} else if (player2.size() > player1.size()) {
			int difference = player2.size() - player1.size();
			System.out.println("Player 1 wins by " + difference + " cards!");
			
		} else {
			System.out.println("There has been a tie!");
		}
			
			
			
		}
	}
