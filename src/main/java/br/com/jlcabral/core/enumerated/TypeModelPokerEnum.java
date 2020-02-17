package br.com.jlcabral.core.enumerated;

import br.com.jlcabral.core.entity.ITypePoker;
import br.com.jlcabral.core.entity.NineOmaha;
import br.com.jlcabral.core.entity.NineTexas;

public enum TypeModelPokerEnum {
	
	TH_NINE(0, new NineTexas(), "Texas Holden"),  OMAHA_NINE(1, new NineOmaha(),"Omaha");
	
	private Integer code;
	private ITypePoker type;
	private String description;
	
	TypeModelPokerEnum(Integer code, ITypePoker type, String description) {
		this.code = code;
		this.type = type;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ITypePoker getType() {
		return type;
	}
	
	public static TypeModelPokerEnum byCode(Integer code) {
		for (TypeModelPokerEnum e : TypeModelPokerEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Codigo NaipeEnum inválido, code=" + code) ;
	}

}
