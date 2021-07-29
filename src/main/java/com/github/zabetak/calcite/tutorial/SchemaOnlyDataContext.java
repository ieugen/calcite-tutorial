/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.zabetak.calcite.tutorial;

import org.apache.calcite.DataContext;
import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.linq4j.QueryProvider;
import org.apache.calcite.schema.SchemaPlus;

/**
 * A simple data context only with schema information.
 */
final class SchemaOnlyDataContext implements DataContext {
  private final SchemaPlus schema;

  SchemaOnlyDataContext(CalciteSchema calciteSchema) {
    this.schema = calciteSchema.plus();
  }

  @Override public SchemaPlus getRootSchema() {
    return schema;
  }

  @Override public JavaTypeFactory getTypeFactory() {
    return new JavaTypeFactoryImpl();
  }

  @Override public QueryProvider getQueryProvider() {
    return null;
  }

  @Override public Object get(final String name) {
    return null;
  }
}
