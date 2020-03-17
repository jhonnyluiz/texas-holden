package br.com.jlcabral.core.entity;

import java.util.List;

import br.com.jlcabral.core.enumerated.ActionHandEnum;
import lombok.Getter;

@Getter
public class ActionHand {

	private ActionHandEnum actionType;
	private List<ActionPlayer> actionsPlayer;
	
	public void getPlayersInAction() {
		
	}
}
