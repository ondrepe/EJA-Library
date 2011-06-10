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
  public Author translate(AuthorPO from) {
    Author author = new Author();
    
    author.setIdAuthor(from.getIdAuthor());
    author.setName(from.getName());
    author.setSurname(from.getSurname());
    
    return author;
  }
}
