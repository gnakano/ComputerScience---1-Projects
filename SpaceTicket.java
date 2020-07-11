import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/**
* Space Ticket program that takes in user input and if valid.
* provides information regarding the flight including:
* Destination, Date, Time, Seat, Price, Category, Cost and 
* Also includes random prize
*
* 
*
* Project_03 - SpaceTicket
* @author Genji Nakano - CPSC 1213 - AO1
* version February 01, 2019
*/

public class SpaceTicket {

   static final double STUDENT_DISCOUNT = .25;
   static final double CHILD_DISCOUNT = .35;
/**
 * Print out to user to requests user input for ticket code.
 * User required to enter min 25 character string
 * Checks to see if ticket is valid (min 25 char) or not
 * Outputs message to user if invalid.
 * If valid, outputs ticket information based on
 * Substrings of ticket out to user including:
 * Space Ticket(Flight number and destination), Date, Time,
 * Seat, Price, Category, Cost and  
 * Prize Number(which is random)
 * Cost uses discounts for students(25%) and children(35%) off Price
 * 
 * 
 * 
 *
 *
 * @param args Command line arguments (not used).
 */
   public static void main(String[] args) {
   // variables
      String ticketUser;
      double  price;
      int ticketLength;
      char category;
      DecimalFormat df = new DecimalFormat("$###,###.00");
      DecimalFormat timeForm = new DecimalFormat("00:00");
      String price1;
      String timeHr;
      String timeMin;
      String dateYr;
      String dateMo;
      String dateDay;
      String dateFull;
      String seat;
      String ticketInfo;
      Random generator = new Random();
      int prize;
         
      System.out.print("Enter ticket code: ");
      Scanner keyboard = new Scanner(System.in);
      ticketUser = keyboard.nextLine().trim();
      ticketLength = ticketUser.length();
      System.out.println();
      
      // if statement to check length is equal to 25 characters
      if (ticketLength < 25) {
         System.out.println("*** Invalid ticket code ***\n" 
                             + "Ticket code must have at least "
                             + "25 characters.");
      } else {
         // ticket info
         ticketInfo = ticketUser.substring(24);
         System.out.println("Space Ticket: " + ticketInfo);
         
         // date
         dateDay = ticketUser.substring(13, 15);
         dateMo = ticketUser.substring(15, 17);
         dateYr = ticketUser.substring(17, 21);
         dateFull = dateDay + "/" + dateMo + "/" + dateYr + "   ";
         System.out.print("Date: " + dateFull);
      
         // time 
         timeHr = ticketUser.substring(9, 11);
         timeMin = ticketUser.substring(11, 13);
         System.out.print("Time: " + timeHr + ":" 
                           + timeMin + "   ");
      
         // seat
         seat = ticketUser.substring(21, 24);
         System.out.println("Seat: " + seat);
         
         // price 
         price1 = ticketUser.substring(0, 8);
         price = Double.parseDouble(price1) / 100;
       
         System.out.print("Price: " + df.format(price)
                           + "   ");
         // get category by using index from ticketUser
         category = ticketUser.charAt(8);
         System.out.print("Category: " + category + "   ");
         if (category == 's') {
            System.out.println("Cost: " 
                    + df.format(price - (price * STUDENT_DISCOUNT)));
         } else if (category == 'c') {
            System.out.println("Cost: "
                    + df.format(price - (price * CHILD_DISCOUNT)));
         } else {
            System.out.println("Cost: " + df.format(price));
         }      
         
         // prize 
         prize = generator.nextInt(1000000);
         System.out.print("Prize Number: " + prize);
      
      
      }
   
   
   
   }
   
   

}