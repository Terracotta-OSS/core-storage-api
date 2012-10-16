/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.nio.ByteBuffer;

public abstract class Serializer<T> implements Transformer<T, ByteBuffer> {

  @Override
  public Class<ByteBuffer> getTargetClass() {
    return ByteBuffer.class;
  }
}
