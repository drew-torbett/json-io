package com.cedarsoftware.util.reflect;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

/**
 * @author Kenny Partlow (kpartlow@gmail.com)
 *         <br>
 *         Copyright (c) Cedar Software LLC
 *         <br><br>
 *         Licensed under the Apache License, Version 2.0 (the "License");
 *         you may not use this file except in compliance with the License.
 *         You may obtain a copy of the License at
 *         <br><br>
 *         <a href="http://www.apache.org/licenses/LICENSE-2.0">License</a>
 *         <br><br>
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *         See the License for the specific language governing permissions and
 *         limitations under the License.*
 */
public interface InjectorFactory {

    /**
     * Creates accessors for accessing data from an object.
     *
     * @param field           The field we're trying to access
     * @param nonStandardNames a map of possible methods from the class itself
     * @param uniqueName a uniqueName to use as a key in map if the class has two methods with same name.
     * @return The accessor if one fits for this field, otherwise null.
     */
    Injector createInjector(Field field, Map<Class<?>, Map<String, String>> nonStandardNames, String uniqueName);

    default Optional<String> getMapping(Map<Class<?>, Map<String, String>> classToMapping, Class<?> c, String fieldName) {
        Map<String, String> mapping = classToMapping.get(c);
        return mapping == null ? Optional.empty() : Optional.ofNullable(mapping.get(fieldName));
    }
}
