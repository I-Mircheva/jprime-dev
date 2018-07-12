package site.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.model.ResetPasswordToken;
import site.model.User;

/**
 * @author Zhorzh Raychev
 */
@Repository(value = ResetPasswordTokenRepository.NAME)
public interface ResetPasswordTokenRepository extends AbstractTokenRepository<ResetPasswordToken>{
	String NAME = "resetPasswordTokenRepository";
	
}
