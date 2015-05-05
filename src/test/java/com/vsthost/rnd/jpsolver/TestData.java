/*
 * Copyright (c) 2014 Vehbi Sinan Tunalioglu
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
package com.vsthost.rnd.jpsolver;

import com.vsthost.rnd.jpsolver.data.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * TODO: Complete documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public class TestData {

    // Define static, final values:
    private BooleanValue booleanValueFalse = BooleanValue.FALSE;
    private BooleanValue booleanValueTrue = BooleanValue.TRUE;
    private NumericValue numericValueZero = NumericValue.ZERO;
    private NumericValue numericValueOne = NumericValue.ONE;
    private NumericValue numericValueHundred = NumericValue.HUNDRED;
    private NumericValue numericValueThousand = NumericValue.THOUSAND;
    private TextValue textValueEmpty = TextValue.EMPTY;

    // Declare values:
    private BooleanValue booleanValue;
    private NumericValue numericValue;
    private TextValue textValue;
    private ValueList<Value> valueList;
    private ValueMap<String, Value> valueMap;

    @Before
    public void setupData () {
        this.booleanValue = new BooleanValue(true);
        this.numericValue = new NumericValue(42);
        this.textValue = new TextValue("42");
    }

    @Test
    public void testDefaultNoneValues () {
        assertTrue(Value.NONE.isNone());
        assertFalse(Value.NONE.isScalar());
        assertFalse(Value.NONE.isCollection());
        assertFalse(Value.NONE.isList());
        assertFalse(Value.NONE.isMap());

        assertTrue(ScalarValue.NONE.isNone());
        assertFalse(ScalarValue.NONE.isScalar());
        assertFalse(ScalarValue.NONE.isCollection());
        assertFalse(ScalarValue.NONE.isList());
        assertFalse(ScalarValue.NONE.isMap());

        assertTrue(BooleanValue.NONE.isNone());
        assertFalse(BooleanValue.NONE.isScalar());
        assertFalse(BooleanValue.NONE.isCollection());
        assertFalse(BooleanValue.NONE.isList());
        assertFalse(BooleanValue.NONE.isMap());

        assertTrue(NumericValue.NONE.isNone());
        assertFalse(NumericValue.NONE.isScalar());
        assertFalse(NumericValue.NONE.isCollection());
        assertFalse(NumericValue.NONE.isList());
        assertFalse(NumericValue.NONE.isMap());

        assertTrue(TextValue.NONE.isNone());
        assertFalse(TextValue.NONE.isScalar());
        assertFalse(TextValue.NONE.isCollection());
        assertFalse(TextValue.NONE.isList());
        assertFalse(TextValue.NONE.isMap());

        assertTrue(ValueList.NONE.isNone());
        assertFalse(ValueList.NONE.isScalar());
        assertFalse(ValueList.NONE.isCollection());
        assertFalse(ValueList.NONE.isList());
        assertFalse(ValueList.NONE.isMap());

        assertTrue(ValueMap.NONE.isNone());
        assertFalse(ValueMap.NONE.isScalar());
        assertFalse(ValueMap.NONE.isCollection());
        assertFalse(ValueMap.NONE.isList());
        assertFalse(ValueMap.NONE.isMap());
    }

    @Test
    public void testNumericValue () {
        // Test equalities of different constructors:
        assertEquals(new NumericValue(42), new NumericValue("42"));
        assertEquals(new NumericValue(42L), new NumericValue("42"));
        assertEquals(new NumericValue(42.0), new NumericValue("42"));
        assertEquals(new NumericValue(Integer.valueOf("42")), new NumericValue("42"));
        assertEquals(new NumericValue(Long.valueOf("42")), new NumericValue("42"));
        assertEquals(new NumericValue(Double.valueOf("42")), new NumericValue("42"));
        assertEquals(new NumericValue(BigDecimal.valueOf(42)), new NumericValue("42"));

        // Test toString method:
        assertEquals(new NumericValue(42).toString(), "42");
        assertEquals(new NumericValue(42L).toString(), "42");
        assertEquals(new NumericValue(42.0).toString(), "42.0");

        // Test comparable interface:
        assertEquals(new NumericValue(41).compareTo(new NumericValue("42")), -1);
        assertEquals(new NumericValue(41L).compareTo(new NumericValue("42")), -1);
        assertEquals(new NumericValue(41.0).compareTo(new NumericValue("42")), -1);
        assertEquals(new NumericValue(42).compareTo(new NumericValue("42")), 0);
        assertEquals(new NumericValue(42L).compareTo(new NumericValue("42")), 0);
        assertEquals(new NumericValue(42.0).compareTo(new NumericValue("42")), 0);
        assertEquals(new NumericValue(43).compareTo(new NumericValue("42")), 1);
        assertEquals(new NumericValue(43L).compareTo(new NumericValue("42")), 1);
        assertEquals(new NumericValue(43.0).compareTo(new NumericValue("42")), 1);
    }

    @Test
    public void testList () {
        // Test the NONE value list:
        assertEquals(ValueList.NONE, Value.NONE);

        // Get the value list:
        this.valueList = new ValueList<>();

        // Check the size:
        assertEquals(this.valueList.size(), 0);

        // Add an element:
        valueList.add(Value.NONE);

        // Check the size:
        assertEquals(this.valueList.size(), 1);

        // Add an empty list:
        valueList.addAll(new ArrayList<>());

        // Check the size:
        assertEquals(this.valueList.size(), 1);

        // Add a list of items of length 2:
        valueList.addAll(Arrays.asList(NumericValue.ZERO, NumericValue.ONE));

        // Check the size:
        assertEquals(this.valueList.size(), 3);

        // Check elements:
        assertEquals(this.valueList.get(0), Value.NONE);
        assertEquals(this.valueList.get(1), NumericValue.ZERO);
        assertEquals(this.valueList.get(2), NumericValue.ONE);
    }

    @Test
    public void testMap () {
        // Test the NONE value map:
        assertEquals(ValueMap.NONE, Value.NONE);

        // Get the value list:
        this.valueMap = new ValueMap<>();

        // Check the size:
        assertEquals(this.valueMap.size(), 0);

        // Add an element:
        valueMap.put("none", Value.NONE);

        // Check the size:
        assertEquals(this.valueMap.size(), 1);

        // Add an empty map:
        valueMap.putAll(new HashMap<>());

        // Check the size:
        assertEquals(this.valueMap.size(), 1);

        // Check elements:
        assertEquals(this.valueMap.get("none"), Value.NONE);
    }

    @Test
    public void testSimpleJsonWrite () {
        // Check the NONE value:
        assertEquals(Value.NONE.toJson(), "null");

        // Check booleans:
        assertEquals(new BooleanValue(true).toJson(), "true");
        assertEquals(new BooleanValue(false).toJson(), "false");

        // Check numbers:
        assertEquals(NumericValue.ZERO.toJson(), "0");
        assertEquals(NumericValue.ONE.toJson(), "1");
        assertEquals(NumericValue.TEN.toJson(), "10");
        assertEquals(NumericValue.HUNDRED.toJson(), "100");
        assertEquals(NumericValue.THOUSAND.toJson(), "1000");

        // Check Text:
        assertEquals(TextValue.EMPTY.toJson(), "\"\"");
        assertEquals(new TextValue("42").toJson(), "\"42\"");
    }

    @Test
    public void testJsonReadPrimitives () {
        assertEquals(ValueBuilder.fromJson("null"), Value.NONE);
        assertEquals(ValueBuilder.fromJson("true"), BooleanValue.TRUE);
        assertEquals(ValueBuilder.fromJson("false"), BooleanValue.FALSE);
        assertEquals(ValueBuilder.fromJson("\"\"").get(), TextValue.EMPTY.get());
        assertEquals(ValueBuilder.fromJson("\"42\"").get(), new TextValue("42").get());
        assertEquals(ValueBuilder.fromJson("0").get(), new NumericValue("0").get());
    }

    @Test
    public void testJsonReadList () {
        assertEquals(((ValueList<Value>) ValueBuilder.fromJson("[]")).size(), 0);
        assertEquals(((ValueList<Value>) ValueBuilder.fromJson("[1]")).size(), 1);
        assertEquals(((ValueList<Value>) ValueBuilder.fromJson("[1,2]")).size(), 2);
        assertEquals(((ValueList<Value>) ValueBuilder.fromJson("[1,2,3]")).get(0).get(), BigDecimal.ONE);
        assertEquals(((ValueList<Value>) ValueBuilder.fromJson("[1,2,3]")).get(1).get(), BigDecimal.valueOf(2));
        assertEquals(((ValueList<Value>) ValueBuilder.fromJson("[1,2,3]")).get(2).get(), BigDecimal.valueOf(3));
        assertEquals(((ValueList<Value>) ((ValueList<Value>) ValueBuilder.fromJson("[[1,2,3]]")).get(0)).size(), 3);
    }

    @Test
    public void testJsonReadMap () {
        assertEquals(((ValueMap<String, Value>) ValueBuilder.fromJson("{}")).size(), 0);
        assertEquals(((ValueMap<String, Value>) ValueBuilder.fromJson("{\"a\": 1}")).size(), 1);
        assertEquals(((ValueMap<String, Value>) ValueBuilder.fromJson("{\"a\": 1}")).get("a").get(), BigDecimal.ONE);
        assertEquals(((ValueMap<String, Value>) ValueBuilder.fromJson("{\"b\": [1,2,3]}")).get("b").getClass(), ValueList.class);
    }
}
