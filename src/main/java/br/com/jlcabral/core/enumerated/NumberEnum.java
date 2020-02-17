package br.com.jlcabral.core.enumerated;

public enum NumberEnum {

	TWO(1, "Dois"), THREE(2, "Três"), FOUR(3, "Quatro"), FIVE(4, "Cinco"), SIX(5, "Seis"), SEVEN(6, "Sete"),
	EIGHT(7, "Oito"), NINE(8, "Nove"), TEN(9, "Dez"), JACK(10, "Valete"), QUEEN(11, "Dama"), KING(12, "Rei"), ACE(13, "Ás"); 
	
	
	private Integer code;
	private String description;
	
	NumberEnum(Integer code, String description){
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
