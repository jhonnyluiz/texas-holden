package br.com.jlcabral.core.entity;

import br.com.jlcabral.core.enumerated.ActionEnum;
import lombok.Getter;

@Getter
public class ActionPlayer {
	
	public ActionPlayer(ActionEnum a, Integer p) {
		this.action = a;
		this.price = p;
	}
	
	private ActionEnum action;
	private Integer price;

}
