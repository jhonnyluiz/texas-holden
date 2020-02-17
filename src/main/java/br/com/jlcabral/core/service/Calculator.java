package br.com.jlcabral.core.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import lombok.Getter;

@Getter
public class Calculator {

	private final List<Card> cards;
	private List<ReferenceHand> referHands = new ArrayList<>();

	public Calculator(List<Card> cardCommon, List<Card> cardPlayer) {
		cards = new ArrayList<>(cardPlayer);
		cards.addAll(cardCommon);
	}

	public void calculate() {
		pairThreeFour();
		fullHouseTwoPair();
	}

	private void pairThreeFour() {
		for (Card card : cards) {
			Integer i = Collections.frequency(getCardsId(), card.getRack().getCode());
			if (i == 2) {
				addRefer(new ReferenceHand(getCards(card), HandCombinationEnum.PAIR));
			} else if (i == 3) {
				addRefer(new ReferenceHand(getCards(card), HandCombinationEnum.THREE));
			} else if (i == 4) {
				addRefer(new ReferenceHand(getCards(card), HandCombinationEnum.FOUR));
			}

		}
	}

	private List<Card> getCards(Card card) {
		return cards.stream().filter(c -> c.getRack().getCode().equals(card.getRack().getCode()))
				.collect(Collectors.toList());
	}

	private void fullHouseTwoPair() {
		if (getCombination(HandCombinationEnum.FOUR).size() == 0 && referHands.size() > 1) {
			List<ReferenceHand> newRefer = new ArrayList<>();
			List<ReferenceHand> threes = getCombination(HandCombinationEnum.THREE);
			if (threes.size() > 0) {
				newRefer = getMaxThree(threes);
			} 
			referHands = newRefer;
		}
	}

	private List<ReferenceHand> getMaxThree(List<ReferenceHand> threes) {
		List<ReferenceHand> listThree = new ArrayList<>();
		listThree.add(threes.get(0));
		if (threes.size() > 1) {
			listThree = new ArrayList<>();
			if (maiorCardCode(threes.get(1), threes.get(0))) {
				listThree.add(threes.get(1));
				listThree.add(new ReferenceHand(threes.get(0).getCards().subList(0, 1), HandCombinationEnum.PAIR));
			} else {
				listThree.add(threes.get(0));
				listThree.add(new ReferenceHand(threes.get(1).getCards().subList(0, 1), HandCombinationEnum.PAIR));	
			}
		}

		return listThree;
	}

	private boolean maiorCardCode(ReferenceHand refer1, ReferenceHand refer2) {
		return refer1.getRackCode() > refer2.getRackCode();
	}

	private void addRefer(ReferenceHand refer) {
		if (referHands.stream().filter(r -> r.equalsRack(refer)).count() == 0) {
			referHands.add(refer);
		}
	}

	private List<Integer> getCardsId() {
		List<Integer> cardsId = cards.stream().map(c -> c.getRack().getCode()).collect(Collectors.toList());
		Collections.sort(cardsId, Collections.reverseOrder());
		return cardsId;
	}

	private List<ReferenceHand> getCombination(HandCombinationEnum comb) {
		return referHands.stream().filter(r -> comb.getCode().equals(r.getCombination().getCode()))
				.collect(Collectors.toList());
	}
}
