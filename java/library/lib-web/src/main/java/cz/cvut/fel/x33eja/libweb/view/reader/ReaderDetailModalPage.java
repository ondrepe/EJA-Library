package cz.cvut.fel.x33eja.libweb.view.reader;

import cz.cvut.fel.x33eja.lib.iface.to.ReaderDetail;
import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryModalPage;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public class ReaderDetailModalPage extends CommonLibraryModalPage<ReaderDetail> {

  public ReaderDetailModalPage(final IModel<ReaderDetail> model) {
    super(model);
  }
  
  @Override
  protected void initModal() {
    add(new ReaderChargeOutTable("readerChargeOutTable", getModel()));
  }
  
}
