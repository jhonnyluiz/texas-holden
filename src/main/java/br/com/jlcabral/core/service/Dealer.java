package br.com.jlcabral.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.Hand;
import br.com.jlcabral.core.entity.Player;

public class Dealer {

	private Dealer() {
	}

	public static List<Card> cardsPlayer(Hand hand, Player player) {
		List<Card> cards = new ArrayList<>();
		for (int i = 0; i < hand.getQtCardsPlayer(); i++) {
			cards.add(hand.getCard(hand.getIndexPlayer(player) + (i * hand.getQtPlayers())));
		}
		return cards;
	}

	public static List<Card> cardsFlop(Hand hand) {
		List<Card> cards = new ArrayList<>();
		for (int i = 0; i < hand.getQtCardsFlop(); i++) {
			cards.add(hand.getCard(hand.getIndexFlop() + i));
		}
		return cards;
	}

	public static List<Card> cardTurn(Hand hand) {
		return Arrays.asList(hand.getCard(hand.getIndexTurn()));
	}

	public static List<Card> cardRiver(Hand hand) {
		return Arrays.asList(hand.getCard(hand.getIndexRiver()));
	}

	public static List<Card> cardsCommon(Hand hand) {
		List<Card> cards = cardsFlop(hand);
		cards.addAll(cardTurn(hand));
		cards.addAll(cardRiver(hand));
		return cards;
//		return DeckFactory.getCardsRoyalStraighFlush();
//		return DeckFactory.getCards4RoyalStraighFlush();
//		return DeckFactory.getCardsStraighFlush();
//		return DeckFactory.getCardsMinStraigh();
//		return DeckFactory.getCardsFlush();
//		return DeckFactory.getCardsStraigh();
//		return DeckFactory.getCardsFullHouse();
//		return DeckFactory.getCardsFullHouse();
//		return DeckFactory.getTwoPair();
	}
}
