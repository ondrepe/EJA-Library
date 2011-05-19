package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;

/**
 *
 * @author ondrepe
 */
public abstract class CommonAddBean<T extends CommonTO> {

  private T item;

  protected abstract void addItem(T item);
  protected abstract T initItem();

  public final void add() {
    addItem(item);
    item = initItem();
  }

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    if (item == null) {
      item = initItem();
    }
    return item;
  }
}
