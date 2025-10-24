## Ques1. List down 5 differences between Oracle and MySQL

#### 1. Primary Language - 
- `Oracle :` Uses PL/SQL (Procedural Language/SQL), which is a powerful, proprietary extension of SQL integrated deeply into the database.
- `MySQL :` Uses standard SQL and supports stored procedures, but its procedural language is less complex than PL/SQL.

#### 2. Cost & Licensing
- `Oracle :` Primarily a commercial, proprietary product. It is one of the most expensive databases, licensed per-processor or per-user.
- `MySQL :` Primarily open-source. It also has paid Enterprise Editions, but it is vastly more cost-effective.

#### 3. Scalability Model
- `Oracle :` Excels at "vertical scaling", running on a single, massive, powerful server. Its RAC (Real Application Clusters) provides high-availability clustering but is complex.
- `MySQL :` Excels at "horizontal scaling", distributing load across many smaller servers. It is famous for its simple and effective read replication.

### 4. Storage Architecture
- `Oracle :` Uses a complex physical and logical storage architecture involving tablespaces, data files, control files, and redo logs.
- `MySQL :` Simpler architecture. It uses "storage engines"  that handle how data is stored and indexed. InnoDB is the default and provides transaction support.

### 5. Transaction Control
- `Oracle :` Provides very granular and complex transaction control. By default, a COMMIT is required to make any data change permanent.
- `MySQL :` By default MySQL operates in autocommit mode, meaning each SQL statement is a complete transaction. This can be changed, but the default behavior is different.