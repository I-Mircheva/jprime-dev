package site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import site.model.User;

@Repository(value = UserRepository.NAME)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	String GET_USERS_BY_NOT_ACCEPTED_OR_REJECTED_GDPR = "SELECT u FROM User u LEFT JOIN GDPRToken gt ON u = gt.owner"
			+ " WHERE gt.accepted = false OR gt IS NULL";
	
	String NAME = "userRepository";

	List<User> findByEmail(String email);
	
	public User findUserByEmail(String email);
	
	@Query(GET_USERS_BY_NOT_ACCEPTED_OR_REJECTED_GDPR)
    List<User> findAllUsersNotAcceptedOrRejectedGDPR();
	

}
