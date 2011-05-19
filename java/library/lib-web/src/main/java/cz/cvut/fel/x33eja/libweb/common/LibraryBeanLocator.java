package cz.cvut.fel.x33eja.libweb.common;

import cz.cvut.fel.x33eja.lib.iface.ejb.IAuthorBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.IBookTitleBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.ICategoryBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.ICommentaryBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.ILibraryUnitBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.IPublisherBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;

/**
 *
 * @author ondrepe
 */
public class LibraryBeanLocator {
  
  private static LibraryBeanLocator instance = null;
  
  private IAuthorBean authorBean;
  private IBookTitleBean bookTitleBean;
  private ICategoryBean categoryBean;
  private ICommentaryBean commentaryBean;
  private ILibraryUnitBean libraryUnitBean;
  private IPublisherBean publisherBean;
  private IReaderBean readerBean;
  
  public static LibraryBeanLocator getInstance() {
    if (instance == null) {
      instance = new LibraryBeanLocator();
    }
    return instance;
  }
  
  public void initBeans(IAuthorBean bean1, IBookTitleBean bean2, ICategoryBean bean3, ICommentaryBean bean4, ILibraryUnitBean bean5, IPublisherBean bean6, IReaderBean bean7) {
    this.authorBean = bean1;
    this.bookTitleBean = bean2;
    this.categoryBean = bean3;
    this.commentaryBean = bean4;
    this.libraryUnitBean = bean5;
    this.publisherBean = bean6;
    this.readerBean = bean7;
  }

  public static IAuthorBean getAuthorBean() {
    return instance.authorBean;
  }

  public static IBookTitleBean getBookTitleBean() {
    return instance.bookTitleBean;
  }

  public static ICategoryBean getCategoryBean() {
    return instance.categoryBean;
  }

  public static ICommentaryBean getCommentaryBean() {
    return instance.commentaryBean;
  }

  public static ILibraryUnitBean getLibraryUnitBean() {
    return instance.libraryUnitBean;
  }

  public static IPublisherBean getPublisherBean() {
    return instance.publisherBean;
  }

  public static IReaderBean getReaderBean() {
    return instance.readerBean;
  }
}
