package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlDataTable;

/**
 *
 * @author ondrepe
 */
public abstract class CommonListBean <T extends CommonTO> extends CommonBean {
  
  private List<T> list;
  private T item;
  private boolean renderList;
  protected HtmlDataTable htmlDataTable;
  
  protected abstract T initItem();
  protected abstract List<T> load();
  protected void customInit() {
  }

  @PostConstruct
  public void init() {
    list = load();
    if (list.isEmpty()) {
      renderList = false;
    } else {
      renderList = true;
    }
    customInit();
  }

  public final List<T> getList() {
    return this.list;
  }

  public boolean isRenderList() {
    return renderList;
  }

  public HtmlDataTable getHtmlDataTable() {
    return htmlDataTable;
  }

  public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
    this.htmlDataTable = htmlDataTable;
  }
  
  public void select() {
    T obj = (T) htmlDataTable.getRowData();
    setItem(obj);
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
 
}
