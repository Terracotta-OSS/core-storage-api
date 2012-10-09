/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage.monitoring;

import java.util.concurrent.Callable;

/**
 *
 * @author Chris Dennis
 */
public interface MonitoredResource {

  /**
   * Returns the amount of used resource.
   * 
   * @return used resource
   */
  long getUsed();

  /**
   * Returns the amount of free resource.
   * 
   * @return free resource
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
   */
  void addUsedThreshold(long value, Callable<?> action);

  /**
   * Set a resource usage threshold condition and associated callback.
   */
  void addReservedThreshold(long value, Callable<?> action);
  
  /**
   * Remove the resource usage threshold associated with the action.
   * 
   * @throws IllegalArgumentException if the action is not associated with a threshold
   */
  void removeThreshold(Callable<?> action) throws IllegalArgumentException;
}
