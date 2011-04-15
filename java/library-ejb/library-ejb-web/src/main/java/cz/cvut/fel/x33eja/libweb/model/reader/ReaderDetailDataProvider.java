package cz.cvut.fel.x33eja.libweb.model.reader;

import cz.cvut.fel.x33eja.libdo.domain.ChargeOut;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import java.util.Iterator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author ondrepe
 */
public class ReaderDetailDataProvider extends SortableDataProvider<ChargeOut> {

  private IModel<ReaderDetail> model;
          
  public ReaderDetailDataProvider(IModel<ReaderDetail> model) {
    this.model = model;
  }
  
  @Override
  public Iterator<? extends ChargeOut> iterator(int first, int count) {
    if(model.getObject() != null) {
      return model.getObject().getChargeOuts().listIterator();
    }
    return null;
  }

  @Override
  public int size() {
    if(model.getObject() != null) {
      return model.getObject().getChargeOuts().size();
    }
    return 0;
  }

  @Override
  public IModel<ChargeOut> model(ChargeOut object) {
    return new Model<ChargeOut>(object);
  }
}
