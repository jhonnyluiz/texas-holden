package br.com.jlcabral.core.enumerated;

public enum SuitEnum {

	CLUBS(1, "Paus"),  DIAMONDS(2, "Ouros"), HEARTS(3, "Copas"), SPADES(4, "Espadas");
	
	private Integer code;
	private String description;
	
	SuitEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static SuitEnum byCode(Integer code) {
		for (SuitEnum e : SuitEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Codigo NaipeEnum inválido, code=" + code) ;
	}
}
