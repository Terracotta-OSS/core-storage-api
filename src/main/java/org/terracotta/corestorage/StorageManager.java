/* 
 * The contents of this file are subject to the Terracotta Public License Version
 * 2.0 (the "License"); You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at 
 *
 *      http://terracotta.org/legal/terracotta-public-license.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Covered Software is Core Storage API.
 *
 * The Initial Developer of the Covered Software is 
 *      Terracotta, Inc., a Software AG company
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
