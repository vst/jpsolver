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

import com.vsthost.rnd.jpsolver.errors.ProgramError;

import java.util.concurrent.Future;

/**
 * Defines a problem solver.
 *
 * <p>A {@link Program} is a specialized executable which consumes {@link Problem} and
 * produces a {@link Solution} through its {@link Program#compute}
 * method or throws a runtime exception in case that the solution could
 * not be computed. Different {@link com.vsthost.rnd.jpsolver.errors.ProgramError}
 * can be thrown for different reasons.</p>
 *
 * <p>Each program is specialised for a given type of problem and targets
 * a specific {@link RuntimeEnvironment}.</p>
 *
 * @author vst
 */
public interface Program {
    /**
     * Consumes a {@link Problem} and produces a {@link Solution} or
     * throws a {@link com.vsthost.rnd.jpsolver.errors.ProgramError}.
     *
     * @param problem the {@link Problem} to be solved.
     * @return The {@link Solution} to the consumed {@link Problem}.
     * @throws com.vsthost.rnd.jpsolver.errors.ProgramError Thrown if there is a program related error.
     */
    public Solution compute (Problem problem) throws ProgramError;

    /**
     * Consumes a {@link Problem} and produces a {@link Future} {@link Solution}
     * to be produced asynchronously.
     *
     * <p>Note that the when trying to retrieve the {@link Solution} from the {@link Future},
     * a ProgramError may be thrown if any as {@link Future} will keep it to be
     * raised later while accessing its value, ie. {@link Solution}.</p>
     *
     * @param problem the {@link Problem} to be solved.
     * @return The {@link Solution} to the consumed {@link Problem}.
     */
    public Future<Solution> computeAsync (Problem problem);
}
