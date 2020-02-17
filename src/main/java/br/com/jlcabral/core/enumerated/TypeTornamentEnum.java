package br.com.jlcabral.core.enumerated;

public enum TypeTornamentEnum {

	MTT(0, "Torneio"),  SNG(1, "Sit in Go"), CASH(2, "Cash");
	
	private Integer code;
	private String description;
	
	TypeTornamentEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TypeTornamentEnum byCode(Integer code) {
		for (TypeTornamentEnum e : TypeTornamentEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Codigo NaipeEnum inválido, code=" + code) ;
	}
}
