package site.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import site.model.ResetPasswordToken;
import site.model.User;

/**
 * @author Zhorzh Raychev
 */
@Repository(value = ResetPasswordTokenRepository.NAME)
public interface ResetPasswordTokenRepository extends PagingAndSortingRepository<ResetPasswordToken, Long>,  AbstractTokenRepository<ResetPasswordToken>{

	public static String NAME = "resetPasswordTokenRepository";

}
