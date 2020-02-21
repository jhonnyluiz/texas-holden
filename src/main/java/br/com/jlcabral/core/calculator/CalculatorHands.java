package br.com.jlcabral.core.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jlcabral.core.entity.Hand;
import br.com.jlcabral.core.entity.Player;
import br.com.jlcabral.core.entity.ReferenceHand;
import br.com.jlcabral.core.service.Dealer;
import lombok.Getter;

@Getter
public class CalculatorHands {

	private CalculatorHands() {
	}

	public static List<ReferenceHand> calcHandPlayer(Hand hand, Player player, AbstractCalculator calculator) {
		calculator.calc();
		return calculator.getReferHands();
	}

	public static void calcHands(Hand hand) {
		for (Player player : hand.getPlayers()) {
			Optional<List<ReferenceHand>> l = getCalculators(hand, player).stream()
					.map(calc -> calcHandPlayer(hand, player, calc)).filter(list -> !list.isEmpty()).findFirst();
			System.out.println("Player:" + player.getId() + " " +(l.isPresent() ? l.get() : ""));
		}
	}

	public static List<AbstractCalculator> getCalculators(Hand hand, Player player) {
		List<AbstractCalculator> calcs = new ArrayList<>();
		calcs.add(new RoyalFlushCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new StrainghFlushCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new FourCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new FullHouseCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new FlushCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new StrainghCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new ThreeCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new TwoPairCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new PairCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		calcs.add(new HighCardCalculator(Dealer.cardsCommon(hand), Dealer.cardsPlayer(hand, player)));
		return calcs;
	}
}
