package br.com.jlcabral.core.entity;

import java.util.List;

import br.com.jlcabral.core.enumerated.HandCombinationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReferenceHand {

	private final List<Card> cards;
	private final HandCombinationEnum combination;

	public boolean equalsRack(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenceHand other = (ReferenceHand) obj;
		return getRackCode().equals(other.getRackCode());
	}

	public boolean equalsSuit(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenceHand other = (ReferenceHand) obj;
		return getSuitCode().equals(other.getSuitCode());
	}

	@Override
	public String toString() {
		return combination.getDescription() + " de " + cards.get(0).getRack().getDescription();
	}

	public Integer getRackCode() {
		return cards.get(0).getRack().getCode();
	}

	public Integer getSuitCode() {
		return cards.get(0).getSuit().getCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		result = prime * result + ((combination == null) ? 0 : combination.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenceHand other = (ReferenceHand) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		if (combination != other.combination)
			return false;
		return true;
	}
}
