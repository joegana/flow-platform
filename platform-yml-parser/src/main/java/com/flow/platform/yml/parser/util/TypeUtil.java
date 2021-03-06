/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.yml.parser.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author yh@firim
 */
public class TypeUtil {

    /**
     * get class from type
     */
    public static Class<?> getRawType(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        }

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterized = (ParameterizedType) type;
            return (Class<?>) parameterized.getRawType();
        }

        return null;
    }

    /**
     * get collection element type
     */
    public static Class<?> getCollectionElementType(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        }

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterized = (ParameterizedType) type;
            return (Class<?>) parameterized.getActualTypeArguments()[0];
        }

        return null;
    }

    /**
     * get array element type
     */
    public static Type getArrayComponentType(Type array) {
        return array instanceof GenericArrayType
            ? ((GenericArrayType) array).getGenericComponentType()
            : ((Class<?>) array).getComponentType();
    }

}
