package br.com.jlcabral.core.calculator;

import static br.com.jlcabral.core.enumerated.NumberEnum.ACE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;

public class StrainghFlushCalculator extends StrainghCalculator {

	public StrainghFlushCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		super(cardCommon, cardPlayer);
	}

	@Override
	public void calc() {
		Map<Integer, List<Card>> cardsSuit = getMapEqualsSuit(getCards());
		if (cardsSuit.size() > 0) {
			List<Integer> mapIds = getMapCardsId(cardsSuit);
			addHand(getHand(cardsSuit.get(mapIds.get(0))));
		}
	}

	protected ReferenceHand getHand(List<Card> cardsSuit) {
		List<Card> cardsStraingh = new ArrayList<>();
		for (Card card : cardsSuit) {
			if (cardsStraingh.isEmpty()) {
				cardsStraingh.add(card);
			} else {
				addIfLast(cardsStraingh, card);
			}
		}
		return verifyStrainghAce(cardsStraingh) ? findAceSuitReturnHand(cardsStraingh, cardsSuit)
				: getStraingh(cardsStraingh);
	}

	protected ReferenceHand findAceSuitReturnHand(List<Card> cardsStraingh, List<Card> cardsSuit) {
		Optional<Card> ace = cardsSuit.stream().filter(c -> c.getNumber().equals(ACE.getCode())).findFirst();
		if (ace.isPresent()) {
			addIfLast(cardsStraingh, ace.get());
			return getStraingh(cardsStraingh);
		}
		return null;
	}

	@Override
	public HandCombinationEnum getCombinationCalc() {
		return HandCombinationEnum.STRAIGHT_FLUSH;
	}

}
