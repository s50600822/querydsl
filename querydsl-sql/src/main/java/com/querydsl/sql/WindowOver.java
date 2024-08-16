/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.sql;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Operator;
import com.querydsl.core.types.dsl.SimpleOperation;

import java.util.Arrays;
import java.util.Collections;

/**
 * {@code WindowOver} is the first part of a WindowFunction construction
 *
 * @author tiwe
 *
 * @param <T> the type
 */
public class WindowOver<T> extends SimpleOperation<T> {

    private static final long serialVersionUID = 464583892898579544L;

    public WindowOver(Class<? extends T> type, Operator op) {
        super(type, op, Collections.emptyList());
    }

    public WindowOver(Class<? extends T> type, Operator op, Expression<?> arg) {
        super(type, op, Collections.singletonList(arg));
    }

    public WindowOver(Class<? extends T> type, Operator op, Expression<?> arg1, Expression<?> arg2) {
        super(type, op, Arrays.asList(arg1, arg2));
    }

    public WindowFirstLast<T> keepFirst() {
        return new WindowFirstLast<T>(this, true);
    }

    public WindowFirstLast<T> keepLast() {
        return new WindowFirstLast<T>(this, false);
    }

    public WindowFunction<T> over() {
        return new WindowFunction<T>(this);
    }

}
