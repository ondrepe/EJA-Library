package cz.cvut.fel.x33eja.lib.ejb.command.libraryunit;

import cz.cvut.fel.x33eja.lib.ejb.command.CommonCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import java.util.Date;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class LibraryUnitGetAvailableCommand extends CommonCommand {

  public LibraryUnitGetAvailableCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public LibraryUnitPO execute(int idBookTitle, Date from, Date to) {
    List<LibraryUnitPO> unavailableUnits = null;
    Query query = em.createNamedQuery("ChargeOutPO.getBetweenDates").setParameter("fromDate", from).setParameter("toDate", to).setParameter("idBookTitle", idBookTitle);
    unavailableUnits = query.getResultList();
    
    BookTitlePO booktTitle = em.find(BookTitlePO.class, idBookTitle);
    List<LibraryUnitPO> units = booktTitle.getLibraryUnits();
    
    if(units == null || units.isEmpty() || units.size() == unavailableUnits.size()) {
      return null;
    }
    
    units.removeAll(unavailableUnits);
    return units.get(0);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
