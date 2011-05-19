package cz.cvut.fel.x33eja.libweb.view;

import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;
import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPage;
import cz.cvut.fel.x33eja.libweb.common.LibraryBeanLocator;
import cz.cvut.fel.x33eja.libweb.view.reader.ReaderPanel;
import javax.ejb.EJB;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;

/**
 * Homepage
 */
public class LibraryHomePage extends CommonLibraryPage {

  @EJB(name="ReaderBean")
  private IReaderBean readerBean;

  public LibraryHomePage(final PageParameters parameters) {
    super(parameters);
    this.add(CSSPackageResource.getHeaderContribution("style/style.css"));
  }

  @Override
  protected void initBeans() {
    LibraryBeanLocator beanLocator = LibraryBeanLocator.getInstance();
    beanLocator.initBeans(null, null, null, null, null, null, readerBean);
  }

  @Override
  protected void initComponents() {
    this.initMenu();
    add(new ReaderPanel("content"));
  }
  
  protected void initMenu() {
    add(new AdminMenu("menu"));
  }
}
