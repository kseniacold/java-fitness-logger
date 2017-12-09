### Java desktop fitness logger application

Educational prototype for JavaFx desktop application,
using MVC architecture.

---

### Project structure

* /models - classes that handle application logic
* /views - .fxml GUI screens
* /controllers - classes that handle interactions with the GUI
* /services - heavy lifting from/to the database
* /utils - helper classes


---

### Technology & development stack

* IDE: IntelliJ IDEA with JVM 1.8
* SQLite embedded database
* JUnit5 testing framework
* JavaFx GUI Application

--- 

### Development limitations
###### There is a number of restrictions in development environment:

* Multiple users can be registered in the database, however once a user is registered in the database, user with *id#1* will be picked as the application user.
* Passwords are stored as not encrypted `text` value, which is not possible in production. 

