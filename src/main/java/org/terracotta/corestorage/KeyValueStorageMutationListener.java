/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

public interface KeyValueStorageMutationListener<K, V> {
  
  void added(Retriever<? extends K> key, Retriever<? extends V> value, byte metadata);
  
  void removed(Retriever<? extends K> key);
  
}
