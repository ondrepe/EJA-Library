package cz.cvut.fel.x33eja.libweb.view.common;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public abstract class CommonLibraryPanel<T> extends Panel {

  private IModel<T> model;
  
  public CommonLibraryPanel(final String id) {
    super(id);
    this.init();
  }

  public CommonLibraryPanel(final String id, final IModel<T> model) {
    super(id, model);
    this.model = model;
    this.init();
  }
  
  private void init() {
    this.setOutputMarkupId(true);
    this.setOutputMarkupPlaceholderTag(true);
    this.initComponents();
  }
  
  public CommonLibraryPage getHomePage() {
    return (CommonLibraryPage) super.getPage();
  } 
  
  protected abstract void initComponents();
  
  protected IModel<T> getModel() {
    return model;
  }
}
