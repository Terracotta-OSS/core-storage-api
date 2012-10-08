/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

public interface KeyValueStorageFactory {

  public <K, V> KeyValueStorage<K, V> createMap(KeyValueStorageConfig<K, V> mapStorageConfigImpl, Object ... configs);

}
