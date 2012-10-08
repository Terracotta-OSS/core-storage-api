/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.List;

public interface KeyValueStorageConfig<K, V> {

  void addListener(KeyValueStorageMutationListener<? super K, ? super V> objectIDSetMaintainer);
  
  List<KeyValueStorageMutationListener<? super K, ? super V>> getMutationListeners();
  
  Class<K> getKeyClass();
  
  Class<V> getValueClass();

  void setKeySerializer(Serializer<K> serializer);

  void setValueSerializer(Serializer<V> serializer);

  Serializer<K> getKeySerializer();

  Serializer<V> getValueSerializer();

}
