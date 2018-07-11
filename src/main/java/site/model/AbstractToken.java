package site.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class AbstractToken extends AbstractEntity {

    private static final long serialVersionUID = -3626660176280247512L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User owner;

    @Column(unique = true)
    @NotBlank
    private String tokenId;

    public AbstractToken() {}

    public AbstractToken(User owner, String tokenId) {
        this.owner = owner;
        this.tokenId = tokenId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

}
