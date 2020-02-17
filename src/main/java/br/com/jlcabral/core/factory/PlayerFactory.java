package br.com.jlcabral.core.factory;

import java.util.Arrays;
import java.util.List;

import br.com.jlcabral.core.entity.Player;

public class PlayerFactory {

	private PlayerFactory() {
	}

	public static List<Player> getPlayers() {
		Player playerOne = new Player(1L, "player-1");
		Player playerTwo = new Player(2L, "player-2");
		Player playerThree = new Player(3L, "player-3");
		Player playerFour = new Player(4L, "player-4");
		Player playerFive = new Player(5L, "player-5");
		Player playerSix = new Player(6L, "player-6");
		Player playerSeven = new Player(7L, "player-7");
		Player playerEight = new Player(8L, "player-8");
		Player playerNine = new Player(9L, "player-9");
		return Arrays.asList(playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven,
				playerEight, playerNine);
	}
}
