package br.com.jlcabral.core.enumerated;

public enum ActionEnum {

	CALL(1, "Call"), RAISE(2, "Raise"), FOLD(3, "Fold");
	
	private Integer code;
	private String description;
	
	ActionEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ActionEnum byCode(Integer code) {
		for (ActionEnum e : ActionEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Codigo ActionEnum inválido, code=" + code) ;
	}
}
