package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public abstract class CommonListBean <T extends CommonTO> {
  
  private List<T> list;
  
  protected abstract List<T> load();
  
  public final List<T> getList() {
    if(this.list == null) {
      this.list = load();
    }
    return this.list;
  }
  
  public final void reload() {
    this.list = load();
  }
 
}
