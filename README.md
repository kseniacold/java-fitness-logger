# cs56-fitness-app
Java desktop fitness logger application

## Java desktop fitness logger application

Educational prototype for JavaFx Desktop application,
using MVC architecture.

---

### Project structure

* /models - classes handling application logic
* /views - .fxml GUI screens
* /controllers - classes that handle interactions with the GUI
* /services - heavy lifting from the database
* /utils - helper classes


---
### Development limitations
###### There is a number of restrictions in development environment:

* Multiple users can be registered in the database, however once a user is registered in the database, user with *id#1* will be picked as the application user.
* Passwords are stored as not encrypted `text` value, which is not possible in production. 

