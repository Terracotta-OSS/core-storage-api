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
package org.terracotta.corestorage.monitoring;

/**
 * Live view of the utilization of a resource.
 * <p>
 * The values given here are defined as:
 * <ul>
 * <li><em>Total</em>: the maximum amount of this resource that can ever be used. Unbounded resources may return {@code Long.MAX_VALUE} here.</li>
 * <li><em>Reserved</em>: the amount of this resource that has been reserved for use.</li>
 * <li><em>Used</em>: the amount of the reserved resource that is actively being used.</li>
 * <li><em>Vital</em>: the amount of the used resource that cannot be relinquished by the application.  Resources used for internal caching for example, may not
 * be vital.  This means they could be released by internal processes without requiring intervention by the user.</li>
 * </ul>
 * Values returned by resources should honor the relation: {@code vital <= used <= reserved <= total}.
 */
public interface MonitoredResource {

  enum Type {
    HEAP,
    OFFHEAP,
    DISK,
    DATA,
    OTHER;
  }
  
  /**
   * Returns the type of this resource.
   * 
   * @return resource type
   */
  Type getType();
  
  /**
   * Returns the amount of used resource that is vital.
   * 
   * @return vital resource
   */
  long getVital();
  
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
