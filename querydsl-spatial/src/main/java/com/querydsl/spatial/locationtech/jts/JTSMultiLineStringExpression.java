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
package com.querydsl.spatial.locationtech.jts;

import com.querydsl.core.types.Expression;
import org.locationtech.jts.geom.MultiLineString;

/**
 * A MultiLineString is a MultiCurve whose elements are LineStrings.
 *
 * @author tiwe
 *
 * @param <T> the type
 */
public abstract class JTSMultiLineStringExpression<T extends MultiLineString> extends JTSMultiCurveExpression<T> {

    private static final long serialVersionUID = -3103756880812584473L;

    public JTSMultiLineStringExpression(Expression<T> mixin) {
        super(mixin);
    }

}
