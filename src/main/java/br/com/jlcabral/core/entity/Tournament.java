package br.com.jlcabral.core.entity;

import br.com.jlcabral.core.enumerated.TypeTornamentEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tournament extends AbstractEntity {
	private static final long serialVersionUID = -2714569522268526369L;

	private Long id;
	private String name;
	private TypeTornamentEnum type;
}
