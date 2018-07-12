package site.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.app.Application;
import site.model.GDPRToken;
import site.model.User;
import site.repository.GDPRTokenRepository;
import site.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GDPRTokenRepository gDPRTokenRepository;

	@Test
	public void getUsersByNotAcceptedGDPRMailTest() {
		
		User brianGoetz = new User("Brian", "Goetz", "email@gmail.com", "password", "phonee");
		User alexLaskin = new User("Alex", "Laskin", "email2@gmail.com", "password", "phone");
		User newUser = new User("User", "User1", "email3@gmail.com", "password", "phooone");
		
		userRepository.save(brianGoetz);
		userRepository.save(alexLaskin);
		userRepository.save(newUser);
		
		GDPRToken trueToken = new GDPRToken(userRepository
				.findUserByEmail("email@gmail.com"), "xyz");
		trueToken.setAccepted(true);
		gDPRTokenRepository.save(trueToken);
		
		GDPRToken falseToken = new GDPRToken(userRepository
				.findUserByEmail("email3@gmail.com"), "xyzz");
		
		falseToken.setAccepted(false);
		gDPRTokenRepository.save(falseToken);
		
		assertEquals(2, userRepository.findAllUsersNotAcceptedOrRejectedGDPR().size());
		
		
	}
	
}
