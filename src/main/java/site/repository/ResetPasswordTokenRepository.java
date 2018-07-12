package site.repository;

import org.springframework.stereotype.Repository;
import site.model.ResetPasswordToken;

/**
 * @author Zhorzh Raychev
 */
@Repository(value = ResetPasswordTokenRepository.NAME)
public interface ResetPasswordTokenRepository extends AbstractTokenRepository<ResetPasswordToken>{
	String NAME = "resetPasswordTokenRepository";
	
}
