/* 
 * Copyright 2015 Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
  
  void close();

  /**
   * Return the monitored resource consumed by this StorageManager.
   * 
   * @return all monitored resources
   */
  public Collection<MonitoredResource> getMonitoredResources();
}
