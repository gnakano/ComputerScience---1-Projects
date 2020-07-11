import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


/** 
 * DodecahedronListApp - test driver for Dodecahedron and.
 * DodecahedronList objects
 * 
 *
 * Project 5
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version February 17, 2019
 */


public class DodecahedronListApp {

/**
* reads a file in from user input and then from the inputted file,.
* reads file list name, label, color and edge
* creates dodechaedron object from file and stores in local array
* then stores file name and local array into DodecahedronList oject
* prints out each dodecahedron object and summaryInfo of DodecaheronList
*
*@param args command line arguments not used
*@throws FileNotFoundException to throw if file is not there
*/

   public static void main(String[] args) throws FileNotFoundException {
   // variables 
      String fileName, line, listName, label, color;
      double edge; 
      Scanner fileScan;
      DodecahedronList totalList;
      ArrayList<Dodecahedron> dodecahedronList = new ArrayList<Dodecahedron>();
      
   
      System.out.print("Enter file name: ");
      Scanner scan = new Scanner(System.in);
      // save user input of file name
      fileName = scan.nextLine();
      // get file from user input 
      fileScan = new Scanner(new File(fileName));
      // grab listName and and save it to variable
      // before looping through the data
      listName = fileScan.nextLine();
      
      while (fileScan.hasNext()) {
      // go through each line after fileName and in groups of 3
      // assign each line to dodecahedron arguments
         label = fileScan.nextLine();
         color = fileScan.nextLine();
         // need to convert inputted String to Double
         edge = Double.parseDouble(fileScan.nextLine());
         // create a new Dodecahedron object with above arguments
         Dodecahedron d = new Dodecahedron(label, color, edge);
         // add the new Dodecahedron object to Dodecahedron created
         // ArrayList<Dodecahedron> called dodecahedronList
         dodecahedronList.add(d);
         // need to stop and reiterate without breaking out of loop
         continue;
      }
      totalList = new DodecahedronList(listName, dodecahedronList);
      System.out.println("\n" + totalList);
      System.out.println("");
      System.out.println(totalList.summaryInfo());
   }


}