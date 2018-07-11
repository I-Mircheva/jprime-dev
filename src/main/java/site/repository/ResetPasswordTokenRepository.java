package site.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.model.ResetPasswordToken;
import site.model.User;

/**
 * @author Zhorzh Raychev
 */
@Repository(value = ResetPasswordTokenRepository.NAME)
public interface ResetPasswordTokenRepository extends AbstractTokenRepository<ResetPasswordToken, Long>{

	String NAME = "resetPasswordTokenRepository";

	ResetPasswordToken findByTokenId(String tokenId);

	List<ResetPasswordToken> findAllByOwner(User owner);
}
