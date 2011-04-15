package cz.cvut.fel.x33eja.libweb.view.common;

import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public abstract class CommonLibraryModalPage<T> extends CommonLibraryPage {
  
  private IModel<T> model;
  
  public CommonLibraryModalPage(IModel<T> model) {
    this.model = model;
    this.init();
  }

  public IModel<T> getModel() {
    return model;
  }

  @Override
  protected void initComponents() {
  }
  
  private void init() {
    this.initModal();
  }
  
  protected abstract void initModal();
}
