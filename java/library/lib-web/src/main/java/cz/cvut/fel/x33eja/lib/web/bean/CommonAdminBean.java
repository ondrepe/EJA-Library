package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;

/**
 *
 * @author ondrepe
 */
public abstract class CommonAdminBean<T extends CommonTO> extends CommonListBean<T> {
  
  private T item;
  
  protected abstract void addItem(T item);
  protected abstract T initItem();
  
  public final void add() {
     addItem(item);
     reload();
  }

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    if(item == null) {
      item = initItem();
    }
    return item;
  }
  
}
