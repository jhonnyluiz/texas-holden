package br.com.jlcabral.core.calculator;

import java.util.List;
import java.util.Map;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public class PairCalculator extends AbstractCalculator {

	public PairCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> mapCards = getMapEqualsNumber(getCards(), 2);
		if (mapCards.size() == 1) {
			mapCards.forEach((i, list) -> addHand(HandFactory.pair(list)));
			completeHand();
		}
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.PAIR;
	}

}
