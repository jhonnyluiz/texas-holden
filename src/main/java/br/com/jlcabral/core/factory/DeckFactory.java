package br.com.jlcabral.core.factory;

import java.util.ArrayList;
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
		List<Card> deck = new ArrayList<Card>();
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
		List<Card> deckCut = new ArrayList<Card>();
		Random random = new Random();
		Integer indexDeck = 0;
		for (int i = 0; i < numberCorte; i++) {
			Integer numberCut = indexDeck + random.nextInt(52/numberCorte);
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
}
