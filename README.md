#  Calculator

## Features
- User can enter the numbers and operators in the command line.
- Supported Operations : Addition, Subtraction, Multiplication and Division.
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
- Following are the allowed operators for the calculator
	1. 	Addition  :  +
	2. 	Substraction :  -
	3. 	Multiplication :  *
	4. 	Division :  /
	
-  Following will be the order of precedence of the operators


Operator  | Description
------------- | -------------
()  |Brackets
*,/  | Multiplication , Division
+,- | Addition , Substraction

-  Precedence for Operators with equal precedence will be evaluated based on the order in which they appear in the expression from left to right


## Design approach
 - Expressions to be validated before evaluation.
 - Expression will be given in Infix notation format which is easier to be read by humans. But it is difficult to be parsed by machine. 
 - To resolve the above mentioned issue with Infix notation format, expression has to be converted into post fix notation format where it can be parsed easily by machines.
 - Expression can be converted into post fix notation format using Stacks data structure to place the operators based on their precedence.
 - Expression in post fix format can then be evaluated by using stacks to place the values for applying the sequence of arithmetic operations.
 
 
 Following diagram illustrates the main flow of the calculator application
 
 ![](https://github.com/vimal-kanagaraj/calculator/raw/master/screenshots/sequence-diagram.jpg)  
 <br />
## Unit Tests
Click [here](https://github.com/vimal-kanagaraj/calculator/blob/master/UnitTestResults.md "Click to view unit tests results and code coverage") to view unit tests results and code coverage
