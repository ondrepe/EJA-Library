package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author ondrepe
 */
public abstract class CommonListBean <T extends CommonTO> extends CommonBean {
  
  private List<T> list;
  private boolean renderList;

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
 
}
