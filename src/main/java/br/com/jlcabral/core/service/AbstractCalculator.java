package br.com.jlcabral.core.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.jlcabral.core.ObjUtils;
import br.com.jlcabral.core.entity.Card;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import br.com.jlcabral.core.factory.HandFactory;

public abstract class AbstractCalculator implements ICalculator {

	private static final int MAX_CARDS = 5;
	private final List<Card> cards;
	private List<ReferenceHand> referHands;

	public AbstractCalculator(List<Card> cardCommon, List<Card> cardPlayer) {
		cards = new ArrayList<>();
		cards.addAll(cardPlayer);
		cards.addAll(cardCommon);
		Collections.sort(cards);
		initReferHands();
	}

	public void completeHand() {
		if (isHand() && getQtCompleteHand() > 0) {
			for (int i = 0; i < getQtCompleteHand(); i++) {
				addHand(getHighCard(i));
			}
		}
	}

	private ReferenceHand getHighCard(Integer indexHighCard) {
		List<Card> cardsAvailable = getCardsAvailable(getHand().getCards());
		Collections.sort(cardsAvailable);
		return HandFactory.highCard(cardsAvailable.get(indexHighCard));
	}

	private List<Card> getCardsAvailable(List<Card> removeCardsHand) {
		List<Card> cardsAvailable = new ArrayList<>();
		cards.forEach(c -> {
			Optional<Card> card = removeCardsHand.stream().filter(rc -> rc.equals(c)).findFirst();
			if (!card.isPresent()) {
				cardsAvailable.add(c);
			}
		});
		return cardsAvailable;
	}

	public List<ReferenceHand> getForceHand() {
		Collections.sort(referHands);
		return referHands;
	}

	public ReferenceHand getHand() {
		return referHands.get(0);
	}

	@Override
	public Boolean isHand() {
		if (!referHands.isEmpty()) {
			ReferenceHand bestHand = getForceHand().get(0);
			return eqHandCombination(getCombinationCalc(), bestHand.getCombination());
		}
		return Boolean.FALSE;
	}
	
	public Map<Integer, List<Card>> getMapEqualsNumber(List<Card> cards, Integer qtRepeat) {
		Map<Integer, List<Card>> mapCards = cards.stream().collect(Collectors.groupingBy(Card::getNumber));
		getCardsId(getCards()).forEach(idCard -> {
			if (mapCards.get(idCard).size() != qtRepeat) {
				mapCards.remove(idCard);
			}
		});
		return mapCards;
	}

	protected List<Integer> getCardsId(List<Card> cards) {
		List<Integer> cardsId = cards.stream().map(c -> c.getRack().getCode()).distinct().collect(Collectors.toList());
		Collections.sort(cardsId, Collections.reverseOrder());
		return cardsId;
	}

	public void addHand(ReferenceHand ref) {
		if (ObjUtils.isNotNull(ref)) {
			referHands.add(ref);
		} else {
			initReferHands();
		}
	}

	public void initReferHands() {
		referHands = new ArrayList<>();
	}

	private Boolean eqHandCombination(HandCombinationEnum h1, HandCombinationEnum h2) {
		return h1.getCode().equals(h2);
	}

	protected Integer getQtCompleteHand() {
		return MAX_CARDS - getCombinationCalc().getQtCards();
	}

	public List<ReferenceHand> getReferHands() {
		return referHands;
	}

	public void setReferHands(List<ReferenceHand> referHands) {
		this.referHands = referHands;
	}

	public List<Card> getCards() {
		return cards;
	}

}
