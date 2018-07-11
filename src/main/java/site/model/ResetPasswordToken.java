package site.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ResetPasswordToken")
public class ResetPasswordToken extends AbstractToken {

	private boolean used = false;

	public ResetPasswordToken() {
		super();
	}

	public ResetPasswordToken(User owner, String tokenId) {
		super(owner, tokenId);
	}

	@Override
	public String toString() {
		return "ResetPasswordToken [owner=" + this.getOwner() + ", tokenId=" + this.getTokenId() + ", used=" + used + "]";
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResetPasswordToken other = (ResetPasswordToken) obj;
		if (getOwner() == null) {
			if (other.getOwner() != null)
				return false;
		} else if (!getOwner().equals(other.getOwner()))
			return false;
		if (getTokenId() == null) {
			if (other.getTokenId() != null)
				return false;
		} else if (!getTokenId().equals(other.getTokenId()))
			return false;
		if (used != other.used)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
		result = prime * result + ((getTokenId() == null) ? 0 : getTokenId().hashCode());
		result = prime * result + (used ? 1231 : 1237);
		return result;
	}


}
