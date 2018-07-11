package site.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "GDPRToken")
public class GDPRToken extends AbstractToken {

    public GDPRToken() {
        super();
    }

    public GDPRToken(User owner, String tokenId) {
        super();
    }

    private boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "GDPR Token [owner=" + this.getOwner() + ", tokenId=" + this.getTokenId() + ", Accepted=" + accepted + "]";
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
        GDPRToken gdprToken = (GDPRToken) obj;
        return isAccepted() == gdprToken.isAccepted();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getTokenId() == null) ? 0 : getTokenId().hashCode());
        result = prime * result + (isAccepted() ? 1231 : 1237);
        return result;
    }
}