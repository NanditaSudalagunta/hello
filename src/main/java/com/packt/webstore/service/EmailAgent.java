package com.packt.webstore.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.sun.mail.util.MailSSLSocketFactory;

public class EmailAgent {			
			private String[] sendTo = {""};
			private String emailMsgTxt ; 
			private String emailSubjectTxt ;
			
			private int msgBodyType;

			public EmailAgent (String sendToAddr, int msgType) throws Exception {
				this.sendTo[0] = new String(sendToAddr);
				this.msgBodyType = msgType;
				
			}
			
			public EmailAgent (String sendToAddr, String emailMsgTxt, String emailSubjectTxt) throws Exception {
				this.sendTo[0] = new String(sendToAddr);
				this.emailMsgTxt = emailMsgTxt;
				this.emailSubjectTxt = emailSubjectTxt;
				}
			
			public EmailAgent(String[] recipients, int msgType) {
				this.sendTo = new String[recipients.length];
				for(int i=0;i<recipients.length;i++){
					this.sendTo[i]=recipients[i];
				}
				this.msgBodyType=msgType;
				
			}

			public  void sendMail() throws Exception {
				//System.out.println("inside send mail");

				MailSSLSocketFactory sf = new MailSSLSocketFactory();
								
				//Check if valid arguments are passed
				if ((this.sendTo == null)) {
					System.out.println ("Invalid arguments!");
					return;
				}
				
				int msgType = this.msgBodyType; 
				new EmailAgent(sendTo, msgType).sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt,
			            "support@nanhekadam.in", sf);
			    System.out.println("Sucessfully Sent mail to All Users");
			}

			public void sendSSLMessage(String recipients[], String subject,
			        String message, String from , MailSSLSocketFactory sf) throws MessagingException, IOException {
			    boolean debug = true;
			    Properties props = new Properties();
			    props.put("mail.smtp.host", "mail.listersoft.com");
			    props.put("mail.smtp.auth", "true");
			   // props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.debug", "true");
			    props.put("mail.smtp.port", "25");
			    props.put("mail.smtp.socketFactory.port", "25");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			    props.put("mail.smtp.socketFactory.fallback", "true");
                
 
			       
			    Session session = Session.getDefaultInstance(props,
			            new javax.mail.Authenticator() 
			             {
			                 protected PasswordAuthentication                   

			              getPasswordAuthentication() {
			                    return new   
			                 PasswordAuthentication("iauth", "K0#$2tyu$15");
			                }
			            });
			    System.out.println("debug");
			    session.setDebug(debug);
			    Message msg = new MimeMessage(session);
			    InternetAddress addressFrom = new InternetAddress(from);
			    msg.setFrom(addressFrom);

			    InternetAddress[] addressTo = new InternetAddress[recipients.length];
			    for (int i = 0; i < recipients.length; i++) {
			        addressTo[i] = new InternetAddress(recipients[i]);
			    }
			    msg.setRecipients(Message.RecipientType.TO, addressTo);
			    msg.setSubject(subject);
			    

			    /*// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         messageBodyPart.setContent(message, "text/html");
		         
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         String name = "beta_logo.png";
		         InputStream inputStream =  EmailAgent.class.getResourceAsStream(name);
		         DataSource ds = new ByteArrayDataSource(inputStream, "image/*");
				 messageBodyPart.setDataHandler(new DataHandler(ds));
		         messageBodyPart.setHeader("Content-ID", "<logo>");
		         
		        // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		         // put everything together
		         msg.setContent(multipart);
		        */
			      
		           
		         msg.setText(message);  
		  
		         // Send message  
		         //Transport.send(message);  
		         // Send message
		         Transport.send(msg);
				/*String to = "sonoojaiswal1988@gmail.com";//change accordingly  
			      String from = "sonoojaiswal1987@gmail.com";change accordingly  
			      String host = "localhost";*///or IP address  
			  
			     //Get the session object  
			     /* Properties properties = System.getProperties();  
			      properties.setProperty("mail.smtp.host", "smtp.zoho.com");  
			      Session session = Session.getDefaultInstance(properties);  
			  
			     //compose the message  
			      try{  
			         MimeMessage message = new MimeMessage(session);  
			         message.setFrom(new InternetAddress(from));  
			         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			         message.setSubject("Ping");  
			         message.setText("Hello, this is example of sending email  ");  
			  
			         // Send message  
			         Transport.send(message);  
			         System.out.println("message sent successfully...."); */  
			  
		  }
	}			