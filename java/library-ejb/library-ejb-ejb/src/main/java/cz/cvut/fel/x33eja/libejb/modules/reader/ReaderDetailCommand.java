package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libdo.domain.BookTitle;
import cz.cvut.fel.x33eja.libdo.domain.ChargeOut;
import cz.cvut.fel.x33eja.libdo.domain.ChargeOutStatus;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import cz.cvut.fel.x33eja.libejb.command.DetailCommand;
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
public class ReaderDetailCommand extends DetailCommand<ReaderDetail> {

  @Override
  public ReaderDetail execute(int id, Object... data) {

    ReaderPO rPo = em.find(ReaderPO.class, id);
    String sql = null;

    if (data.length != 1) {
      sql = "ChargeOutPO.findByIdReader";
    } else if (ChargeOutStatus.ACTIVE.equals(data[0])) {
      sql = "ChargeOutPO.findActiveByIdReader";
    } else if (ChargeOutStatus.RESERVED.equals(data[0])) {
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
}
