package br.com.jlcabral.core.calculator;

import static br.com.jlcabral.core.enumerated.NumberEnum.ACE;
import static br.com.jlcabral.core.enumerated.NumberEnum.FIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public class StrainghCalculator extends AbstractCalculator {

	public StrainghCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		List<Card> cardsStraingh = new ArrayList<>();
		for (Card card : getCards()) {
			if (cardsStraingh.isEmpty()) {
				cardsStraingh.add(card);
			} else {
				addIfLast(cardsStraingh, card);
			}
		}
		addHand(verifyStrainghAce(cardsStraingh) ? findAceReturnHand(cardsStraingh) : getStraingh(cardsStraingh));

	}

	protected ReferenceHand getStraingh(List<Card> cardsStraingh) {
		System.out.println("getStraingh true");
		if (cardsStraingh.size() > 4) {
			return HandFactory.to(cardsStraingh.subList(0, 4), getCombinationCalc());
		}
		return null;
	}

	protected ReferenceHand findAceReturnHand(List<Card> cardsStraingh) {
		Optional<Card> ace = getCards().stream().filter(c -> c.getNumber().equals(ACE.getCode())).findFirst();
		if (ace.isPresent()) {
			addIfLast(cardsStraingh, ace.get());
			return getStraingh(cardsStraingh);
		}
		return null;
	}

	protected boolean verifyStrainghAce(List<Card> cardsStraingh) {
		return cardsStraingh.size() == 4 && isCardFive(cardsStraingh);
	}

	protected boolean isCardFive(List<Card> cardsStraingh) {
		return FIVE.getCode().equals(cardsStraingh.get(0).getNumber());
	}
	
	protected boolean isCardAce(List<Card> cardsStraingh) {
		return ACE.getCode().equals(cardsStraingh.get(0).getNumber());
	}

	protected void addIfLast(List<Card> cardsStraingh, Card card) {
		Card lastCard = cardsStraingh.get(cardsStraingh.size() - 1);
		if (isNotPair(card, lastCard)) {
			if (isNumberAnt(card, lastCard)) {
				cardsStraingh.clear();
			}
			cardsStraingh.add(card);
		}
	}

	protected boolean isNotPair(Card card, Card lastCard) {
		return card.getNumber() != lastCard.getNumber();
	}

	protected boolean isNumberAnt(Card card, Card lastCard) {
		return card.getNumber() != lastCard.getNumber() - 1;
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.STRAIGHT;
	}

}
