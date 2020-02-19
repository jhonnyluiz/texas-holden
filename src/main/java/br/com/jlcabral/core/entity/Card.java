package br.com.jlcabral.core.entity;

import java.io.Serializable;

import br.com.jlcabral.core.enumerated.NumberEnum;
import br.com.jlcabral.core.enumerated.SuitEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Comparable<Card>, Serializable {
	private static final long serialVersionUID = 4921696291909184566L;

	private SuitEnum suit;
	private NumberEnum rack;

	public String toString() {
		return rack.getDescription().concat(" de ").concat(suit.getDescription());
	}

	public Boolean isStraigh(Card c) {
		return c.getRack().getCode() == (getRack().getCode() - 1);
	}

	public Boolean isRackEqual(Card c) {
		return c.getRack().getCode() == getRack().getCode();
	}

	public Integer getNumber() {
		return getRack().getCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rack == null) ? 0 : rack.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rack != other.rack)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public int compareTo(Card outroCard) {
		if (this.rack.getCode() < outroCard.rack.getCode()) {
			return 1;
		}
		if (this.rack.getCode() > outroCard.rack.getCode()) {
			return -1;
		}
		return 0;
	}
}
