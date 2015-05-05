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

package com.vsthost.rnd.jpsolver;

import com.vsthost.rnd.jpsolver.data.Value;
import com.vsthost.rnd.jpsolver.errors.ProgramWarning;
import com.vsthost.rnd.jpsolver.interfaces.Solution;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public class GenericSolution implements Solution {
    /**
     * Defines the data of the solution.
     */
    private Value value = null;

    /**
     * Defines a list of warnings.
     */
    private List<ProgramWarning> warnings = new ArrayList<ProgramWarning>();

    /**
     * Defines a map of attributes.
     */
    private Map<String, Object> attributes = new Hashtable<String, Object>();

    public GenericSolution (Value value) {
        this.value = value;
    }

    @Override
    public boolean hasValue() {
        return value != null;
    }

    @Override
    public Value getValue() {
        return this.value;
    }

    @Override
    public boolean hasWarnings() {
        return this.warnings.size() > 0;
    }

    @Override
    public List<ProgramWarning> getWarnings() {
        return this.warnings;
    }

    @Override
    public boolean hasAttribute(String name) {
        return this.attributes.containsKey(name);
    }

    @Override
    public Object getAttribute(String name) {
        return this.attributes.get(name);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }
}
