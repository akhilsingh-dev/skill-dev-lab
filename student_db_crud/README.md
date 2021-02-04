# student_db_crud

This Directory/Package holds the code for the student database CRUD app made in Java.
The build uses Maven and PostgreSQL.

To know more about the versioning, refer [pom file](https://github.com/theDrake1010/skill-dev-lab/blob/master/student_db_crud/pom.xml)'s dependencies tag.


## What can it do?
1. Create a new Student in the DB
2. Read the list of students in the DB
3. Update/Modify existing student data in DB
4. Delete a student's data from the DB

**Note: You need to add a `db_cred.txt` file with the following format:**

```
<your database name here>
<your database username here>
<your database password here>
```

Make sure that these are on 3 separate lines. Eg:

```
myDatabase
postgres
postgres
```