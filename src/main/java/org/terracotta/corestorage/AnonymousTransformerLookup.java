/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.terracotta.corestorage;

/**
 *
 * @author cdennis
 */
public abstract class AnonymousTransformerLookup implements TransformerLookup {

  @Override
  public final <T> Transformer<? super T, ?> lookup(String alias, Class<T> klazz) {
    return lookup(klazz);
  }
}
