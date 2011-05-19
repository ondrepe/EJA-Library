package cz.cvut.fel.x33eja.libweb.view.common;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public abstract class CommonActionPanel<T> extends Panel {

  private T object;
  
  public CommonActionPanel(String id, IModel<T> model, IModel name) {
    super(id, model);
    this.object = model.getObject();
    AjaxLink link = new AjaxLink("actionPanel") {

      @Override
      public void onClick(AjaxRequestTarget target) {
        onLinkClick(target);
      }
    };
    link.add(new Label("actionPanelLabel", name));
    add(link);
  }

  public T getObject() {
    return object;
  }
  
  protected abstract void onLinkClick(AjaxRequestTarget target);
}
