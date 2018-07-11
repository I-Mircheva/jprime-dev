package site.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;

import site.model.ResetPasswordToken;
import site.model.User;

public class GDPRService extends AbstractTokenService {

	@Autowired
	private GDPRTokenRepository repository;
	
	@Override
	protected String createNewToken(User user) {
		String tokenId = getNewTokenId();
		GDPRToken token = new GDPRToken(user, tokenId);
		token.setOwner(user);
		token.setTokenId(tokenId);
		String tokenShaHex = Sha512DigestUtils.shaHex(token.getTokenId());
		token.setTokenId(tokenShaHex);
		repository.save(token);

		return tokenId;
	}

}
