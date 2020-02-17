package br.com.jlcabral.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends AbstractEntity {
	private static final long serialVersionUID = 2875604977841284599L;

	private Long id;
	private String login;
}
