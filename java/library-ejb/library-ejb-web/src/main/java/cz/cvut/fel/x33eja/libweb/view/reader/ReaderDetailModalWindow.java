package cz.cvut.fel.x33eja.libweb.view.reader;

import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public class ReaderDetailModalWindow extends ModalWindow {
  
  private IModel<ReaderDetail> model;
  
  public ReaderDetailModalWindow(final String id, final IModel<ReaderDetail> model) {
    super(id, model);
    this.model = model;
    init();
  }
  
  private void init() {
    this.setPageCreator(new PageCreator() {

      @Override
      public Page createPage() {
        return new ReaderDetailModalPage(model);
      }
    });
  }
}
