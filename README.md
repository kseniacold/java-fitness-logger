### Java desktop fitness logger application

Educational prototype for JavaFx desktop application,
using MVC architecture.

---

### Project structure

* /models - classes that model data and handle application logic
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

### Screen shots

* Main screen:

![Main screen][main_screen]

[main_screen]: https://github.com/kseniacold/java-fitness-logger/blob/master/docs/images/main_screen.png?raw=true "Main Application Screen"

* Food entry screen:

![Food entry screen][food_screen]

[food_screen]: https://github.com/kseniacold/java-fitness-logger/blob/master/docs/images/food_entry_screen600x400.png?raw=true "Food Entry Screen"

* Endurance screen:

![Endurance screen][endurance_screen]

[endurance_screen]: https://github.com/kseniacold/java-fitness-logger/blob/master/docs/images/endurance_screen_600x400.png?raw=true "Endurance Screen"

---

### Development limitations
###### There is a number of restrictions in development environment:

* Multiple users can be registered in the database, however once a user is registered in the database, user with *id#1* will be picked as the application user.
* User entry verification is weak in this release - e.g. all fields are required and empty entries might result is null pointer exception.
* Passwords are stored as not encrypted `text` value, which is not possible in production. 

Please note that is a prototypical release, not production ready.