package br.com.jlcabral.core.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;

public class HandFactory {

	private HandFactory() {
	}

	public static ReferenceHand to(List<Card> cards, HandCombinationEnum combination) {
		return new ReferenceHand(cards, combination);
	}

	public static ReferenceHand highCard(Card c) {
		return new ReferenceHand(Arrays.asList(c), HandCombinationEnum.HIGH_CARD);
	}

	public static ReferenceHand pair(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.PAIR);
	}

	public static ReferenceHand twoPair(List<Card> pairOne, List<Card> pairTwo) {
		List<Card> list = new ArrayList<>(pairOne);
		list.addAll(pairTwo);
		return twoPair(list);
	}

	public static ReferenceHand twoPair(List<Card> pairs) {
		return new ReferenceHand(pairs, HandCombinationEnum.TWO_PAIR);
	}

	public static ReferenceHand three(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.THREE);
	}

	public static ReferenceHand straight(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.STRAIGHT);
	}

	public static ReferenceHand flush(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.FLUSH);
	}

	public static ReferenceHand fullHouse(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.FULL_HOUSE);
	}

	public static ReferenceHand four(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.FOUR);
	}

	public static ReferenceHand straightFlush(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.STRAIGHT_FLUSH);
	}

	public static ReferenceHand royal(List<Card> cards) {
		return new ReferenceHand(cards, HandCombinationEnum.ROYAL_FLUSH);
	}
}
