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
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.spatial.SpatialOps;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.Point;
import org.jetbrains.annotations.Nullable;

/**
 * A MultiSurface is a 2-dimensional GeometryCollection whose elements are Surfaces, all using coordinates from
 * the same coordinate reference system. The geometric interiors of any two Surfaces in a MultiSurface may not
 * intersect in the full coordinate system. The boundaries of any two coplanar elements in a MultiSurface may
 * intersect, at most, at a finite number of Points. If they were to meet along a curve, they could be merged into a
 * single surface.
 *
 * @author tiwe
 *
 * @param <T> the type
 */
public abstract class JTSMultiSurfaceExpression<T extends GeometryCollection> extends JTSGeometryCollectionExpression<T> {

    private static final long serialVersionUID = 4133386816772862010L;

    @Nullable
    private transient volatile JTSPointExpression<Point> centroid, pointOnSurface;

    @Nullable
    private transient volatile NumberExpression<Double> area;

    public JTSMultiSurfaceExpression(Expression<T> mixin) {
        super(mixin);
    }

    /**
     * The area of this MultiSurface, as measured in the spatial reference system of this MultiSurface.
     *
     * @return area
     */
    public NumberExpression<Double> area() {
        if (area == null) {
            area = Expressions.numberOperation(Double.class, SpatialOps.AREA, mixin);
        }
        return area;
    }

    /**
     * The mathematical centroid for this MultiSurface. The result is not guaranteed to be on
     * this MultiSurface.
     *
     * @return centroid
     */
    public JTSPointExpression<Point> centroid() {
        if (centroid == null) {
            centroid = JTSGeometryExpressions.pointOperation(SpatialOps.CENTROID, mixin);
        }
        return centroid;
    }

    /**
     * A Point guaranteed to be on this MultiSurface.
     *
     * @return point on surface
     */
    public JTSPointExpression<Point> pointOnSurface() {
        if (pointOnSurface == null) {
            pointOnSurface = JTSGeometryExpressions.pointOperation(SpatialOps.POINT_ON_SURFACE, mixin);
        }
        return pointOnSurface;
    }

}
