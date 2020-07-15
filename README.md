##Library Management System

###Requirements:
Java
Tomcat

###Steps to Install and Run:

1. clone the repo
2. Setup MySQL with Database named `LibraryManagement`
3. Create a file `Credentials.java` at `/LibraryManagementSystem/src/Credentials.java` with the following structure

```
public class Credentials {
	static String username = "your_database_username";
	static String pass = "your_database_password";
}
```

4. Create the tables using following commands;
	a. `create table Book(id int(10) not null auto_increment, name varchar(30), copies int(10));`
	b. `create table Reservation(id int(10) not null auto_increment, bookid int(10), username varchar(40), fromDate datetime, toDate datetime, primary key (id), foreign key(bookid) references Book(id));`
	
5. In `tomcat-users.xml` to add users, add the following code

```
<tomcat-users>
  <role rolename="librarian"/>
  <role rolename="user"/>
  <user username="librarian" password="set_librarian_password" roles="librarian,user"/>
  <user username="user" password="set_user_password" roles="user"/>
  ...
</tomcat-users>
```

6. Run tomcat server
7. Go To `http://localhost:8080/LibraryManagementSystem/`