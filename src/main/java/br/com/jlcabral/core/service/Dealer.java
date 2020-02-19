package br.com.jlcabral.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.Hand;
import br.com.jlcabral.core.entity.Player;
import br.com.jlcabral.core.factory.DeckFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Dealer {

	private final Hand hand;

	public List<Card> getCardPlayer(Player player) {
		List<Card> cards = new ArrayList<>();
		for (int i = 0; i < hand.getQtCardsPlayer(); i++) {
			cards.add(hand.getCard(hand.getIndexPlayer(player) + (i * hand.getQtPlayers())));
		}
		return cards;
	}

	public List<Card> getCardFlop() {
		List<Card> cards = new ArrayList<>();
		for (int i = 0; i < hand.getQtCardsFlop(); i++) {
			cards.add(hand.getCard(hand.getIndexFlop() + i));
		}
		return cards;
	}

	public List<Card> getCardTurn() {
		return Arrays.asList(hand.getCard(hand.getIndexTurn()));
	}

	public List<Card> getCardRiver() {
		return Arrays.asList(hand.getCard(hand.getIndexRiver()));
	}

	public List<Card> getCardCommon() {
//		List<Card> cards = getCardFlop();
//		cards.addAll(getCardTurn());
//		cards.addAll(getCardRiver());
//		return cards;
//		return DeckFactory.getCardsMinStraigh();
		return DeckFactory.getCardsFullHouse();
	}
}
