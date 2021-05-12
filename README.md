# Comp249Assignments
All the assignments that Anthony completed while taking the course Object-Oriented Programming II in Winter 2019.

## Assignment 1
### Part I
Program a Book class that has the following attributes: a title (String), an author (String), an ISBN (long), and a price (double). The class should also contain the following methods: getters, setters, to string, equals, and find number of created books.

### Part II
Create a software that helps a bookstore owner in keeping track of the books at the store. The software should let the owner enter new books, change book information, display books by a specific author, and display books that cost at most a certain price.

## Assignment 2
### Part I
Create a group of classes according to these specifications:
- A PublicTransportation class has a ticket price (double) and number of stops (int).
- A CityBus is a PublicTransportation that additionally has a route number (long), a begin operation year (int), a line name (string), a driver's name (string).
- A Tram is a CityBus that additionally has a maximum speed (int).
- A Metro is a CityBus that additionally has a number of vehicles (int) and the name of the city that it runs in (string).
- A Ferry is a PublicTransportation that additionally has a build year (int) and a ship name (string).
- An AirCraft is a PublicTransportation that additionally has a class type (enum that can be Helicopter, Airline, Glider, or Balloon), and a maintenance type (enum that can be Weekly, Monthly, or Yearly).

### Part II
Modify Part I so that it has the most restrictive access rights to their data members. Also, create a new static method called copyCityBus that will perform a deep copy of an array of PublicTransportation objects.

## Assignment 3
Write a bibliography creator that takes bibliography files in JSON format, asks the user for the last name of the author they are referencing, and creates 3 new files that are in the following formats: IEEE, ACM, and NJ. If the files already exist, append "-BU" to the end of them and continue with the file creation.

## Assignment 4
### Part I
Program a sub-dictionary creator using array lists that will accept any text file as input and creates a sub-dictionary that includes all the words found in that input file based on some rules.

### Part II
Write a program using linked lists that manipulates a set of cell phone records and performs some operations on these records.