#  Calculator

## Features
- User will be to enter the numbers and operators in the command line.
- Operations only addition, subtraction, multiplication and division are supported.
- Sample Inputs <br />
  `5+2` <br />
  `5+2*(3/2)` <br />
   `5+(2/3)*(3*(2/3))` <br />
- Output will be displayed to the user in the same command line interface where user entered the input.
- Input validation is done when user enters anything that is not appropriate for the calculator.

 To view requirements click [here](https://github.com/vimal-kanagaraj/calculator/blob/master/Requirements.md "Click to view requirements")

## Prerequisites to run the program
- Maven 
- JDK 1.8+

## Steps to run the program
- Run the following command to build the application<br />
 `mvn clean package` <br />
![](https://github.com/vimal-kanagaraj/calculator/raw/master/screenshots/mvn-package.jpg)
<br />
- Run the following command to run the application <br />
 `mvn exec:java --quiet` <br />

 ![](https://github.com/vimal-kanagaraj/calculator/raw/master/screenshots/mvn-run.jpg) 
 <br />
 
## Assumptions
- Only integers can be entered as input. Output can be in decimal format.
- Negative numbers will not be passed as input. 
- Both input and output will be less than Double data type's max value i.e. 1.7*10^308

## Sequence Diagram
 ![](https://github.com/vimal-kanagaraj/calculator/raw/master/screenshots/sequence-diagram.jpg)  
 <br />
## Unit Tests
Click [here](https://github.com/vimal-kanagaraj/calculator/blob/master/UnitTestResults.md "Click to view unit tests results and code coverage") to view unit tests results and code coverage