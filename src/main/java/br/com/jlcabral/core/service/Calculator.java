package br.com.jlcabral.core.service;

import static br.com.jlcabral.core.enumerated.HandCombinationEnum.FULL_HOUSE;
import static br.com.jlcabral.core.enumerated.HandCombinationEnum.PAIR;

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
		Collections.sort(cards);
	}

	public void calculate() {
		pairThreeFour();
		fullHouse();
		straigh();
		Collections.sort(referHands);
	}

	private void straigh() {
		Integer count = 1;
		List<Card> cardsStraingh = new ArrayList<>();
		for (Card card : cards) {
			count = addListCardsStraingh(count, cardsStraingh, card);
		}
		validaStrainghAce(count, cardsStraingh);
		validaStraingh(count, cardsStraingh);
	}

	private Integer addListCardsStraingh(Integer count, List<Card> cardsStraingh, Card card) {
		if (!cardsStraingh.isEmpty() && cardsStraingh.get(count - 1).isStraigh(card)) {
			count++;
			cardsStraingh.add(card);
		} else {
			if (cardsStraingh.isEmpty()) {
				cardsStraingh.add(card);
			} else if (!cardsStraingh.get(count - 1).isRackEqual(card)) {
				count = 1;
				cardsStraingh.clear();
				cardsStraingh.add(card);
			}
		}
		return count;
	}

	private void validaStrainghAce(Integer count, List<Card> cardsStraingh) {
		if(count == 4 && cardsStraingh.get(0).getRack().getCode() == 4) {
			List<Card> aces = getCards().stream().filter(c -> c.getRack().getCode() == 13).collect(Collectors.toList());
			if(aces.size() > 0) {
				cardsStraingh.add(aces.get(0));
				referHands.clear();
				referHands.add(new ReferenceHand(cardsStraingh.subList(0, 4), HandCombinationEnum.STRAIGHT));
			}
		}
	}

	private void validaStraingh(Integer count, List<Card> cardsStraingh) {
		if (count >= 5) {
			referHands.clear();
			referHands.add(new ReferenceHand(cardsStraingh.subList(0, 4), HandCombinationEnum.STRAIGHT));
		}
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

	private void fullHouse() {
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
		if (threes.size() > 1) {
			if (maiorCardCode(threes.get(1), threes.get(0))) {
				listThree.add(new ReferenceHand(threes.get(1).getCards().subList(0, 1), FULL_HOUSE));
				listThree.add(new ReferenceHand(threes.get(0).getCards().subList(0, 1), PAIR));
			} else {
				listThree.add(new ReferenceHand(threes.get(0).getCards().subList(0, 1), FULL_HOUSE));
				listThree.add(new ReferenceHand(threes.get(1).getCards().subList(0, 1), PAIR));
			}
		} else if (referHands.size() > 1) {
			List<ReferenceHand> pairs = getCombination(PAIR);
			if (pairs.size() > 0) {
				listThree.add(new ReferenceHand(threes.get(0).getCards().subList(0, 1), FULL_HOUSE));
				listThree.add(new ReferenceHand(getMaxPair(), PAIR));
			}
		}

		return listThree;
	}

	private List<Card> getMaxPair() {
		List<ReferenceHand> refers = getCombination(HandCombinationEnum.PAIR);
		ReferenceHand ref = null;
		for (ReferenceHand r : refers) {
			if (ref != null) {
				if (r.getRackCode() > ref.getRackCode()) {
					ref = r;
				}
			} else {
				ref = r;
			}
		}
		return ref.getCards();
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
