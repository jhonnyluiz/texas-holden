package br.com.jlcabral.core.enumerated;

public enum HandCombinationEnum {

	HIGH_CARD(1, 1, "Carta Alta"), PAIR(2, 2, "Par"), TWO_PAIR(3, 4, "Dois Pares"), THREE(4, 3, "Trinca"), 
	STRAIGHT(5, 5, "Sequência"), FLUSH(6, 5, "Flush"), FULL_HOUSE(7, 5, "Full House"), FOUR(8, 4, "Quadra"), 
	STRAIGHT_FLUSH(9, 5, "Straight Flush"), ROYAL_FLUSH(10, 5, "Royal Flush");
	
	
	private Integer code;
	private Integer qtCards;
	private String description;
	
	HandCombinationEnum(Integer code, Integer qtCards, String description){
		this.code = code;
		this.qtCards = qtCards;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public Integer getQtCards() {
		return qtCards;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static HandCombinationEnum byCode(Integer code) {
		for (HandCombinationEnum e : HandCombinationEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Codigo HandCombinationEnum inválido, code=" + code) ;
	}
	
}
