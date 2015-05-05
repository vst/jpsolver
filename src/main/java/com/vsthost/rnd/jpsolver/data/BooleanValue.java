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
public final class BooleanValue implements ScalarValue {
    /**
     * Defines a static, final {@code true} value.
     */
    public static final BooleanValue TRUE = new BooleanValue(true);

    /**
     * Defines a static, final {@code false} value.
     */
    public static final BooleanValue FALSE = new BooleanValue(false);

    /**
     * Defines the data of the scalar value.
     */
    private final Boolean data;

    /**
     * Default constructor.
     */
    public BooleanValue () {
        this.data = false;
    }

    /**
     * Default constructor consuming a boolean value.
     *
     * @param bool The boolean value data.
     */
    public BooleanValue (Boolean bool) {
        this.data = bool;
    }

    @Override
    public Boolean get() {
        return this.data;
    }
}
