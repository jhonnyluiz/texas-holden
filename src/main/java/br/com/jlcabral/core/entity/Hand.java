package br.com.jlcabral.core.entity;

import java.util.List;

import br.com.jlcabral.core.enumerated.TypeModelPokerEnum;
import br.com.jlcabral.core.factory.DeckFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Hand extends AbstractEntity {
	private static final long serialVersionUID = -184393359164417143L;

	private Long id;
	private final Table table;
	private final List<Player> players;
	private final List<Card> deck;
	private final TypeModelPokerEnum model;

	public Hand(Table t, List<Player> p, TypeModelPokerEnum ty) {
		this.table = t;
		this.model = ty;
		this.players = p;
		this.deck = DeckFactory.shuffleDeck(DeckFactory.getDeck());
	}

	public Integer getQtCardsPlayer() {
		return getModel().getType().getQtCardsPlayer();
	}

	public Integer getQtCardsFlop() {
		return getModel().getType().getQtCardsFlop();
	}

	public Integer getQtMaxPlayers() {
		return getModel().getType().getQtMaxPlayers();
	}
	
	public Card getCard(Integer i) {
		return getDeck().get(i);
	}
	
	public Integer getQtPlayers() {
		return getPlayers().size();
	}
	
	public Integer getIndexFlop() {
		return (getQtCardsPlayer() * getQtPlayers()) + 1;
	}
	
	public Integer getIndexTurn() {
		return getIndexFlop() + getQtCardsFlop() + 1;
	}
	
	public Integer getIndexRiver() {
		return getIndexTurn() + 2;
	}
	
	public Integer getIndexPlayer(Player player) {
		for (int i = 0; i < players.size(); i++) {
			if (player.equals(players.get(i))) {
				return i;
			}
		}
		throw new IllegalArgumentException("O Player não pertence a esta mão.");
	}
}
