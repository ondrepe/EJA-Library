package cz.cvut.fel.x33eja.lib.ejb.bean.mail;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import cz.cvut.fel.x33eja.lib.ejb.bean.mail.object.MailObject;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.Session;

/**
 *
 * @author ondrepe
 */
@MessageDriven(mappedName = "jms/lib/bookingQueue", activationConfig = {
  @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
  @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class BookingMailBean implements MessageListener {

  @Resource(name = "mail/libMailSession")
  private Session mailSession;

  @Override
  public void onMessage(javax.jms.Message msg) {
    try {
      ObjectMessage tm = (ObjectMessage) msg;
      MailObject statement = (MailObject) tm.getObject();
      sendEmail(statement);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  private void sendEmail(MailObject notification) {
    MailSenderCommand command = new MailSenderCommand(mailSession);
    command.sendEmail(notification, createMessageText(notification));
  }
  
  private String createMessageText(MailObject notification) {
    StringBuilder builder = new StringBuilder();
    builder.append("<html lang=\"en\"><head>").append(LineSeparator.Web);
    builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />").append(LineSeparator.Web);
    builder.append("<title>Blockatoion</title><s/head><body>").append(LineSeparator.Web);
    builder.append("<table><tr><td>")
            .append("Reader: ").append("</td><td>")
            .append(notification.getName())
            .append(" ")
            .append(notification.getSurname())
            .append("</td><td>").append(notification.getReaderEmail())
            .append("</td></tr></table>")
            .append(LineSeparator.Web);
    builder.append("<br />").append(LineSeparator.Web);
    builder.append("<p>Blocked books: </p>").append(LineSeparator.Web);
    builder.append("<table>");
    builder.append("<thead><tr>")
            .append("<th>Id</th>")         
            .append("<th>Book</th>")
            .append("<th>From date</th>")
            .append("<th>To date</th>") 
            .append("</tr></thead>")
            .append(LineSeparator.Web);
    builder.append("<tbody>").append(LineSeparator.Web);
    
    for(ChargeOut chr : notification.getChargeOuts()) {
      builder.append("<tr>");
      builder.append("<td>").append(chr.getId()).append("</td>");
      builder.append("<td>").append(chr.getBook().getName()).append(" (").append(chr.getBook().getYear()).append(")</td>");
      builder.append("<td>").append(chr.getFrom()).append("</td>");
      builder.append("<td>").append(chr.getTo()).append("</td>");
      builder.append("</tr>").append(LineSeparator.Web);
    }
    
    builder.append("</tbody></table>").append(LineSeparator.Web);
    builder.append("</body>").append("</html>");
    return builder.toString();
  }
}
