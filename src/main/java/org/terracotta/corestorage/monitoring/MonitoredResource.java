/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage.monitoring;

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
   * Set a resource usage threshold condition and associated action.
   * <p>
   * Triggered threshold actions will be called synchronously and therefore
   * mutating a map that consumes the same resource in the action may cause
   * deadlocks.
   * 
   * @throws UnsupportedOperationException if this resource doesn't support thresholds
   */
  Runnable addUsedThreshold(Direction direction, long value, Runnable action);
  
  /**
   * Remove a resource usage threshold condition.
   */
  Runnable removeUsedThreshold(Direction direction, long value);
  
  /**
   * Set a resource reservation threshold condition and associated action.
   * <p>
   * Triggered threshold actions will be called synchronously and therefore
   * mutating a map that consumes the same resource in the action may cause
   * deadlocks.
   * 
   * @throws UnsupportedOperationException if this resource doesn't support thresholds
   */
  Runnable addReservedThreshold(Direction direction, long value, Runnable action);
  
  /**
   * Remove a resource reservation threshold condition.
   */
  Runnable removeReservedThreshold(Direction direction, long value);
  
  /**
   * Threshold transition directions.
   */
  enum Direction {
    RISING, FALLING;
  }
  
  
}
