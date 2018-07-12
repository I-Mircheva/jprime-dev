package site.facade;

import org.springframework.beans.factory.annotation.Autowired;
import site.model.AbstractToken;
import site.model.GDPRToken;
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
