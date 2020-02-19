package br.com.jlcabral.core.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public class TwoPairCalculator extends AbstractCalculator {

	public TwoPairCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> mapCards = getMapEqualsNumber(getCards(), 2);
		if (mapCards.size() == 2) {
			List<Card> pairCards = new ArrayList<>();
			mapCards.forEach((i, list) -> pairCards.addAll(list));
			addHand(HandFactory.twoPair(pairCards));
			completeHand();
		}
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.TWO_PAIR;
	}

}
