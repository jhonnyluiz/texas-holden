package br.com.jlcabral.core.calculator;

import java.util.List;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;

public class HighCardCalculator extends AbstractCalculator {

	public HighCardCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
//		System.out.println("HighCardCalculator");
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.HIGH_CARD;
	}

}
