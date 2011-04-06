package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.AuthorPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IAuthorBean {

    AuthorPO getAuthor(int id);

    List<AuthorPO> getAllAuthors();

    void save(AuthorPO reader);

    void remove(AuthorPO reader);
}
