<!--
{% comment %}
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to you under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
{% endcomment %}
-->
# Apache Calcite

A tutorial of [Apache Calcite]((http://calcite.apache.org))
for the [BOSS'21 VLDB workshop](https://boss-workshop.github.io/boss-2021/).

In this tutorial, we demonstrate the main components of Calcite and how they interact with each
other. To do this we build, step-by-step, a fully fledged query processor for data residing
in Lucene indexes, and gradually introduce various extensions covering some common use-cases
appearing in practice.

## Requirements

* JDK version >= 8

## Quickstart

To compile the project, run:

    ./mvnw package

To load/index the TPC-H dataset in Lucene, run:

    java -cp target/calcite-tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.zabetak.calcite.tutorial.setup.DatasetIndexer
    
The indexer creates the data under `target/tpch` directory. The TPC-H dataset was generated using
the dbgen command line utility (`dbgen -s 0.001`) provided in the original
[TPC-H tools](http://www.tpc.org/tpc_documents_current_versions/current_specifications5.asp) bundle.

To run queries over the data in Lucene, you can use one of the available query processors:

* `SIMPLE` processor, which uses exclusively one Calcite convention.
* `ADVANCED` processor, which uses two conventions, demonstrates the basis for creating a federated
query engine over different backends.
* `PUSHDOWN` processor, builds upon the `ADVANCED` processor, and outlines how to implement
rules to perform some common optimizations such as pushing filters to the underlying engine.


    java -cp target/calcite-tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.zabetak.calcite.tutorial.LuceneQueryProcessor SIMPLE queries/tpch/Q0.sql
    java -cp target/calcite-tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.zabetak.calcite.tutorial.LuceneQueryProcessor ADVANCED queries/tpch/Q0.sql
    java -cp target/calcite-tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.zabetak.calcite.tutorial.LuceneQueryProcessor PUSHDOWN queries/tpch/Q0.sql

You can use one of the predefined queries under `queries/tpch` directory or create a new file
and write your own. 