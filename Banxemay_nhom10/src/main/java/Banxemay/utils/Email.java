package Banxemay.utils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.protobuf.Message;
import com.mysql.cj.Session;
import com.opensymphony.module.sitemesh.Config;

import Banxemay.models.Users;

public class Email {
	//Hàm mã code ngẫu nhiên
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}
	//send email to the user email
	public boolean sendEmail(Users user) {
		boolean test = false;
		
		String toEmail = user.getEmail();
		String fromEmail = "tung87252@gmail.com";
		String password = "12345678";
		
		try {
			// your host email smtp server details
			Properties pr = ConfigEmail(new Properties());
			
			// get session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			// set email message details
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain", "charset=UTF-8");
			// set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			// set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			// set email subject
			mess.setSubject("Confirm Password");
			
			// set message text
			mess.setText("Your is code: " + user.getCode());
			// send the message
			Transport.send(mess);
			
			test=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	
	
	private Properties ConfigEmail(Properties pr) {
		// your host email smtp server details
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactory.port", "587");
		pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		return pr;
	}

}
