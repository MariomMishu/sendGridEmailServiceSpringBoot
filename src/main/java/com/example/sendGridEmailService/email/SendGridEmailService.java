package com.example.sendGridEmailService.email;

import java.io.IOException;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendGridEmailService implements EmailService {

	@Value("${sendgrid.api.key}")
	private String sendGridAPIKey;

  @Override
  public void sendText(String from, String to, String subject, String body) {
    Response response = sendEmail(from, to, subject, new Content("text/plain", body));
    System.out.println(
        "Status Code: "
            + response.getStatusCode()
            + ", Body: "
            + response.getBody()
            + ", Headers: "
            + response.getHeaders());
  }

  @Override
  public void sendHTML(String from, String to, String subject, String body) {
    Response response = sendEmail(from, to, subject, new Content("text/html", body));
    System.out.println(
        "Status Code: "
            + response.getStatusCode()
            + ", Body: "
            + response.getBody()
            + ", Headers: "
            + response.getHeaders());
  }

  private Response sendEmail(String from, String to, String subject, Content content) {
	  var sendGrid = new SendGrid(sendGridAPIKey);   
    Mail mail = new Mail(new Email(from), subject, new Email(to), content);
    //	        mail.setReplyTo(new Email("mishu.cste08@gmail.com"));
    Request request = new Request();
    Response response = new Response();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      return sendGrid.api(request);
    } catch (IOException ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
}
