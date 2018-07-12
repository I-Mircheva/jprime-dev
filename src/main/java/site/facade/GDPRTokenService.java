package site.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;

import site.model.AbstractToken;
import site.model.GDPRToken;
import site.model.ResetPasswordToken;
import site.model.User;
import site.repository.GDPRTokenRepository;

public class GDPRTokenService extends AbstractTokenService {
	
	@Autowired
	public GDPRTokenService(GDPRTokenRepository repository) {
		super(repository);
	}

	@Override
	protected AbstractToken createEmptyToken() {
		return new GDPRToken();
	}

}
