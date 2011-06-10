package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.DetailCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.BookTitleTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOutStatus;
import cz.cvut.fel.x33eja.lib.iface.to.ReaderDetail;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

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
    ReaderPO rPo = null;
    if (isReader()) {
      rPo = getReader();
    } else {
      rPo = em.find(ReaderPO.class, id);
    }
    List<ChargeOutPO> listPo = rPo.getChargeOuts();
    List<ChargeOutPO> resultList = new ArrayList<ChargeOutPO>();

    if (status != null) {
      for (ChargeOutPO chargeOut : listPo) {
        ChargeOutStatus st = ChargeOutStatus.valueOf(chargeOut.getStatus().getName());
        if (status.equals(st)) {
          resultList.add(chargeOut);
        }
      }
    }

    return translateData(rPo, resultList);
  }

  private ReaderDetail translateData(ReaderPO rPo, List<ChargeOutPO> listPo) {

    ReaderDetail detail = new ReaderDetail();
    detail.setIdReader(rPo.getIdReader());
    detail.setName(rPo.getName());
    detail.setSurname(rPo.getSurname());
    detail.setEmail(rPo.getEmail());

    List<ChargeOut> list = new ArrayList<ChargeOut>();

    for (ChargeOutPO cPo : listPo) {
      ChargeOut co = new ChargeOut();
      co.setId(cPo.getIdChargeOut());
      co.setFrom(cPo.getFromDate());
      co.setTo(cPo.getToDate());
      co.setStatus(cPo.getStatus().getName());

      BookTitlePO bPo = cPo.getLibraryUnit().getBookTitle();
      BookTitleTranslator bookTitleTranslator = new BookTitleTranslator();
      BookTitle bt = bookTitleTranslator.translate(bPo);

      co.setBook(bt);
      list.add(co);
    }
    detail.setChargeOuts(list);

    return detail;
  }

  @Override
  protected boolean authorize() {
    if (isAdmin() || isReader()) {
      return true;
    }
    return false;
  }
}
