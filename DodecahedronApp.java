import java.util.Scanner;

/** 
 * DodecahedronApp - test driver for Dodecahedron.java.
 * Asks for user input
 * uses user input to create Dodecahedron oject
 *
 * Project 4
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version February 9, 2019
 */

public class DodecahedronApp {

/**
  * Asks user for input: label, color, edge.
  * checks to see if edge > 0
  * prints out the new Dodecahedron object
  *
  * @param args Command line arguments (not used).
  */
   public static void main(String[] args) {
   
   // variables
      String label;
      String color;
      double edge;
      Scanner keyboard = new Scanner(System.in);
   
      System.out.println("Enter label, color, and edge length "
                        + "for a dodecahedron.");
      System.out.print("\tlabel: ");
      label = keyboard.nextLine();
      System.out.print("\tcolor: ");
      color = keyboard.nextLine();
      System.out.print("\tedge: ");
      edge = Double.parseDouble(keyboard.nextLine());
      if (edge <= 0) {
         System.out.print("Error: edge must be greater than 0.");
         return;
      }
      Dodecahedron d = new Dodecahedron(label, color, edge);
      System.out.println("\n" + d.toString());
   
   }

}