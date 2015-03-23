/* 
 * The contents of this file are subject to the Terracotta Public License Version
 * 2.0 (the "License"); You may not use this file except in compliance with the
 * You may obtain a copy of the License at 
 *
 *      http://terracotta.org/legal/terracotta-public-license.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Covered Software is Core Storage API.
 *
 * The Initial Developer of the Covered Software is 
 *      Terracotta, Inc., a Software AG company
 */
package org.terracotta.corestorage;

import java.io.IOException;

public interface Transformer<T, U> {

  T recover(U transformed) throws IOException;

  U transform(T original) throws IOException;

  boolean equals(T left, U right) throws IOException;
  
  Class<U> getTargetClass();
}
