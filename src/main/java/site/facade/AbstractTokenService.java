package site.facade;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.springframework.security.core.token.Sha512DigestUtils;

import site.model.AbstractToken;
import site.model.ResetPasswordToken;
import site.model.User;
import site.repository.TokenRepository;

public abstract class AbstractTokenService {
	
	
	protected abstract String createNewToken(User user);
	
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
}
