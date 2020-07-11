// import Scanner class
import java.util.Scanner;

/**
 * ATM application that asks user for amount to dispense (Max = 5000).
 * Displays whats going to be dispensed by values of $20, $10, $5 and $1.
 *
 * Project 2 - ATM
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version January 26, 2019
 */
 
public class ATM {
// constant must be placed in the class
   static final int MAX_LIMIT = 500;
   
/** 
  * First asks user for amount (MAX = 500).
  * Takes users input and calculates dispensed amount in 20, 10, 5, 1.
  * Displays the bills being dispensed (tabbed with dollar amount).
  * Final line displays total amount displayed in arithmatic format
  * 
  * @param args Command line arguments (not used).
  */
  
   public static void main(String[] args) {
      // create a Scanner object take in keyboard input
      Scanner keyboard = new Scanner(System.in);
      // variable to hold amount requested
      int amtRequested;
      // variables to hold individual bills
      int twentyBill;
      int tenBill;
      int fiveBill;
      int oneBill;
      int afterTwentyLeft;
      int afterTenLeft;
        
      // displays value in 20, 10, 5, 1
      // needs to ask user for to enter a value in whole numbers
      System.out.print("Enter the amount: ");
      // takes user input and assigns input to a variable
      amtRequested = keyboard.nextInt();
      
      // if statement to see if amtRequested exceeds 500
      if (amtRequested > MAX_LIMIT) {
         System.out.printf("Limit of $%d exceeded!%n", 
                           MAX_LIMIT);
      } else {
         System.out.println("Bills by denomination:");
         // calculate how many 20's
         twentyBill = amtRequested / 20;
         afterTwentyLeft = amtRequested % 20;
         afterTenLeft = afterTwentyLeft % 10;
         
         // printing out the amount of bills
         System.out.println("\t$20: " 
                            + twentyBill);
         // using the amt requested and 
         // remainder to get how many 10's                   
         tenBill = afterTwentyLeft / 10;
         System.out.println("\t$10: "
                            + tenBill);
         // using the amt for tenBill to get how many 5's
         fiveBill = afterTenLeft / 5;
         System.out.println("\t$5: " 
                            + fiveBill);
                            
         oneBill =  afterTenLeft % 5;
         System.out.println("\t$1: "
                            + oneBill);  
                            
         // final statement to user                   
         System.out.printf("$%d = (%d * $20) + (%d * $10)" 
                           + " + (%d * $5) + (%d * $1)%n",
                           amtRequested,
                           twentyBill,
                           tenBill,
                           fiveBill,
                           oneBill);                
      }
              
   }
}