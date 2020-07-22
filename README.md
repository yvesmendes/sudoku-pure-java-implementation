# Academic Purpose Sudoku (Pure Java Implementation)

The project was developed using Java 1.6 without external libs. The game has three different difficulties: EASY, NORMAL, and HARD. The score is calculated based on the elapsed time, the number of errors, and the current difficulty.

An example of Sudoku Board in Easy mode:

```
    (0) (1) (2) (3) (4) (5) (6) (7) (8) 
   |===.===.===|===.===.===|===.===.===|
(0)| 2 |   |   | 5 | 7 |   | 9 |   |   |
   |---.---.---|---.---.---|---.---.---|
(1)|   |   | 9 | 3 |   | 8 |   |   | 1 |
   |---.---.---|---.---.---|---.---.---|
(2)| 5 | 8 |   | 9 |   |   | 3 | 4 |   |
   |===.===.===|===.===.===|===.===.===|
(3)| 6 |   | 8 |   | 1 | 9 |   |   |   |
   |---.---.---|---.---.---|---.---.---|
(4)| 4 | 1 | 7 |   |   | 3 |   | 9 | 5 |
   |---.---.---|---.---.---|---.---.---|
(5)| 9 |   | 2 | 7 | 8 | 5 |   | 1 | 4 |
   |===.===.===|===.===.===|===.===.===|
(6)| 8 |   | 4 | 1 | 9 |   | 5 | 3 | 6 |
   |---.---.---|---.---.---|---.---.---|
(7)|   |   | 5 | 8 | 3 | 6 |   |   | 2 |
   |---.---.---|---.---.---|---.---.---|
(8)| 3 |   |   | 2 | 5 | 4 | 1 | 8 | 9 |
   |===.===.===|===.===.===|===.===.===|
```

This project demonstrates some of project patterns:

- Facade
- Template Method
- Command
- Strategy
- Factory Method

Only the Console Mode was developed.

## Pre-Requisities ##
- maven
- JDK 1.6

# RUN

```
1. mvn package
2. java -jar target/Sudoku.jar

