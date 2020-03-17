package br.com.jlcabral.core.calculator;

import java.util.List;
import java.util.Map;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;
import br.com.jlcabral.core.utils.ObjUtils;

public class RoyalFlushCalculator extends StrainghFlushCalculator {

	public RoyalFlushCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> cardsSuit = getMapEqualsSuit(getCards());
		if (cardsSuit.size() > 0) {
			List<Integer> mapIds = getMapCardsId(cardsSuit);
			ReferenceHand hand = getHand(cardsSuit.get(mapIds.get(0)));
			if(ObjUtils.isNotNull(hand) && isCardAce(hand.getCards())) {
				addHand(HandFactory.royal(hand.getCards()));
			}
		}
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.ROYAL_FLUSH;
	}

}
