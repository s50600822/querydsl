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
import org.locationtech.jts.geom.MultiPolygon;

/**
 * A MultiPolygon is a MultiSurface whose elements are Polygons.
 *
 * @author tiwe
 *
 * @param <T> the type
 */
public abstract class JTSMultiPolygonExpression<T extends MultiPolygon> extends JTSMultiSurfaceExpression<T> {

    private static final long serialVersionUID = -2285946852207189655L;

    public JTSMultiPolygonExpression(Expression<T> mixin) {
        super(mixin);
    }

}
