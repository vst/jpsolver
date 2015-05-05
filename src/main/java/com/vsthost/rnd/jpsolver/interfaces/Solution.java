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

package com.vsthost.rnd.jpsolver.interfaces;

import com.vsthost.rnd.jpsolver.data.Value;
import com.vsthost.rnd.jpsolver.errors.ProgramWarning;

import java.util.List;
import java.util.Map;

/**
 * TODO: Complete the documentation.
 *
 * @author Vehbi Sinan Tunalioglu
 */
public interface Solution {
    public boolean hasValue ();
    public Value getValue();

    public boolean hasWarnings ();
    public List<ProgramWarning> getWarnings ();

    public boolean hasAttribute (String name);
    public Object getAttribute(String name);
    public Map<String, Object> getAttributes();

    public default String toJson () {
        return this.getValue().toJson();
    };
}
