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

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public final class TextValue implements ScalarValue {
    /**
     * Defines a static, final {@code NONE} value.
     */
    public static final TextValue EMPTY = new TextValue("");

    /**
     * Defines the data of the scalar value.
     */
    private final String data;

    /**
     * Default constructor, constructing an empty text value.
     */
    public TextValue () {
        this.data = "";
    }

    /**
     * Constructs a {@link TextValue} from a {@link java.lang.String}.
     *
     * @param value The value as a {@link java.lang.String}.
     */
    public TextValue (String value) {
        this.data = value;
    }

    @Override
    public String get() {
        return this.data;
    }

    /**
     * Indicates if the {@link TextValue} is empty.
     *
     * @return {@code true} of the value is empty text, {@code false} otherwise.
     */
    public boolean isEmpty () {
        if (this.isNone()) {
            return true;
        }
        return this.get().isEmpty();
    }
}
