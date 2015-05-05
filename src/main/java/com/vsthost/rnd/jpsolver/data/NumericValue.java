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

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public final class NumericValue implements ScalarValue, Comparable<NumericValue> {
    /**
     * Defines a static, final {@code 0} value.
     */
    public static final NumericValue ZERO = new NumericValue(BigDecimal.ZERO);

    /**
     * Defines a static, final {@code 1} value.
     */
    public static final NumericValue ONE = new NumericValue(BigDecimal.ONE);

    /**
     * Defines a static, final {@code 10} value.
     */
    public static final NumericValue TEN = new NumericValue(BigDecimal.TEN);

    /**
     * Defines a static, final {@code 100} value.
     */
    public static final NumericValue HUNDRED = new NumericValue(BigDecimal.TEN.pow(2));

    /**
     * Defines a static, final {@code 1000} value.
     */
    public static final NumericValue THOUSAND = new NumericValue(BigDecimal.TEN.pow(3));

    /**
     * Defines the data of the scalar value.
     */
    private final BigDecimal data;

    /**
     * Constructs a {@link NumericValue} from a {@link java.math.BigDecimal} value.
     *
     * @param value The value as a {@link java.math.BigDecimal} value.
     */
    public NumericValue (BigDecimal value) {
        this.data = value;
    }

    /**
     * Constructs a {@link NumericValue} from an {@link java.lang.Integer} value.
     *
     * @param value The value as a {@link java.lang.Integer} value.
     */
    public NumericValue (Integer value) {
        this.data = BigDecimal.valueOf(value);
    }

    /**
     * Constructs a {@link NumericValue} from an {@link java.lang.Long} value.
     *
     * @param value The value as a {@link java.lang.Long} value.
     */
    public NumericValue (Long value) {
        this.data = BigDecimal.valueOf(value);
    }

    /**
     * Constructs a {@link NumericValue} from an {@link java.lang.Double} value.
     *
     * @param value The value as a {@link java.lang.Double} value.
     */
    public NumericValue (Double value) {
        this.data = BigDecimal.valueOf(value);
    }

    /**
     * Constructs a {@link NumericValue} from an {@link java.lang.String} value.
     *
     * @param value The value as a {@link java.lang.String} value.
     */
    public NumericValue (String value) {
        this.data = new BigDecimal(value);
    }

    @Override
    public String toString () {
        return this.get().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NumericValue) {
            return this.get().compareTo(((NumericValue) obj).get()) == 0;
        }
        return false;
    }

    @Override
    public int compareTo(NumericValue o) {
        return this.get().compareTo(o.get());
    }

    @Override
    public BigDecimal get() {
        return this.data;
    }

    /**
     * Returns the sign of the number.
     *
     * @return The sign of the number.
     */
    public Integer getSign () {
        if (this.isNone()) {
            return null;
        }
        return this.get().signum();
    }

    /**
     * Indicates if the number is {@code 0}.
     *
     * @return {@code true} if the number is {@code 0}, {@code false} otherwise.
     */
    public boolean isZero () {
        return this.getSign() == 0;
    }

    /**
     * Indicates if the number is negative.
     *
     * @return {@code true} if the number is negative, {@code false} otherwise.
     */
    public boolean isNegative () {
        return this.getSign() == -1;
    }

    /**
     * Indicates if the number is positive.
     *
     * @return {@code true} if the number is positive, {@code false} otherwise.
     */
    public boolean isPositive () {
        return this.getSign() == 1;
    }
}
