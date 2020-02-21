package br.com.jlcabral.core.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.NumberEnum;
import br.com.jlcabral.core.enumerated.SuitEnum;

public class DeckFactory {

	private DeckFactory() {
	}

	public static List<Card> getDeck() {
		List<Card> deck = new ArrayList<>();
		for (SuitEnum suit : SuitEnum.values()) {
			for (NumberEnum number : NumberEnum.values()) {
				deck.add(new Card(suit, number));
			}
		}
		return deck;
	}

	public static List<Card> shuffleDeck(List<Card> deck) {
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		List<Card> deckShuffle = cut(deck, 1);
		Collections.shuffle(deckShuffle);
		deckShuffle = cut(deckShuffle, 2);
		return deckShuffle;
	}

	private static List<Card> cut(List<Card> deck, Integer numberCorte) {
		List<Card> deckCut = new ArrayList<>();
		Random random = new Random();
		Integer indexDeck = 0;
		for (int i = 0; i < numberCorte; i++) {
			Integer numberCut = indexDeck + random.nextInt(52 / numberCorte);
			for (int j = indexDeck; j < numberCut; j++) {
				deckCut.add(deck.get(j));
			}
			indexDeck = numberCut;
		}
		for (int k = indexDeck; k < 52; k++) {
			deckCut.add(deck.get(k));
		}
		return deckCut;
	}

	public static List<Card> getTwoPair() {
		return Arrays.asList(new Card(SuitEnum.CLUBS, NumberEnum.TWO), new Card(SuitEnum.DIAMONDS, NumberEnum.TWO),
				new Card(SuitEnum.HEARTS, NumberEnum.THREE), new Card(SuitEnum.CLUBS, NumberEnum.THREE),
				new Card(SuitEnum.SPADES, NumberEnum.FOUR));
	}
	
	public static List<Card> getCardsFullHouse() {
		return Arrays.asList(new Card(SuitEnum.CLUBS, NumberEnum.TWO), new Card(SuitEnum.DIAMONDS, NumberEnum.TWO),
				new Card(SuitEnum.HEARTS, NumberEnum.TWO), new Card(SuitEnum.CLUBS, NumberEnum.THREE),
				new Card(SuitEnum.SPADES, NumberEnum.THREE));
	}
	
	public static List<Card> getCardsStraighFlush() {
		return Arrays.asList(new Card(SuitEnum.HEARTS, NumberEnum.TWO), new Card(SuitEnum.HEARTS, NumberEnum.THREE),
				new Card(SuitEnum.HEARTS, NumberEnum.FOUR), new Card(SuitEnum.HEARTS, NumberEnum.FIVE),
				new Card(SuitEnum.HEARTS, NumberEnum.SIX));
	}
	
	public static List<Card> getCardsRoyalStraighFlush() {
		return Arrays.asList(new Card(SuitEnum.HEARTS, NumberEnum.ACE), new Card(SuitEnum.HEARTS, NumberEnum.KING),
				new Card(SuitEnum.HEARTS, NumberEnum.QUEEN), new Card(SuitEnum.HEARTS, NumberEnum.JACK),
				new Card(SuitEnum.HEARTS, NumberEnum.TEN));
	}
	
	public static List<Card> getCards4RoyalStraighFlush() {
		return Arrays.asList(new Card(SuitEnum.SPADES, NumberEnum.TWO), new Card(SuitEnum.HEARTS, NumberEnum.KING),
				new Card(SuitEnum.HEARTS, NumberEnum.QUEEN), new Card(SuitEnum.HEARTS, NumberEnum.JACK),
				new Card(SuitEnum.HEARTS, NumberEnum.TEN));
	}
	
	public static List<Card> getCardsFlush() {
		return Arrays.asList(new Card(SuitEnum.HEARTS, NumberEnum.TWO), new Card(SuitEnum.HEARTS, NumberEnum.THREE),
				new Card(SuitEnum.HEARTS, NumberEnum.NINE), new Card(SuitEnum.HEARTS, NumberEnum.ACE),
				new Card(SuitEnum.HEARTS, NumberEnum.JACK));
	}
	
	public static List<Card> getCardsStraigh() {
		return Arrays.asList(new Card(SuitEnum.CLUBS, NumberEnum.TWO), new Card(SuitEnum.DIAMONDS, NumberEnum.THREE),
				new Card(SuitEnum.HEARTS, NumberEnum.FOUR), new Card(SuitEnum.CLUBS, NumberEnum.FIVE),
				new Card(SuitEnum.SPADES, NumberEnum.SIX));
	}
	
	public static List<Card> getCardsMinStraigh() {
		return Arrays.asList(new Card(SuitEnum.CLUBS, NumberEnum.TWO), new Card(SuitEnum.DIAMONDS, NumberEnum.THREE),
				new Card(SuitEnum.HEARTS, NumberEnum.FOUR), new Card(SuitEnum.CLUBS, NumberEnum.FIVE),
				new Card(SuitEnum.SPADES, NumberEnum.ACE));
	}
}
