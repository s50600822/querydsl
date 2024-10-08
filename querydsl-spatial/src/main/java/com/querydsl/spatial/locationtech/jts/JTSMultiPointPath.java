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

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathImpl;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.Visitor;
import org.locationtech.jts.geom.MultiPoint;

import java.lang.reflect.AnnotatedElement;

/**
 * {@code JTSMultiPointPath} extends {@link JTSMultiPointExpression} to implement the
 * {@link Path} interface
 *
 * @author tiwe
 *
 * @param <T> the type
 */
public class JTSMultiPointPath<T extends MultiPoint> extends JTSMultiPointExpression<T> implements Path<T> {

    private static final long serialVersionUID = 312776751843333543L;

    private final PathImpl<T> pathMixin;

    @SuppressWarnings("unchecked")
    public JTSMultiPointPath(Path<?> parent, String property) {
        this((Class<? extends T>) MultiPoint.class, parent, property);
    }

    public JTSMultiPointPath(Class<? extends T> type, Path<?> parent, String property) {
        this(type, PathMetadataFactory.forProperty(parent, property));
    }

    @SuppressWarnings("unchecked")
    public JTSMultiPointPath(PathMetadata metadata) {
        this((Class<? extends T>) MultiPoint.class, metadata);
    }

    public JTSMultiPointPath(Class<? extends T> type, PathMetadata metadata) {
        super(ExpressionUtils.path(type, metadata));
        this.pathMixin = (PathImpl<T>) mixin;
    }

    @SuppressWarnings("unchecked")
    public JTSMultiPointPath(String var) {
        this((Class<? extends T>) MultiPoint.class, PathMetadataFactory.forVariable(var));
    }

    @Override
    public final <R,C> R accept(Visitor<R,C> v, C context) {
        return v.visit(pathMixin, context);
    }

    public JTSMultiPointPath(Class<? extends T> type, String var) {
        this(type, PathMetadataFactory.forVariable(var));
    }

    @Override
    public PathMetadata getMetadata() {
        return pathMixin.getMetadata();
    }

    @Override
    public Path<?> getRoot() {
        return pathMixin.getRoot();
    }

    @Override
    public AnnotatedElement getAnnotatedElement() {
        return pathMixin.getAnnotatedElement();
    }

}
