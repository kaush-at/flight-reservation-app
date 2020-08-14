package com.kaush.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Value("${com.kaush.flightreservation.itinerary.mail.attachment.name}")
	private String ITINERARY_RECIEPT;

	@Value("${com.kaush.flightreservation.itinerary.mail.body}")
	private String ITINERARY_MAIL_BODY ;

	@Value("${com.kaush.flightreservation.itinerary.mail.heading}")
	private String ITINERARY_MAIL_SUBJECT;
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true); // if we need to send attachment we use true otherwise it should false or bydefault it will be false
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(ITINERARY_MAIL_SUBJECT);
			messageHelper.setText(ITINERARY_MAIL_BODY);
			messageHelper.addAttachment(ITINERARY_RECIEPT, new File(filePath)); // whatever you pass here will attached to the email
			
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
	}
}
