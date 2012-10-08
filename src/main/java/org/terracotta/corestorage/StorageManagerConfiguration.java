/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.Collection;
import java.util.Map;

public interface StorageManagerConfiguration {

  Collection<Object> sharedConfig();
  
  Map<String, KeyValueStorageConfig<?, ?>> mapConfig();
  
}
