package site.facade;

import org.springframework.security.core.token.Sha512DigestUtils;
import site.model.AbstractToken;
import site.model.User;
import site.repository.AbstractTokenRepository;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public abstract class AbstractTokenService {
	
	AbstractTokenRepository repository;
	
	public AbstractTokenService(AbstractTokenRepository repository) {
		this.repository = repository;
		
	}
	protected  String getNewTokenId() {
		SecureRandom random = getRandom();
		char[] chars = "abbbcdefghhiiijklmmnopqrstuuvwxyzz1234567899990".toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 128; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	protected SecureRandom getRandom() {
		SecureRandom random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG", "SUN");
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			random = new SecureRandom();
		}
		random.nextBytes(new byte[256]);

		return random;
	}
	
	public String createNewToken(User user) {
		String tokenId = getNewTokenId();
		AbstractToken token = createEmptyToken();
		token.setOwner(user);
		token.setTokenId(tokenId);
		String tokenShaHex = Sha512DigestUtils.shaHex(token.getTokenId());
		token.setTokenId(tokenShaHex);
		repository.save(token);

		return tokenId;
	}
	
	protected abstract AbstractToken createEmptyToken();
}
