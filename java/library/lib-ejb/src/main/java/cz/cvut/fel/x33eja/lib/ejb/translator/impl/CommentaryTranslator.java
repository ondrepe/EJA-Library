package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;

/**
 *
 * @author ondrepe
 */
public class CommentaryTranslator extends CommonTranslator<CommentaryPO, Commentary> {

  @Override
  public Commentary translate(CommentaryPO from) {
    Commentary commentary = new Commentary();
    
    commentary.setAuthorName(from.getAuthorName());
    commentary.setIdCommentary(from.getIdCommentary());
    commentary.setText(from.getText());
    commentary.setTime(from.getTime());
    
    BookTitleTranslator bookTitleTranslator = new BookTitleTranslator();
    commentary.setBookTitle(bookTitleTranslator.translate(from.getBookTitle()));
    
    return commentary;
  }
  
}
