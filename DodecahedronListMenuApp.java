import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
 /** 
 * DodecahedronListMenuApp - Test driver for app.
 * DodecahedronListMenuApp objects
 * 
 *
 * Project 6
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version February 24, 2019
 */

public class DodecahedronListMenuApp {

/**
* reads a file in from user input and then from the inputted file,.
* reads file list name, label, color and edge
* creates dodechaedron object from file and stores in local array
* then stores file name and local array into DodecahedronList oject
* prints out each dodecahedron object and summaryInfo of DodecaheronList
*
*@param args command line arguments not used
*@throws IOException to throw if file is not there
*/

   public static void main(String[] args) throws IOException {
      String fileName = "";
      ArrayList<Dodecahedron> dodArr = new ArrayList<Dodecahedron>();
      DodecahedronList dodList = new DodecahedronList(fileName, dodArr);
      Scanner userInput = new Scanner(System.in);
      char choice;
   
      System.out.print("Dodecahedron List System Menu" 
         + "\nR - Read File and Create Dodecahedron List"
         + "\nP - Print Dodecahedron List"
         + "\nS - Print Summary"
         + "\nA - Add Dodecahedron"
         + "\nD - Delete Dodecahedron"
         + "\nF - Find Dodecahedron"
         + "\nE - Edit Dodecahedron"
         + "\nQ - Quit");
   
      do {
         System.out.print("\nEnter Code [R, P, S, A, D, F, E, or Q]: ");
      
         choice = userInput.nextLine().toUpperCase().charAt(0);
         
      
      
      // Switch statements
         switch (choice) {
         // case options
            case 'R':
               
               System.out.print("File name: ");
               fileName = userInput.nextLine();
               System.out.println("\tThe file name entered is: " + fileName);
               //Scanner fileScan = new Scanner(new File(fileName));
               // System.out.print("The file is: " + fileName);
               dodList = dodList.readFile(fileName);
               System.out.println("\tFile read in and" 
                                 + " Dodecahedron List created");
               break;
               
            case 'P':
               
               System.out.print(dodList);
               break;
               
            case 'S':
               
               System.out.println(dodList.summaryInfo());
               
               break;
               
            case 'A':
               
               System.out.print("\tLabel: ");
               String label = userInput.nextLine();
               System.out.print("\tColor: ");
               String color = userInput.nextLine();
               System.out.print("\tEdge: ");
               double edge = Double.parseDouble(userInput.nextLine());
                  // create new Dodecahedron object
               dodList.addDodecahedron(label, color, edge);
                  // add newly created Dodecahedron to Dod arrayList
               System.out.println("\t*** Dodecahedron added ***");
                  
               
               break;
               
            case 'D':
               
               System.out.print("\tLabel: ");
               String labelDelete = userInput.nextLine().toLowerCase();
               dodList.deleteDodecahedron(labelDelete);
               
               break;
               
            case 'F':
               
              
               System.out.print("\tLabel: ");
               String findLabel = userInput.nextLine().toLowerCase();
               dodList.findDodecahedron(findLabel);
             
               break;
               
            case 'E':
               
               System.out.print("\tLabel: ");
               String labelEdit = userInput.nextLine();
               System.out.print("\tColor: ");
               String colorEdit = userInput.nextLine();
               System.out.print("\tEdge: ");
               double edgeEdit = Double.parseDouble(userInput.nextLine());
               dodList.editDodecahedron(labelEdit, colorEdit, edgeEdit);
               
               break;
               
            case 'Q':
               
               
               break;
         
            default:
               System.out.println("*** invalid code ***");
         }
      
      } while (choice != 'Q');
   
   }

}