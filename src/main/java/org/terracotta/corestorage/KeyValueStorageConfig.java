/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.List;

public interface KeyValueStorageConfig<K, V> {

  List<KeyValueStorageMutationListener<? super K, ? super V>> getMutationListeners();
  
  Class<K> getKeyClass();
  
  Class<V> getValueClass();

  Transformer<? super K, ?> getKeyTransformer();

  Transformer<? super V, ?> getValueTransformer();
}
