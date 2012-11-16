/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Future;

import org.terracotta.corestorage.monitoring.MonitoredResource;

public interface StorageManager {
  
  Map<String, String> getProperties();

  <K, V> KeyValueStorage<K, V> getKeyValueStorage(String alias, Class<K> keyClass, Class<V> valueClass);

  void destroyKeyValueStorage(String alias);

  <K, V> KeyValueStorage<K, V> createKeyValueStorage(String alias, KeyValueStorageConfig<K, V> config);

  void begin();

  void commit();

  Future<?> start();
  
  void shutdown();

  /**
   * Return the monitored resource consumed by this StorageManager.
   * 
   * @return all monitored resources
   */
  public Collection<MonitoredResource> getMonitoredResources();
}
