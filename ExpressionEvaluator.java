import java.util.Scanner;
import java.text.DecimalFormat;
/**
* Calculates expression (3x^5 - 2x^3)^2 / Sqrt(abs(16x^7) + 1).
* Solving for x
*
* Project_03 - ExpressionEvalutor
* @author Genji Nakano - CPSC 1213 - AO1
* version February 01, 2019
*/

public class ExpressionEvaluator {
/**
* Calulates expresssion (3x^5 - 2x^3)^2 / Sqrt(abs(16x^7) + 1).
*
* Get user input to store as x to use in above expression
* Use type double to create Math methods sqrt(), abs() and pow()
* Displays result, digits to left and right, and formatted results
* on separate lines
*
*
* @param args Command line arguments (not used).
*/


   public static void main(String[] args) {
      double x;
      double result;
      double divisor;
      double quotient;
      String resultStr;
      int resultDecimal;
      int resultLength;
      String resultFirst;
      String resultSecond;
      int resultFirstLength;
      int resultSecondLength;
      String resultFormat;
   
   
      System.out.print("Enter a value for x: ");
      Scanner keyboard = new Scanner(System.in);
      // assign input created from Scanner object to double x
      x = keyboard.nextDouble();
      // The quotient is (3x^5 - 2x^3)^2
      quotient = Math.pow(((3 * (Math.pow(x, 5))) - (2 * (Math.pow(x, 3)))), 2);
      // test quotient2 = (Math.pow(2 * x, 3));  
      // The divisor is abs value abs(16x^7)
      divisor = (Math.sqrt(Math.abs(16 * (Math.pow(x, 7))))) + 1;
      // equation for result
      result = quotient / divisor;
      
      // convert result to string
      resultStr = Double.toString(result);
      // get index of the decimal(".")
      resultDecimal = resultStr.indexOf(".");
      // get string length
      resultLength = resultStr.length();
      // get first part of string
      resultFirst = resultStr.substring(0, resultDecimal);
      // get second part of string
      resultSecond = resultStr.substring(resultDecimal + 1, resultStr.length());
      // get length of first part of string
      resultFirstLength = resultFirst.length();
      resultSecondLength = resultSecond.length();
      // formatted result
      // create Decimal Format Object
      DecimalFormat fmt = new DecimalFormat("#,##0.0####");
      resultFormat = fmt.format(result);
      
      
      
      System.out.println("Result: " + resultStr);
      System.out.println("# digits to left of decimal point: " 
                         + resultFirstLength);
      System.out.println("# digits to right of decimal point: " 
                         + resultSecondLength);
      System.out.println("Formatted Result: " + resultFormat);
      
   
   
   }

}
