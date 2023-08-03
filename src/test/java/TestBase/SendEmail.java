package TestBase;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;

public class SendEmail {

	@Test
	void mailsending() throws EmailException {
		
		
		  // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath(System.getProperty("user.dir")+"\\testdata\\OutputResult.xlsx");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Yatra Testing Result");
		  attachment.setName("Vignesh.xlsx");

		  // Create the email message
//		  MultiPartEmail email = new MultiPartEmail();
//		  email.setHostName("smtp.gmail.com");
//		  email.setSmtpPort(465);
//		  email.setAuthenticator(new DefaultAuthenticator("vigneshautomation76@gmail.com", "kwfduewtdtfaofon"));
//		  email.addTo("vigneshkv6533@gmail.com", "VIGNESH K. V.");
//		  email.setFrom("vigneshautomation76@gmail.com", "Me");
//		  email.setSubject("Yatra Automation Test Result");
//		  email.setMsg("Dear Sir, The Automation Testing is run sucessfully. Please find the result of the testing in attached file.");
//
//		  // add the attachment
//		  email.attach(attachment);
//
//		  // send the email
//		  email.send();
		
		MultiPartEmail email = new MultiPartEmail();
//		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("vigneshautomation76@gmail.com", "kwfduewtdtfaofon"));
		email.setSSLOnConnect(true);
		email.setFrom("vigneshautomation76@gmail.com");
		email.setSubject("Yatra Automation Test Result");
		email.setMsg("Dear Sir, "
				+ "The Automation Testing is run sucessfully. Please find the result of the testing in attached file.");
		email.addTo("vigneshkv6533@gmail.com");
		email.attach(attachment);
		email.send();
		  
//		  System.out.println("Mail Send successfully");
		

	}

}
