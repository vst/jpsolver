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

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public interface Value {
    /**
     * Defines a NONE value.
     */
    public static final Value NONE = new Value() {
        @Override
        public Object get() {
            return null;
        }

        @Override
        public boolean isNone() {
            return true;
        }

        @Override
        public boolean isScalar() {
            return false;
        }

        @Override
        public boolean isCollection() {
            return false;
        }

        @Override
        public boolean isList() {
            return false;
        }

        @Override
        public boolean isMap() {
            return false;
        }
    };

    /**
     * Returns the data of the value.
     *
     * @return The data of the value.
     */
    public Object get ();

    /**
     * Indicates if the value is {@code NONE}.
     *
     * @return {@code true} if the value is {@code NONE}, {@code false} otherwise.
     */
    public default boolean isNone () { return this.get() == null; };

    /**
     * Indicates if the value is scalar.
     *
     * @return {@code true} if the value is scalar, {@code false} otherwise.
     */
    public boolean isScalar ();

    /**
     * Indicates if the value is a collection.
     *
     * @return {@code true} if the value is a collection, {@code false} otherwise.
     */
    public boolean isCollection ();

    /**
     * Indicates if the value is a list of values.
     *
     * @return {@code true} if the value is a list, {@code false} otherwise.
     */
    public boolean isList ();

    /**
     * Indicates if the value is a map, ie. Key/Value pairs.
     *
     * @return {@code true} if the value is a map, {@code false} otherwise.
     */
    public boolean isMap ();

    /**
     * Returns the JSON representation of the value.
     *
     * TODO: Implement a toJson (class, serializer) method for user-defined classes implementing Value interface.
     *
     * @return The JSON representation of the value.
     */
    public default String toJson () {
        // Initialize the Json builder:
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Register serializers for scalar values:
        gsonBuilder.registerTypeAdapter(BooleanValue.class, new ScalarValueSerializer());
        gsonBuilder.registerTypeAdapter(NumericValue.class, new ScalarValueSerializer());
        gsonBuilder.registerTypeAdapter(TextValue.class, new ScalarValueSerializer());

        // We want nulls to be serialized:
        gsonBuilder.serializeNulls();

        // Done, get the JSON:
        return gsonBuilder.create().toJson(this.get());
    }

    /**
     * TODO: Complete documentation.
     */
    public class ScalarValueSerializer implements JsonSerializer<ScalarValue> {
        public JsonElement serialize(ScalarValue src, Type typeOfSrc, JsonSerializationContext context) {
            // If the source is null or None, set to NULL.
            if (src == null || src.isNone()) {
                return JsonNull.INSTANCE;
            }

            // Check the type and write value accordingly:
            if (src instanceof BooleanValue) {
                return new JsonPrimitive(((BooleanValue) src).get());
            }
            else if (src instanceof NumericValue) {
                return new JsonPrimitive(((NumericValue) src).get());
            }
            else if (src instanceof TextValue) {
                return new JsonPrimitive(((TextValue) src).get());
            }

            // TODO: Why would this happen? Check it:
            return JsonNull.INSTANCE;
        }
    }
}
