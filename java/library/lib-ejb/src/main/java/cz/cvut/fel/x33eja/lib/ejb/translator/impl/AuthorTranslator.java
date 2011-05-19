package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Author;

/**
 *
 * @author ondrepe
 */
public class AuthorTranslator extends CommonTranslator<AuthorPO, Author> {

  @Override
  public Author fromPoToDo(AuthorPO from) {
    Author author = new Author();
    
    return author;
  }

  @Override
  public AuthorPO fromDoToPo(Author from) {
    AuthorPO author = new AuthorPO();
    
    return author;
  }
  
}
