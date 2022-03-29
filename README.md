# uscdoordrink-backend
Java backend for USC Door Drink

@Author: Rahil Bharat Ram
@Author: Hanna Kishawi
@Author: Omar Qureshi

general desc, frameworks, libraries, maven, sql backend correct port url username, pass, and run sql file we have in backend

Features implemented:
* User login for customers vs shop
* Register for customers vs shops
* Display of user data (customer vs shops)
* Handle store owner and customer data differently 

Features in progress:
* Feature 1, 2, 3

How to run:
* Download and unzip USCDoorDrinkFrontend and USCDoorDrinkBackend
* Run uscdoordrink.sql script in MySQL workbench
* Change dbcontrol/ConnectionFactory.java lines 9-11 to match SQL connection
* Run backend as a maven build on Eclipse or Intellij
* Once the server is running, build the frontend on AndroidStudio
* You can register a new user with a unique email address or use a preset user (mentioned as inserts in the SQL file)
* You may sign in with a user to reach the user information page
* All user data is displayed but there is no transaction data yet

