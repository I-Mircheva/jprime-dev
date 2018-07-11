package site.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public  abstract class AbstractToken extends AbstractEntity{

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
	private User owner;
	
	@Column(unique = true)
    @NotBlank
	private String tokenId;
	

	private boolean used = false;
	
	public AbstractToken() {
		
	}
	
	public AbstractToken(User owner, String tokenId) {
		this.owner = owner;
		this.tokenId = tokenId;
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
	
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}


	

	public User getOwner() {
		return owner;
	}
}
