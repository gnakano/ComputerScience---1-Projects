// import Scanner class
import java.util.Scanner;

/**
 * Calculator application that takes in user input for x, y, z.
 * Formula is ((2x - 7.4)(4y +9.3)(6z - 11.2)) / xyz.
 * all numbers must be double.
 *
 * Project 2 - Formula Calculator
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version January 26, 2019
 */
 
public class FormulaCalculator {
/** 
  * First asks user for input of variables x, y, z.
  * Displays formula ((2x - 7.4)(4y +9.3)(6z - 11.2)) / xyz
  * checks to see if product equals zero and if so returns zero.
  * if not then calculates formula and displays result
  * 
  * 
  * @param args Command line arguments (not used).
  */
  
   public static void main(String[] args) {
   // declaring double var x, y, z for equation
      double x;
      double y;
      double z;
      double result = 0.0;
   // Create Scanner Object to take user input
      Scanner keyboard = new Scanner(System.in);
   // first line out to user
      System.out.println("result = (2x - 7.4) (4y + 9.3)" 
                         + "(6z - 11.2) / xyz");
   // output for user to enter x
      System.out.print("\tEnter x: ");
   // ask for user input (double)
      x = keyboard.nextDouble();   
      System.out.print("\tEnter y: ");
      y = keyboard.nextDouble();
      System.out.print("\tEnter z: ");
      z = keyboard.nextDouble();
      // if statement to check if zero
      if (x != 0 && y != 0 && z != 0) {
         result = ((2 * x - 7.4) * (4 * y + 9.3) 
                  * (6 * z - 11.2)) / (x * y * z);
      }
      System.out.println("result = " + result);   
   
   }

}