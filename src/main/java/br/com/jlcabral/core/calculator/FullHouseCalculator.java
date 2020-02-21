package br.com.jlcabral.core.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public class FullHouseCalculator extends AbstractCalculator {

	public FullHouseCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> mapCards = getMapEqualsNumber(getCards(), 3);
		if (mapCards.size() == 2) {
			addHand(HandFactory.fullHouse(getMapCardsId(mapCards).stream()
					.flatMap(cardId -> mapCards.get(cardId).stream()).collect(Collectors.toList())));
		} else if (mapCards.size() == 1) {
			Map<Integer, List<Card>> mapCardsPair = getMapEqualsNumber(getCards(), 2);
			if(mapCardsPair.size() > 0) {
				List<Card> cardsFull = new ArrayList<>();
				mapCards.forEach((i, mc) -> cardsFull.addAll(mc));
				mapCardsPair.forEach((i, mc) -> cardsFull.addAll(mc));
				addHand(HandFactory.fullHouse(cardsFull));
			}
		}
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.FULL_HOUSE;
	}

}
