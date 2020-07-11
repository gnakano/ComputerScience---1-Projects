import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/** 
 * DodecahedronList - creates a DodecahedronList.
 * Stores the name of the list and an ArrayList of
 * Dodecahedron objects
 * 
 *
 * Project 5
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version February 17, 2019
 */
public class DodecahedronList {
// fields
// instance variables
   private String listName = "";
   private ArrayList<Dodecahedron> dodecahedronArray
      = new ArrayList<Dodecahedron>();

/**
* Constructor: sets the DodecahedronList Object.
* takes in String with name of list and
* ArrayList<Dodechadron> for the Dodecahedron objects
*
*@param listNameIn - takes in list name
*@param dodecahedronArrayIn - takes in name of array of dodecahedron
*/
   public DodecahedronList(String listNameIn, 
      ArrayList<Dodecahedron> dodecahedronArrayIn) {
      // sets parameters to object variables
      listName = listNameIn;
      dodecahedronArray = dodecahedronArrayIn;
   }

// methods
/**
* getName - for users to get name.
*
*@return listName.
*/
   public String getName() {
   
      return listName;
   }

/**
* numberOfDodechadrons - counts the number of dodecahedrons.
* in array
*
*@return numDod - total of Dodecahedrons in array.
*/
   public int numberOfDodecahedrons() {
   // return will be set to 0
      int numDod = 0;
      // goes through array if size is bigger than 0 or not empty
      if (dodecahedronArray.size() > 0) {
         numDod = dodecahedronArray.size();
      }
   
      return numDod;
   
   }

/**
* totalSurfaceArea - returns totalSurfaceArea.
*
*@return totalSurfaceArea for all dodecahedrons
*/
   public double totalSurfaceArea() {
      double totalSurfaceArea = 0;
   // while loop to go through array
      int index = 0;
      while (index < dodecahedronArray.size()) {
      // if true add each totalSurfaceArea for each
      // dodecahedron to totalSurfaceArea
      // get element from array - element is a dodecaheron
         Dodecahedron d = dodecahedronArray.get(index);
         totalSurfaceArea += d.surfaceArea();
      // increase index
         index++;
      }
   
      return totalSurfaceArea; // placeholder
   }

/**
* totalVolume - returns totalVolume.
*
*@return totalVolume for all Dodecahedrons
*/
   public double totalVolume() {
      double totalVolume = 0;
      int index = 0;
      while (index < dodecahedronArray.size()) {
      // if true add volume to totalVolume
         Dodecahedron d = dodecahedronArray.get(index);
         totalVolume += d.volume();
         index++;
      }
   
      return totalVolume;
   }

/**
* averageSurfaceArea - avg of all dodecahedrons.
*
*@return averageSurfaceArea
*/
   public double averageSurfaceArea() {
      double averageSurfaceArea = 0;
      if (dodecahedronArray.size() > 0) {
         averageSurfaceArea = totalSurfaceArea() / numberOfDodecahedrons();
      }
   
      return averageSurfaceArea;
   }
   
   /**
   * averageVolume - avg volume of all dodecahedrons.
   *
   *
   *@return averageVolume
   */
   public double averageVolume() {
      double averageVolume = 0;
      if (dodecahedronArray.size() > 0) {
         averageVolume = totalVolume() / numberOfDodecahedrons();
      }
      return averageVolume;
   }
   
   /**
   * averageSurfaceToVolumeRatio - avg Surface to Volume Ratio.
   * for all dodecahedrons
   *
   *@return averageSurfaceToVolumeRatio
   */
   public double averageSurfaceToVolumeRatio() {
   // initiailize ratio variable
      int index = 0;
      double averageSurfaceToVolumeRatio = 0;
      double totalSurfaceVolumeRatio = 0;  
      while (index < dodecahedronArray.size()) {
         Dodecahedron d = dodecahedronArray.get(index);
         totalSurfaceVolumeRatio += d.surfaceToVolumeRatio();
         averageSurfaceToVolumeRatio 
            = totalSurfaceVolumeRatio / numberOfDodecahedrons();
         index++;
      }
            
      return averageSurfaceToVolumeRatio;
   }

/**
* toString - String rep of ArrayList.
*
*@return output - String rep of ArrayList
*/
   public String toString() {
      String output = listName + "\n";
      int index = 0;
      while (index < dodecahedronArray.size()) {
         Dodecahedron d = dodecahedronArray.get(index);
         output += "\n" + d.toString() + "\n";
         index++;
      }
      return output;
   }
   
   /**
   * summaryInfo - summary of total dodecahedronArray.
   * including number, total surface area, total volume
   * avg surface area, avg volume, avg surface/volume ratio
   *
   *@return output - Summary info of DodecahedronArray
   */
   public String summaryInfo() {
      String output = "----- Summary for " 
                        + listName + " -----";
      output += "\nNumber of Dodecahedrons: " + dodecahedronArray.size();
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      output += "\nTotal Surface Area: " + df.format(totalSurfaceArea());
      output += "\nTotal Volume: " + df.format(totalVolume());
      output += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
      output += "\nAverage Volume: " + df.format(averageVolume());
      output += "\nAverage Surface/Volume Ratio: " 
                  + df.format(averageSurfaceToVolumeRatio());
      
      return output;
   
   }
   
   /**
   * getList - gets List.
   *@return dodecahedronArray
   */
   public ArrayList<Dodecahedron> getList() {
   
      return dodecahedronArray;
   
   }
   
/**
   * readFile - reads file from inputted fileName.
   *
   *@param fileName - inputtted fileName from User
   *@return dodList - created 
   *@throws IOException - for the IOException file
   */

   public DodecahedronList readFile(String fileName) {
      Scanner fileScan = new Scanner(new File(fileName));
      listName = fileScan.nextLine();
      while (fileScan.hasNext()) {
      // go through each line after fileName and in groups of 3
      // assign each line to dodecahedron arguments
         String label = fileScan.nextLine();
         String color = fileScan.nextLine();
         // need to convert inputted String to Double
         Double edge = Double.parseDouble(fileScan.nextLine());
         // create a new Dodecahedron object with above arguments
         Dodecahedron d = new Dodecahedron(label, color, edge);
         // add the new Dodecahedron object to Dodecahedron created
         // ArrayList<Dodecahedron> called dodecahedronList
         dodecahedronArray.add(d);
         // need to stop and reiterate without breaking out of loop
         continue;
      }
   
   
      return this;
   }

/**
* findDodecahedron - checks to see if user input in in array.
*
*@param labelIn - label to find
*@return dod - dod object or null
*/

   public Dodecahedron findDodecahedron(String labelIn) {
   
      for (Dodecahedron d : dodecahedronArray) {
         int i = 0;
         if (labelIn.toLowerCase().equals(d.getLabel().toLowerCase())) {
            System.out.print(dodecahedronArray.get(i));
            System.out.println("");
            return dodecahedronArray.get(i);
         }
         i++;
      }
      
      
      return null;
   }


/**
   * addDodecahedron - addDodecahedron - add new dodecahedron to arrayList.
   *
   *@param labelIn - label
   *@param colorIn - color
   *@param edgeIn - edge
   *@throws IOException - for the IOEception
   */

   public void addDodecahedron(String labelIn, String colorIn, double edgeIn) {
      Dodecahedron dodAdd = new Dodecahedron(labelIn, colorIn, edgeIn);
      dodecahedronArray.add(dodAdd);
   }

   /**
   * deleteDodecahedron - deletes dodechedron from arrayList.
   *
   *@param labelDelete - lable to check to delete
   *@return dod - dodecahedron object or null
   *@throws IOException - for the IOEception
   */
   public Dodecahedron deleteDodecahedron(String labelDelete) {
      Dodecahedron delete = null;
      boolean match = false;
      
      for (Dodecahedron d : dodecahedronArray)  {
                    
         if (labelDelete.equals(d.getLabel().toLowerCase())) {
           
            System.out.println("\t\"" + d.getLabel() 
                                 + "\"" + " deleted");
            dodecahedronArray.remove(d);
            delete = d;
            match = true;
            break;
         } 
                    
      } 
      if (!match) {
         System.out.println("\t\"" + labelDelete + "\"" + " not found");
      
      }
      return null;
   }
   
   
   /**
   * editDodecahedron - edit the Dodecahedron.
   *
   *@param labelIn - label to check
   *@param colorIn - color to change
   *@param edgeIn - edge to change
   *@return editValue - true/false based on label
   *@throws IOException - for the IOEception
   */
   public boolean editDodecahedron(String labelIn, 
      String colorIn, double edgeIn) 
   {
                            
      boolean editValid = false;                            
      for (int i = 0; i < dodecahedronArray.size(); i++) {
         String labelCheck = dodecahedronArray.get(i).getLabel();
                        
         if (labelCheck.toLowerCase().equals(labelIn.toLowerCase())) {
         
            dodecahedronArray.get(i).setColor(colorIn);
            dodecahedronArray.get(i).setEdge(edgeIn);
            editValid = true;
            System.out.print("\t\"" + labelIn + "\"" + " succesfully edited\n");
            break;
         }
      }
      if (!editValid) {
         System.out.print("\t\"" + labelIn + "\"" + " not found\n");
      }  
      return editValid;                          
   }

}


