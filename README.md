# BasiDiDati

#how to :

###postgres

  download postgresql 
  
  connect to postgresql using command  **su - postgresql**
  
  create superuser using command **createuser -P -s -e username**
  
  1. "username" must be **"superuser"**
  
  2. "password" must be **"password"**

now you have to create a database. You can do it typing **psql** in postgresql shell and **CREATE DATABASE testdb OWNER superuser**

###eclipse
open the project and go to SQLfile (**tableCreator.sql**). It may works but if it doesn't you have to connect it to testdb database.

In the first usage **delete command DROP SHEMA [...]**. It's goal is to clean current database but in a first time this schema is not in your database and it return an error
