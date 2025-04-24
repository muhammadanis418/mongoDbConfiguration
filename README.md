# MongoDb Configuration

### Introduction

MongoDb is nosql document based database. It store data in JSON like document(Binary JSON). It has very flexible structure to store the data. Column of database refered as afield in MongoDb. Large amount of data can be easily managed. It is used by well known companies like Google,Adobe,Cisco,SAP and e Bay etc. 

### Benefits of using NoSQl

NoSQL is schema-less (no fixed data model).
NoSQL databases have a dynamic schema for unstructured data, making integrating data in certain types of applications easier and faster.
Execution is alot faster then SQL because there is no join (Joins are complex take some time to execute).
NoSQL uses non-tabular data models, which can be document-oriented (MongoDB), key-value(Redis), or graph-based. The most common NoSQL databases include MongoDB, Cassandra, HBase, Redis, Neo4j, and CouchDB.
Relationships are not preferred in NoSQL.

### Structure of SQL & NOSQl

SQL Structure :

Database Name
   └── Table
        ├── Column
        └── Row

Foreign Key: Links tables by referencing a column in another table.

NoSQL Structure :

Database Name
   └── Collection
        ├── Field
        └── Document
               └── Sub Document (Reference)

Sub Document (Reference): Embeds or links a related document.

### MongoDB Configuration with Spring boot

Add spring data mongoDb dependency in pom file like for sql we use spring data jpa dependency.
In application.properties files provide port, host and database name.
By default the mongo port is 27017.

After adding dependencies you can use these annotation to lpersist the model into the Database. This is called ORM (Object Relational Mapping).

![image](https://github.com/user-attachments/assets/557eeca2-d6dd-495c-a29d-5722a7524cdf)

 > **Note**: Fields with the `@Transient` annotation will not be saved to the database. Such fields are excluded from the database representation.
> 
 > **Note**: `@PersistenceConstructor` annotation is used when we have more then 1 constructor in a class that is representing collection(Not for pojo classes).
> 
 > **Note**: Fields with the `@EnableMongoRepositories` place packages name of repositories. Use this annotation on main class & also provide package name.








        




