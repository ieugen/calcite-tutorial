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

import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.impl.AbstractTable;

/**
 * Table representing an Apache Lucene index.
 *
 * The table corresponds to a basic implementation of the {@link LuceneTable} interface
 * merely wrapping the path to the Lucene index.
 */
public final class LuceneBasicTable extends AbstractTable implements LuceneTable {
  private final String indexPath;
  private final RelDataType dataType;

  LuceneBasicTable(String indexPath, RelDataType dataType) {
    this.indexPath = indexPath;
    this.dataType = dataType;
  }

  @Override public RelDataType getRowType(final RelDataTypeFactory typeFactory) {
    return typeFactory.copyType(dataType);
  }

  @Override public String indexPath() {
    return indexPath;
  }
}
