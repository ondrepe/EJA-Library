package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ICommentaryBean {

  public Commentary getCommentary(int id);

  public List<Commentary> getAllCommentaries();

  public List<Commentary> getCommentariesByBook(int idBook);

  public void save(Commentary commentary);

  public void remove(int id);
}
