package cz.cvut.fel.x33eja.lib.ejb.bean.mail;

import cz.cvut.fel.x33eja.lib.ejb.bean.mail.object.MailObject;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ondrepe
 */
public class MailSenderCommand {
  
  private Session session;
  
  public MailSenderCommand(Session session) {
    this.session = session;
  }
  
  public void sendEmail(MailObject mailObject, String message) {
    try {
      Message mail = new MimeMessage(session);
      mail.setFrom();
      mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailObject.getEmail(), false));
      mail.setHeader("X-Mailer", "My Mailer");
      mail.setSentDate(new Date());
      mail.setSubject("[Library] - " + mailObject.getSubject());
      mail.setContent(message, "text/html");
      Transport.send(mail);

    } catch (MessagingException mex) {
      System.err.println(mex);
    }
  }
}
