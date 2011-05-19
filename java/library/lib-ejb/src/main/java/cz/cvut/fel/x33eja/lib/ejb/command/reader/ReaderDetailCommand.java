package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.DetailCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOutStatus;
import cz.cvut.fel.x33eja.lib.iface.to.ReaderDetail;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ReaderDetailCommand extends DetailCommand<ReaderDetail> {

  private ChargeOutStatus status;
  
  public ReaderDetailCommand(EntityManager em) {
    super(em);
  }
  
  public ReaderDetailCommand(EntityManager em, ChargeOutStatus status) {
    this(em);
    this.status = status;
  }
  
  public ReaderDetailCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public ReaderDetailCommand(EntityManager em, ChargeOutStatus status, SessionContext ctx) {
    this(em, ctx);
    this.status = status;
  }

  @Override
  protected ReaderDetail detail(int id) {
    ReaderPO rPo = em.find(ReaderPO.class, id);
    String sql = null;

    if (status == null) {
      sql = "ChargeOutPO.findByIdReader";
    } else if (ChargeOutStatus.ACTIVE.equals(status)) {
      sql = "ChargeOutPO.findActiveByIdReader";
    } else if (ChargeOutStatus.RESERVED.equals(status)) {
      sql = "ChargeOutPO.findReservedByIdReader";
    }
    Query query = em.createNamedQuery(sql).setParameter("idReader", id);
    List<ChargeOutPO> listPo = query.getResultList();
          
    return translateData(rPo, listPo);
  }
  
  private ReaderDetail translateData(ReaderPO rPo, List<ChargeOutPO> listPo) {
    
    ReaderDetail detail = new ReaderDetail();
    detail.setIdReader(rPo.getIdReader());
    detail.setName(rPo.getName());
    detail.setSurname(rPo.getSurname());
    detail.setEmail(rPo.getEmail());
    
    List<ChargeOut> list = new ArrayList<ChargeOut>();
    
    for(ChargeOutPO cPo : listPo) {
      ChargeOut co = new ChargeOut();
      co.setId(cPo.getIdChargeOut());
      co.setFrom(cPo.getFromDate());
      co.setTo(cPo.getToDate());
      co.setStatus(cPo.getStatus().getIdChargeOutStatus());
      
      BookTitlePO bPo = cPo.getLibraryUnitPO().getBookTitlePO();
      BookTitle bt = new BookTitle();
      bt.setId(bPo.getIdBookTitle());
      bt.setIsbn(bPo.getIsbn());
      bt.setName(bPo.getName());
      bt.setPublisher(bPo.getPublisherPO().getName());
      bt.setIssue(bPo.getIssueNumber());
      bt.setPages(bPo.getPagesCount());
      Calendar cal = Calendar.getInstance();
      cal.setTime(bPo.getYear());
      bt.setYear(cal.get(Calendar.YEAR));
      
      co.setBook(bt);
      list.add(co);
    }
    detail.setChargeOuts(list);
    
    return detail;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
}
