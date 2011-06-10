package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import javax.ejb.EJBException;
import javax.faces.component.html.HtmlDataTable;

/**
 *
 * @author ondrepe
 */
public abstract class CommonAdminBean<T extends CommonTO> extends CommonListBean<T> {

  private T item;
  private boolean renderAdd;
  private boolean renderUpdate;
  private HtmlDataTable htmlDataTable;
  
  protected abstract void addItem(T item);
  protected abstract void deleteItem(T item);
  protected abstract T initItem();

  @Override
  protected void customInit() {
    item = initItem();
    renderAdd = false;
    renderUpdate = false;
  }

  public final void add() {
    try {
      addItem(item);
      init();
    } catch (EJBException ex) {
      handleEJBException(ex);
    }
  }

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public boolean isRenderAdd() {
    return renderAdd;
  }

  public boolean isRenderUpdate() {
    return renderUpdate;
  }
  
  public HtmlDataTable getHtmlDataTable() {
    return htmlDataTable;
  }

  public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
    this.htmlDataTable = htmlDataTable;
  }
  
  public void delete() {
    T obj = (T) htmlDataTable.getRowData();
    try {
      deleteItem(obj);
      init();
    } catch (EJBException ex) {
      handleEJBException(ex);
    }
  }
  
  public void select() {
    T obj = (T) htmlDataTable.getRowData();
    setItem(obj);
    renderAdd = false;
    renderUpdate = true;
  }
  
  public void selectAdd() {
    renderAdd = true;
    renderUpdate = false;
  }
  
  public void selectUpdate() {
    renderAdd = false;
    renderUpdate = true;
  }
  
  public void selectView() {
    renderAdd = false;
    renderUpdate = false;
  }
}
