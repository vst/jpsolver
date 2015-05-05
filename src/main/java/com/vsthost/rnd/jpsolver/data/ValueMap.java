/*
 * Copyright (c) 2013-2014 Vehbi Sinan Tunalioglu
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

package com.vsthost.rnd.jpsolver.data;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public final class ValueMap<String, E extends Value> implements ValueCollection, Map<String, E> {
    /**
     * Defines the internal data of the value.
     */
    private final ConcurrentHashMap<String, E> data = new ConcurrentHashMap<>();

    /**
     * Constructor which creates and empty list.
     */
    public ValueMap () {
        this.init(new HashMap<>());
    }

    /**
     * Constructor which initialises a {@link ConcurrentHashMap} with the
     * given {@link Map}.
     *
     * @param data The data which will be used to construct internal data.
     */
    public ValueMap (Map<String, E> data) {
        if (data != null) {
            this.init(data);
        }
    }

    /**
     * Initializes the internal data and related structure, if any.
     *
     * @param data The internal data of the Key/{@link Value} mapping.
     */
    private void init (Map<String, E> data) {
        this.putAll(data);
    }

    @Override
    public ConcurrentHashMap<String, E> get() {
        return this.data;
    }

    @Override
    public boolean isMap() {
        return true;
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.data.containsValue(value);
    }

    @Override
    public E get(Object key) {
        return this.data.get(key);
    }

    @Override
    public E remove(Object key) {
        return this.data.remove(key);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.data.keySet();
    }

    @Override
    public Collection<E> values() {
        return this.data.values();
    }

    @Override
    public Set<Entry<String, E>> entrySet() {
        return this.data.entrySet();
    }

    @Override
    public void putAll(Map<? extends String, ? extends E> m) {
        this.data.putAll(m);
    }

    @Override
    public E put(String key, E value) {
        return this.data.put(key, value);
    }

    public E put(String key, java.lang.String value) {
        return this.data.put(key, (E) new TextValue(value));
    }

    public E put(String key, Integer value) {
        return this.data.put(key, (E) new NumericValue(value));
    }

    public E put(String key, Long value) {
        return this.data.put(key, (E) new NumericValue(value));
    }

    public E put(String key, Double value) {
        return this.data.put(key, (E) new NumericValue(value));
    }

    public E put(String key, BigDecimal value) {
        return this.data.put(key, (E) new NumericValue(value));
    }

    public E put(String key, Boolean value) {
        return this.data.put(key, (E) new BooleanValue(value));
    }

    public E put(String key, Integer[] values) {
        ValueList<NumericValue> valueList = new ValueList<>();
        for (Integer i : values) {
            valueList.add(new NumericValue(i));
        }
        return this.data.put(key, (E) valueList);
    }

    public E put(String key, Long[] values) {
        ValueList<NumericValue> valueList = new ValueList<>();
        for (Long i : values) {
            valueList.add(new NumericValue(i));
        }
        return this.data.put(key, (E) valueList);
    }

    public E put(String key, Double[] values) {
        ValueList<NumericValue> valueList = new ValueList<>();
        for (Double i : values) {
            valueList.add(new NumericValue(i));
        }
        return this.data.put(key, (E) valueList);
    }

    public E put(String key, BigDecimal[] values) {
        ValueList<NumericValue> valueList = new ValueList<>();
        for (BigDecimal i : values) {
            valueList.add(new NumericValue(i));
        }
        return this.data.put(key, (E) valueList);
    }
}
