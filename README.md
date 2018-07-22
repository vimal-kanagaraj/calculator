#  Calculator

## Features
- User will be to enter the numbers and operators in the command line.
- Operations only addition, subtraction, multiplication and division are supported.
- Sample Inputs
  `5+2`
  `5+2*(3/2)`
   `5+(2/3)*(3*(2/3))`
- Output will be displayed to the user in the same command line interface where user entered the input.
- Input validation is done when user enters anything that is not appropriate for the calculator.

## Prerequisites to run the program
- Maven 
- JDK 1.8+

## Steps to run the program
- Run the following command to build the application
 `mvn package`
- Run the following command to run the application
 `java -cp target/calculator-1.0-snapshort.jar com.kvsamples.calculator.cli.CalculatorMain`

## Assumptions
- Only integers can be entered as input. Output can be in decimal format.
- Negative numbers will not be passed as input. 
- Both input and output will be less than Double data type's max value i.e. 1.7*10^308