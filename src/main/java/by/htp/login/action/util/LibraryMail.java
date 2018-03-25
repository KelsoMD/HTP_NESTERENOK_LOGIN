package by.htp.login.action.util;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 

public class LibraryMail {
	
	 private static final String ENCODING = "UTF-8";
		
	private LibraryMail() {
		
	}
	    public static void sendSimpleMessage(String to)  throws MessagingException{ 
	    	String login = "aleksejnesterenok@gmail.com";
	    	String from = "aleksejnesterenok@gmail.com";
	    	String content = "content";
	    	String subject = "subj";
	    	String smtpPort = "25";
	    	String smtpHost = "aspmx.l.google.com";
	        Authenticator auth = new MyAuthenticator(login, "q11235813"); 
	 
	        Properties props = System.getProperties(); 
	        props.put("mail.smtp.port", smtpPort); 
	        props.put("mail.smtp.host", smtpHost); 
	        props.put("mail.smtp.auth", "true"); 
	        props.put("mail.mime.charset", ENCODING); 
	        Session session = Session.getDefaultInstance(props, auth); 
	 
	        Message msg = new MimeMessage(session); 
	        msg.setFrom(new InternetAddress(from)); 
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
	        msg.setSubject(subject); 
	        msg.setText(content); 
	        Transport.send(msg); 
	    } 
	} 
	 
	class MyAuthenticator extends Authenticator { 
	    private String user; 
	    private String password; 
	 
	    MyAuthenticator(String user, String password) { 
	        this.user = user; 
	        this.password = password; 
	    } 
	 @Override
	    public PasswordAuthentication getPasswordAuthentication() { 
	        return new PasswordAuthentication(this.user, this.password); 
	    } 
	}
