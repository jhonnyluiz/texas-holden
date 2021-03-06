package br.com.jlcabral.core.calculator;

import java.util.List;
import java.util.Map;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public class ThreeCalculator extends AbstractCalculator {

	public ThreeCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> mapCards = getMapEqualsNumber(getCards(), 3);
		if (mapCards.size() == 1) {
			mapCards.forEach((i, cards) -> addHand(HandFactory.three(cards)));
			completeHand();
		}
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.THREE;
	}

}
