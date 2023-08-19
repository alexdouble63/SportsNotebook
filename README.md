# SportsNotebook
This application is a server part for maintaining and controlling sports training.
The program allows you to manage athletes, create training plans divided into difficulty levels, and keep a training log.
Entity in Database:
-sportsman - stores data about sportsman;
-exercise - stores a description of the main movements;
-difficalty exercise - is a specific exercise depending on the difficulty. Allows you to set the transition conditions for the next exercise;
-performance - stores the results of the exercises performed by the sportsman.

To access the list of sportsmen, use the URL: http://localhost:8080/sportsmen
To access the list of exepriences, use the URL: http://localhost:8080/exercises

Stack: Java, Spring Core, Spring Boot, Spring Data JPA, Hibernate, PostgreSQL
