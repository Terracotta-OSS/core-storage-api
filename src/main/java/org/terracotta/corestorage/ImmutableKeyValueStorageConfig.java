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
package org.terracotta.corestorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableKeyValueStorageConfig<K, V> implements KeyValueStorageConfig<K, V> {

  private final Class<K> keyClass;
  private final Class<V> valueClass;
  private final Transformer<? super K, ?> keySerializer;
  private final Transformer<? super V, ?> valueSerializer;
  private final int concurrency;
  
  private final transient List<KeyValueStorageMutationListener<? super K, ? super V>> listeners;

  @Deprecated
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass) {
    this(keyClass, valueClass, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList());
  }
  
  @Deprecated
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, int concurrency) {
    this(keyClass, valueClass, null, null, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList(), concurrency);
  }
  
  @Deprecated
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, List<KeyValueStorageMutationListener<? super K, ? super V>> listeners) {
    this(keyClass, valueClass, null, null, listeners, 16);
  }
  
  @Deprecated
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, Transformer<? super K, ?> keySerializer, Transformer<? super V, ?> valueSerializer) {
    this(keyClass, valueClass, keySerializer, valueSerializer, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList(), 16);
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, Transformer<? super K, ?> keySerializer, Transformer<? super V, ?> valueSerializer, List<KeyValueStorageMutationListener<? super K, ? super V>> listeners, int concurrency) {
    this.keyClass = keyClass;
    this.valueClass = valueClass;
    this.keySerializer = keySerializer;
    this.valueSerializer = valueSerializer;
    this.listeners = Collections.unmodifiableList(new ArrayList(listeners));
    this.concurrency = concurrency;
  }
  
  @Override
  public List<KeyValueStorageMutationListener<? super K, ? super V>> getMutationListeners() {
    return listeners;
  }

  @Override
  public Class<K> getKeyClass() {
    return keyClass;
  }

  @Override
  public Class<V> getValueClass() {
    return valueClass;
  }

  @Override
  public Transformer<? super K, ?> getKeyTransformer() {
    return keySerializer;
  }

  @Override
  public Transformer<? super V, ?> getValueTransformer() {
    return valueSerializer;
  }

  @Override
  public int getConcurrency() {
    return concurrency;
  }

  public static <K, V> Builder<K, V> builder(Class<K> keyClass, Class<V> valueClass) {
    return new Builder(keyClass, valueClass);
  }
  
  public static class Builder<K, V> {
    
    private final Class<K> keyClass;
    private final Class<V> valueClass;
    private final List<KeyValueStorageMutationListener<? super K, ? super V>> listeners = new ArrayList<KeyValueStorageMutationListener<? super K, ? super V>>();
    private Transformer<? super K, ?> keyTransformer;
    private Transformer<? super V, ?> valueTransformer;
    private int concurrency = 16;

    public Builder(Class<K> keyClass, Class<V> valueClass) {
      this.keyClass = keyClass;
      this.valueClass = valueClass;
    }
    
    public Builder<K, V> keyTransformer(Transformer<? super K, ?> keyTransformer) {
      this.keyTransformer = keyTransformer;
      return this;
    }
    
    public Builder<K, V> valueTransformer(Transformer<? super V, ?> valueTransformer) {
      this.valueTransformer = valueTransformer;
      return this;
    }

    public Builder<K, V> concurrency(int concurrency) {
      this.concurrency = concurrency;
      return this;
    }
    
    public Builder<K, V> listener(KeyValueStorageMutationListener<? super K, ? super V> listener) {
      this.listeners.add(listener);
      return this;
    }
    
    public KeyValueStorageConfig<K, V> build() {
      return new ImmutableKeyValueStorageConfig(keyClass, valueClass, keyTransformer, valueTransformer, listeners, concurrency);
    }
  }
  
}
