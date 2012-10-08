/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.Collection;
import java.util.concurrent.Future;
import org.terracotta.corestorage.monitoring.MonitoredResource;

public interface StorageManager {

  
  <K, V> KeyValueStorage<K, V> getKeyValueStorage(String alias, Class<K> keyClass, Class<V> valueClass);

  void detachKeyValueStorage(String alias);

  <K, V> void attachKeyValueStorage(String alias, KeyValueStorage<K, V> storage, Class<K> keyClass, Class<V> valueClass);

  void begin();

  void commit();

  Future<?> start();
  
  void shutdown();

  public StorageManagerConfiguration getConfiguration();
  
  /**
   * Return the monitored resource consumed by this StorageManager.
   * 
   * @return all monitored resources
   */
  public Collection<MonitoredResource> getMonitoredResources();
}
