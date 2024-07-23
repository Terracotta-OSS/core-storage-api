/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.corestorage;

import java.util.Collection;
import java.util.Set;

public interface KeyValueStorage<K, V> {
  
  // We can probably get rid of these
  @Deprecated
  public Set<K> keySet(); // only used for loading root mbeans

  @Deprecated
  public Collection<V> values(); // only used for retrieving GC roots,
  // maybe we can just make the entire root
  // map a single value to avoid this.

  @Deprecated
  public long size(); // only really used for stats logging

  // TODO: what exception to catch when
  public void put(K key, V value);

  public void put(K key, V value, byte metadata);

  public V get(K key);

  public boolean remove(K key);

  public void removeAll(Collection<K> keys);

  public boolean containsKey(K key);

  public void clear();
}
