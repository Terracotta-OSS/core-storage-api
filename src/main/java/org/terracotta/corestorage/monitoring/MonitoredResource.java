/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage.monitoring;

import java.util.concurrent.Callable;

public interface MonitoredResource {

  enum Type {
    HEAP,
    OFFHEAP,
    DISK,
    OTHER;
  }
  
  /**
   * Returns the type of this resource.
   * 
   * @return resource type
   */
  Type getType();
  
  /**
   * Returns the amount of used resource.
   * 
   * @return used resource
   */
  long getUsed();

  /**
   * Returns the amount of reserved resource.
   * 
   * @return reserved resource
   */
  long getReserved();
  
  /**
   * Returns the total amount of resource.
   * 
   * @return total resource
   */
  long getTotal();
  
  /**
   * Set a resource usage threshold condition and associated callback.
   * 
   * @throws UnsupportedOperationException if this resource doesn't support thresholds
   */
  void addUsedThreshold(long value, Callable<?> action) throws UnsupportedOperationException;

  /**
   * Set a resource usage threshold condition and associated callback.
   * 
   * @throws UnsupportedOperationException if this resource doesn't support thresholds
   */
  void addReservedThreshold(long value, Callable<?> action) throws UnsupportedOperationException;
  
  /**
   * Remove the resource usage threshold associated with the action.
   * 
   * @throws IllegalArgumentException if the action is not associated with a threshold
   * @throws UnsupportedOperationException if this resource doesn't support thresholds
   */
  void removeThreshold(Callable<?> action) throws IllegalArgumentException, UnsupportedOperationException;
}
