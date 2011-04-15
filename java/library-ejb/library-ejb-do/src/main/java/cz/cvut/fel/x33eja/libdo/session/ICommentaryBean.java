package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Commentary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ICommentaryBean {

    Commentary getAuthor(int id);

    List<Commentary> getAllCommentaries();

    void save(Commentary reader);

    void remove(int id);
    
}
