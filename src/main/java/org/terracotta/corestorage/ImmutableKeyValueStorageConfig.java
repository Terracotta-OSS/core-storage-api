/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.corestorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableKeyValueStorageConfig<K, V> implements KeyValueStorageConfig<K, V> {

  private static final int DEFAULT_CONCURRENCY = 16;
  
  private final Class<K> keyClass;
  private final Class<V> valueClass;
  private final Transformer<? super K, ?> keySerializer;
  private final Transformer<? super V, ?> valueSerializer;
  private final int concurrency;
  
  private final transient List<KeyValueStorageMutationListener<? super K, ? super V>> listeners;

  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass) {
    this(keyClass, valueClass, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList());
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, int concurrency) {
    this(keyClass, valueClass, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList(), concurrency);
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, List<KeyValueStorageMutationListener<? super K, ? super V>> listeners) {
    this(keyClass, valueClass, null, null, listeners);
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, List<KeyValueStorageMutationListener<? super K, ? super V>> listeners, int concurrency) {
    this(keyClass, valueClass, null, null, listeners, concurrency);
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, Transformer<? super K, ?> keySerializer, Transformer<? super V, ?> valueSerializer) {
    this(keyClass, valueClass, keySerializer, valueSerializer, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList());
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, Transformer<? super K, ?> keySerializer, Transformer<? super V, ?> valueSerializer, int concurrency) {
    this(keyClass, valueClass, keySerializer, valueSerializer, Collections.<KeyValueStorageMutationListener<? super K, ? super V>>emptyList(), concurrency);
  }
  
  public ImmutableKeyValueStorageConfig(Class<K> keyClass, Class<V> valueClass, Transformer<? super K, ?> keySerializer, Transformer<? super V, ?> valueSerializer, List<KeyValueStorageMutationListener<? super K, ? super V>> listeners) {
    this(keyClass, valueClass, keySerializer, valueSerializer, listeners, DEFAULT_CONCURRENCY);
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
}
