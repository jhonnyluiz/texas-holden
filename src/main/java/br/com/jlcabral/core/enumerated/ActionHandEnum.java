package br.com.jlcabral.core.enumerated;

public enum ActionHandEnum {

	PRE_FLOP(1, "Pré-Flop"),  FLOP(2, "Flop"), TURN(3, "Turn"), RIVER(4, "River");
	
	private Integer code;
	private String description;
	
	ActionHandEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ActionHandEnum byCode(Integer code) {
		for (ActionHandEnum e : ActionHandEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Codigo ActionHandEnum inválido, code=" + code) ;
	}
}
