package cz.cvut.fel.x33eja.libweb.view.reader;

import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPanel;

/**
 *
 * @author ondrepe
 */
public class ReaderPanel extends CommonLibraryPanel {

  public ReaderPanel(String id) {
    super(id);
  }
  
  @Override
  protected void initComponents() {
    add(new ReaderTable("table"));
  }
  
}
