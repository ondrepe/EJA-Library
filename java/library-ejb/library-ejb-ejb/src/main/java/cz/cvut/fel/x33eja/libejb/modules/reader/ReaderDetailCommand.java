package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libdo.domain.BookTitle;
import cz.cvut.fel.x33eja.libdo.domain.ChargeOut;
import cz.cvut.fel.x33eja.libdo.domain.ChargeOutStatus;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import cz.cvut.fel.x33eja.libejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.libejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ReaderDetailCommand implements Command {

  @Override
  public Object execute(CommandManager manager, Object... data) {

    int id = (Integer) data[0];
    ReaderPO rPo = manager.getEm().find(ReaderPO.class, id);
    String sql = null;

    if (data.length != 2) {
      sql = "ChargeOutPO.findByIdReader";
    } else if (ChargeOutStatus.ACTIVE.equals(data[1])) {
      sql = "ChargeOutPO.findActiveByIdReader";
    } else if (ChargeOutStatus.RESERVED.equals(data[1])) {
      sql = "ChargeOutPO.findReservedByIdReader";
    }
    Query query = manager.getEm().createNamedQuery(sql).setParameter("idReader", id);
    List<ChargeOutPO> listPo = query.getResultList();
    
    // prevedeni na ReaderDetail
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
}
