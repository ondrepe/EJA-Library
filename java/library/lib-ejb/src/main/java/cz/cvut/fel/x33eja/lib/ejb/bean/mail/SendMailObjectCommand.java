package cz.cvut.fel.x33eja.lib.ejb.bean.mail;

import cz.cvut.fel.x33eja.lib.ejb.bean.mail.object.MailObject;
import cz.cvut.fel.x33eja.lib.ejb.command.CommonCommand;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import javax.ejb.SessionContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class SendMailObjectCommand extends CommonCommand {

  private Queue statementQueue;
  private ConnectionFactory statementQueueFactory;
  
  public SendMailObjectCommand(EntityManager em, SessionContext ctx, ConnectionFactory factory, Queue queue) {
    super(em, ctx);
    statementQueue = queue;
    statementQueueFactory = factory;
  }
  
  public void sendBookingToQueue(ChargeOut chargeOut, Reader reader) {
    
    try {
      MailObject st = new MailObject();
      st.getChargeOuts().add(chargeOut);
      st.setEmail(reader.getEmail());
      st.setReaderEmail(reader.getEmail());
      st.setName(reader.getName());
      st.setSurname(reader.getSurname());
      st.setSubject("Library - Your Reservation");
      sendMessageToQueue(st);
      
      st = new MailObject();
      st.getChargeOuts().add(chargeOut);
      st.setEmail("p.ondrejicek@gmail.com");
      st.setReaderEmail(reader.getEmail());
      st.setName(reader.getName());
      st.setSurname(reader.getSurname());
      st.setSubject("Library - New Reservation");
      sendMessageToQueue(st);
    } catch (JMSException ex) {
      System.err.println(ex);
    }
  }
  
  private void sendMessageToQueue(MailObject msg) throws JMSException {
    Connection connection = statementQueueFactory.createConnection();
    try {
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      try {
        MessageProducer producer = session.createProducer(statementQueue);
        try {
          Message tm = session.createObjectMessage(msg);
          producer.send(tm);
        } finally {
          producer.close();
        }
      } finally {
        session.close();
      }
    } finally {
      connection.close();
    }
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
