/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.io.IOException;

public interface Transformer<T, U> {

  T recover(U transformed) throws IOException;

  U transform(T original) throws IOException;

  boolean equals(T left, U right) throws IOException;
  
  Class<U> getTargetClass();
}
