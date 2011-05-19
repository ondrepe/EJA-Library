package cz.cvut.fel.x33eja.libweb.view;

import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPanel;
import cz.cvut.fel.x33eja.libweb.view.reader.ReaderPanel;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.parser.XmlTag;

/**
 *
 * @author ondrepe
 */
public class AdminMenu extends CommonLibraryPanel {

  private AjaxLink homeLink;
  private AjaxLink readerLink;
  
  public AdminMenu(String id) {
    super(id);
  }
  
  @Override
  protected void initComponents() {
    
    homeLink = new AjaxLink("menu-home") {

      @Override
      public void onClick(AjaxRequestTarget target) {

      }
    };
    homeLink.add(new Label("menu-home-lbl", "Home"));
    readerLink = new AjaxLink("menu-reader") {

      @Override
      public void onClick(AjaxRequestTarget target) {

      }
    };
    readerLink.add(new Label("menu-reader-lbl", "Readers Administration"));
    
    add(homeLink);
    add(readerLink);
  }
  
}
