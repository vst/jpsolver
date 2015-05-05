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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public class ValueList<E extends Value> implements ValueCollection, List<E> {
    /**
     * Defines the internal data of the value.
     */
    private final ArrayList<E> data = new ArrayList<E>();

    /**
     * Default constructor of the value list.
     */
    public ValueList () {
        this.init(Collections.EMPTY_LIST);
    }

    /**
     * Constructor which consumes a {@link java.util.List} and initializes
     * internal data with its content.
     *
     * <p>If the argument is {@code null}, it initializes an empty list instead.</p>
     *
     * @param data The data which value is goint to be initialized with.
     */
    public ValueList (List<E> data) {
        if (data == null) {
            data = Collections.EMPTY_LIST;
        }
        this.init(data);
    }

    /**
     * Initializes the internal data and related structure, if any.
     *
     * @param data The internal data.
     */
    private void init (List<E> data) {
        this.data.addAll(data);
    }

    @Override
    public ArrayList<E> get() {
        return this.data;
    }

    @Override
    public boolean isList () {
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
    public boolean contains(Object o) {
        return this.data.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return this.data.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.data.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return this.data.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return this.data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return this.data.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return this.data.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.data.retainAll(c);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public E get(int index) {
        return this.data.get(index);
    }

    @Override
    public E set(int index, E element) {
        return this.data.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        this.data.add(index, element);
    }

    @Override
    public E remove(int index) {
        return this.data.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.data.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.data.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return this.data.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return this.data.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.data.subList(fromIndex, toIndex);
    }
}