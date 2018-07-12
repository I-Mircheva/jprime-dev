package site.facade;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Service;

import site.model.AbstractToken;
import site.model.ResetPasswordToken;
import site.model.User;
import site.repository.AbstractTokenRepository;
import site.repository.ResetPasswordTokenRepository;

/**
 * @author Zhorzh Raychev
 */
@Service()
public class ResetPasswordTokenService extends AbstractTokenService{

	public ResetPasswordTokenService(ResetPasswordTokenRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Value("${site.reset.password.token.duration.hours:2}")
	private int TOKEN_DURATION_IN_HOURS;

	private static final Logger logger = LogManager.getLogger(ResetPasswordTokenService.class);

	@Autowired
	private ResetPasswordTokenRepository repository;



	/**
	 * @param tokenId
	 * @return User owning the token if tokenId is valid, return NULL if tokenId
	 *         is not valid
	 */
	public User checkTokenValidity(String tokenId) {

		String tokenShaHex = Sha512DigestUtils.shaHex(tokenId);
		ResetPasswordToken resetPasswordToken = repository.findByTokenId(tokenShaHex);
		if (resetPasswordToken == null) {
			logger.debug("ResetPasswordToken id=" + tokenId + " , ShaHex: " + tokenShaHex
					+ " NOT found. This could be an attacker brute forcing the token!");
			return null;
		}
		User owner = resetPasswordToken.getOwner();
		if (resetPasswordToken.isUsed()) {
			logger.debug("ResetPassworToken for user: " + owner + " with Id=" + tokenId + ", ShaHex: " + tokenShaHex
					+ " is aleady used.");
			return null;
		}

		DateTime createdDate = resetPasswordToken.getCreatedDate();
		DateTime deadline = createdDate.plusHours(TOKEN_DURATION_IN_HOURS);
		if (deadline.isBeforeNow()) {
			logger.debug("ResetPassworToken for user: " + owner + " with Id=" + tokenId + ", ShaHex: " + tokenShaHex
					+ "  is expired.");
			return null;
		}
		return owner;
	}

	public void setTokenToUsed(String tokenId) {

		String tokenShaHex = Sha512DigestUtils.shaHex(tokenId);
		ResetPasswordToken resetPasswordToken = repository.findByTokenId(tokenShaHex);
		User owner = resetPasswordToken.getOwner();
		List<ResetPasswordToken> tokens = repository.findAllByOwner(owner);
		for (ResetPasswordToken token : tokens) {
			token.setUsed(true);
		}
		repository.saveAll(tokens);
	}
	
	protected AbstractToken createEmptyToken() {
		return new ResetPasswordToken();
	}




}
