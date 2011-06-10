package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AutentizationGroupPO;
import cz.cvut.fel.x33eja.lib.ejb.po.AutentizationPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderCreateCommand extends CreateUpdateCommand<ReaderPO> {

  public ReaderCreateCommand(EntityManager em) {
    super(em);
  }

  public ReaderCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(ReaderPO reader) {
    ReaderPO readerPo = new ReaderPO();
    readerPo.setName(reader.getName());
    readerPo.setSurname(reader.getSurname());
    readerPo.setEmail(reader.getEmail());
    
    AutentizationGroupPO autentizationGroup = em.find(AutentizationGroupPO.class, "READER");
    AutentizationPO autentization = new AutentizationPO();
    autentization.setLogin(createLogin(reader.getName(), reader.getSurname()));
    autentization.setPassword("955db0b81ef1989b4a4dfeae8061a9a6"); // MD5 pro heslo
    autentization.setGroupName(autentizationGroup);
    autentization.setReader(readerPo);
    
    em.persist(autentization);
  }
  
  private String createLogin(String name, String surname) {
    String login = surname.toLowerCase().substring(0, 5).concat(name.toLowerCase().substring(0, 3));
    
    int i = 1;
    String testLogin = login;
    while(true) {
      AutentizationPO autentization = em.find(AutentizationPO.class, testLogin);
      if(autentization == null) {
        break;
      }
      testLogin = login + i ;
      i++;
    }
    
    return login;
  }
}
