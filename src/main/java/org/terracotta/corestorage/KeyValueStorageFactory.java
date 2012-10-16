/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

public interface KeyValueStorageFactory {

  <K, V> KeyValueStorage<K, V> create(KeyValueStorageConfig<K, V> storageConfig);

}
