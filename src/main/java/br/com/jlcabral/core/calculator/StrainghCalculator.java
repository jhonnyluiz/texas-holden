package br.com.jlcabral.core.calculator;

import java.util.List;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;

public class StrainghCalculator extends AbstractCalculator {

	public StrainghCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {

	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.STRAIGHT;
	}

}
