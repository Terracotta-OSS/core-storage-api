/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

public interface TransformerLookup {
  
  <T> Transformer<? super T, ?> lookup(Class<T> klazz);
  
  <T> Transformer<? super T, ?> lookup(String alias, Class<T> klazz);
}
