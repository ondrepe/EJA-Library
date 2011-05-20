package cz.cvut.fel.x33eja.lib.web.bean.commentary;

import cz.cvut.fel.x33eja.lib.iface.ejb.ICommentaryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import cz.cvut.fel.x33eja.lib.web.bean.CommonAdminBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class CommentaryAdminBean extends CommonAdminBean<Commentary> {

  @EJB
  private ICommentaryBean commentaryBean;
  
  @Override
  protected void addItem(Commentary item) {
    commentaryBean.save(item);
  }

  @Override
  protected Commentary initItem() {
    return new Commentary();
  }

  @Override
  protected List<Commentary> load() {
    return commentaryBean.getAllCommentaries();
  }
  
}
