package br.com.jlcabral.core.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;

public class PairCalculator extends AbstractCalculator {

	public PairCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> mapCards = getMapEqualsNumber(getCards(), 2);
		mapCards.size();
		mapCards.forEach((i, list) -> {
			System.out.println(list);
		});
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.PAIR;
	}

	
}
