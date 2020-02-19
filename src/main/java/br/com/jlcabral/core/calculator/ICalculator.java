package br.com.jlcabral.core.calculator;

import java.util.List;

import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;

public interface ICalculator {

	void calc();

	void completeHand();

	List<ReferenceHand> getForceHand();

	Boolean isHand();

	HandCombinationEnum getCombinationCalc();
}
