package br.com.jlcabral.core.calculator;

import java.util.List;
import java.util.Map;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public class FlushCalculator extends AbstractCalculator {

	public FlushCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> cardsSuit = getMapEqualsSuit(getCards());
		if (cardsSuit.size() > 0) {
			cardsSuit.forEach((idSuit, cards) -> {
				addHand(HandFactory.flush(cards.subList(0, 4)));
			});
		}
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.FLUSH;
	}

}
