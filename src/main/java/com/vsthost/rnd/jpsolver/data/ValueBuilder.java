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
package com.vsthost.rnd.jpsolver.data;

import com.google.gson.*;

import java.util.Map;

/**
 * TODO: Complete documentation.
 *
 * @author vst
 */
public class ValueBuilder {
    public static Value fromJson (String source) {
        // Create the reader:
        JsonParser reader = new JsonParser();

        // Get the element:
        JsonElement element = reader.parse(source);

        // Process the element into a Value instance:
        return ValueBuilder.fromJsonElement(element);
    }

    public static Value fromJsonElement(JsonElement element) {
        // Check primitive types:
        if (element instanceof JsonNull) {
            // Return the NONE value:
            return Value.NONE;
        }
        else if (element instanceof JsonPrimitive) {
            // Cast and get the primitive:
            JsonPrimitive primitive = (JsonPrimitive) element;

            // Check primitive types:
            if (primitive.isBoolean() ) {
                return primitive.getAsBoolean() ? BooleanValue.TRUE : BooleanValue.FALSE;
            }
            else if (primitive.isNumber()) {
                return new NumericValue(primitive.getAsBigDecimal());
            }
            else {
                return new TextValue(primitive.getAsString());
            }
        }
        else if (element instanceof JsonArray) {
            // Cast and get the array:
            JsonArray array = (JsonArray) element;

            // Iterate over the elements and populate the return value:
            ValueList<Value> retval = new ValueList<Value>();
            for (JsonElement e : array) {
                retval.add(ValueBuilder.fromJsonElement(e));
            }

            // Done, return:
            return retval;
        }
        else {
            // Cast and get the object:
            JsonObject object = (JsonObject) element;

            // Iterate over the elements and populate the return value:
            ValueMap retval = new ValueMap();
            for (Map.Entry<String, JsonElement> e : object.entrySet()) {
                retval.put(e.getKey(), ValueBuilder.fromJsonElement(e.getValue()));
            }

            // Done, return:
            return retval;
        }
    }
}
