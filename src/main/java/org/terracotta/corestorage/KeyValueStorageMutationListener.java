/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.Map;

public interface KeyValueStorageMutationListener<K, V> {
  
  void added(Retriever<? extends K> key, Retriever<? extends V> value, Map<? extends Enum, Object> metadata);
  
  void removed(Retriever<? extends K> key, Retriever<? extends V> value, Map<? extends Enum, Object> metadata);
  
}
