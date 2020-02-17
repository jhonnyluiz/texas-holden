package br.com.jlcabral.core.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table extends AbstractEntity {
	private static final long serialVersionUID = 5586139837173259836L;

	private Long id;
	private Tournament tournament;
	private List<Player> players;
}
