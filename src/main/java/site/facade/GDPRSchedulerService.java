package site.facade;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class GDPRSchedulerService {
	
	public void sendEmails() {
		if(user != null) {
			String tokenId = GDPRTokenService.createNewToken(user);

			try {
				String mailContent = buildResetMailContent(user, tokenId, "/resetPasswordMail.html");
				String mailTitle = "Reset your JPrime password";
				mailService.sendEmail(email, mailTitle, mailContent);
			} catch (MessagingException | IOException | URISyntaxException e) {
			    logger.error("Error while sending ResetPassword Mail to  " + user, e);
			}
		}
		redirectAttrs.addFlashAttribute("sent_to_email", email);
	}
}
