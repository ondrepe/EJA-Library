package cz.cvut.fel.x33eja.libweb.view;

import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPanel;
import org.apache.wicket.markup.html.basic.Label;

/**
 *
 * @author ondrepe
 */
public class LibraryHomePagePanel extends CommonLibraryPanel {

  public LibraryHomePagePanel(String id) {
    super(id);
  }
  
  @Override
  protected void initComponents() {
    this.add(new Label("homeTitle", "Library EJB Web Home Page"));
  }
  
}
