package cz.cvut.fel.x33eja.libweb.view.common;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public abstract class CommonLibraryPage extends WebPage {
  
  protected CommonLibraryPage() {
    super();
    this.init();
  }

  protected CommonLibraryPage(final IModel<?> model) {
    super(model);
    this.init();
  }

  protected CommonLibraryPage(final IPageMap pageMap) {
    super(pageMap);
    this.init();
  }

  protected CommonLibraryPage(final IPageMap pageMap, final IModel<?> model) {
    super(pageMap, model);
    this.init();
  }

  protected CommonLibraryPage(final PageParameters parameters) {
    super(parameters);
    this.init();
  }

  protected CommonLibraryPage(final IPageMap pageMap, final PageParameters parameters) {
    super(pageMap, parameters);
    this.init();
  }

  private void init() {
    this.initBeans();
    this.initComponents();
  }
  
  protected void initBeans() {
  }
  
  protected abstract void initComponents();
}
