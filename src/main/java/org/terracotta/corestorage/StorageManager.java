/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.concurrent.Future;

public interface StorageManager {

  
  <K, V> KeyValueStorage<K, V> getMap(String alias, Class<K> keyClass, Class<V> valueClass);

  void detachMap(String alias);

  <K, V> void attachMap(String alias, KeyValueStorage<K, V> map, Class<K> keyClass, Class<V> valueClass);

  void begin();

  void commit();

  Future<?> start();
  
  void shutdown();

  public StorageManagerConfiguration getConfiguration();
}
