package br.com.jlcabral.core.running;

import java.util.List;

import br.com.jlcabral.core.calculator.CalculatorHands;
import br.com.jlcabral.core.calculator.PairCalculator;
import br.com.jlcabral.core.entity.Hand;
import br.com.jlcabral.core.entity.Player;
import br.com.jlcabral.core.entity.Table;
import br.com.jlcabral.core.entity.Tournament;
import br.com.jlcabral.core.enumerated.TypeModelPokerEnum;
import br.com.jlcabral.core.factory.PlayerFactory;
import br.com.jlcabral.core.service.Calculator;
import br.com.jlcabral.core.service.Dealer;

public class ApplicationTesteRunning {

	public static void main(String[] args) {
		List<Player> players = PlayerFactory.getPlayers();

		Table table = new Table(1L, new Tournament(), players);
		Hand hand = new Hand(table, players, TypeModelPokerEnum.TH_NINE);
//		Dealer d = new Dealer(hand);
//		System.out.println("COMMONS CARDS: " + d.getCardCommon());
		// showDeck(hand);
		// showHandPlayers(d, players);
		// showCard(Dealer d);
//		showHandPlayer(d, hand, players, 0);
		
//		PairCalculator pair = new PairCalculator(d.getCardCommon(), d.getCardPlayer(players.get(0)));
//		pair.calc();
//		System.out.println(pair.getReferHands());
		
		CalculatorHands.calcHands(hand);

	}

//	public static void showHandPlayer(Dealer d, Hand hand, List<Player> players, Integer playerId) {
//		Calculator calc = new Calculator(d.getCardCommon(), d.getCardPlayer(players.get(playerId)));
//		calc.calculate();
//		System.out.println(
//				"Player " + (playerId + 1) + ":" + d.getCardPlayer(players.get(playerId)) + calc.getReferHands());
//	}
//
//	public static void showHandPlayers(Dealer d, List<Player> players) {
//		for (int i = 0; i < players.size(); i++) {
//			System.out.println("Jog" + (i + 1) + ":" + d.getCardPlayer(players.get(i)));
//		}
//	}
//
//	public static void showCard(Dealer d) {
//		System.out.println();
//		System.out.println("############### FLOP #######################");
//		System.out.println("FLOP: " + d.getCardFlop());
//		System.out.println();
//		System.out.println("############### TURN #######################");
//		System.out.println("FLOP: " + d.getCardTurn());
//		System.out.println();
//		System.out.println("############### RIVER #######################");
//		System.out.println("FLOP: " + d.getCardRiver());
//		System.out.println();
//	}
//
//	public static void showDeck(Hand hand) {
//		System.out.println();
//		System.out.println("############### DECK #######################");
//		for (int id = 0; id < hand.getDeck().size(); id++) {
//			System.out.println((id + 1) + ":" + hand.getDeck().get(id));
//		}
//		System.out.println("############################################");
//		System.out.println();
//	}
}
