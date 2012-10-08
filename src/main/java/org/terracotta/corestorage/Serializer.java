/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.nio.ByteBuffer;

public interface Serializer<T> {
  
  T deserialize(ByteBuffer buffer);

  ByteBuffer serialize(T t);

  boolean equals(ByteBuffer left, Object right);
}
