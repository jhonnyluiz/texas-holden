package br.com.jlcabral.core.entity;

import java.io.Serializable;

import br.com.jlcabral.core.utils.ObjUtils;

public abstract class AbstractEntity implements Serializable {
	private static final long serialVersionUID = -3236542868087398530L;

	abstract Long getId();
	
	public Boolean isTransient() {
		return ObjUtils.isNull(getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		AbstractEntity other = (AbstractEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}
