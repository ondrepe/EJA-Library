package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.CommentaryPO;
import cz.cvut.fel.x33eja.libejb.db.po.PublisherPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ICommentaryBean {

    CommentaryPO getAuthor(int id);

    List<CommentaryPO> getAllCommentaries();

    void save(CommentaryPO reader);

    void remove(CommentaryPO reader);
    
}
