import java.text.DecimalFormat;


/** 
 * Dodecahedron - creates a Dodecahedron.
 * Constructor takes 3 arguments(label, color, edge)
 * Calculates Surface Area, Volume, and Surface Area / Volume
 *
 * Project 6
 * @author Genji Nakano - CPSC 1213 - AO1
 * @version February 24, 2019
 */
public class Dodecahedron {
// fields
   private String label = "";
   private String color = "";
// (length of the edge, which must be greater than zero)
   private double edge = 0;

   
 /** 
  * Constructor: sets the inital Dodecahedron.
  * takes in and sets label, color, & edge. 
  *
  *@param labelIn = label
  *@param colorIn = color
  *@param edgeIn = edge
  */
   public Dodecahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }
// methods
// get each of the above fields
// calculate the surface area, volume, and surface to volume ratio
// toString

/** 
* getLabel: accessor to get Dodecahedron label.
* 
* @return label = Dodecahedron label 
 */
   public String getLabel() {
      return label;
   }

  /** 
* setLabel: sets Dodecahedron label.
* only sets lablel and returns true if label is not null
* 
* @param labelIn = sets Dodecahedron label
* @return isSet = true/false
 */
   public boolean setLabel(String labelIn) {
      boolean isSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         isSet = true;
      } 
      return isSet;
   }

/** 
* getColor: accessor to get Dodecahedron color.
* 
* @return color = Dodecahedron color 
 */
   public String getColor() {
      return color;
   }

/** 
* setColor: sets Dodecahedron color.
* only sets color & return true if not null
* 
* @param colorIn = sets Dodecahedron color
* @return isSet
 */
   public boolean setColor(String colorIn) {
      boolean isSet = false;
      if (colorIn != null) {
         color = colorIn.trim();
         isSet = true;
      } 
      return isSet;
   }
   
/** 
* getEdge: accessor to get Dodecahedron edge.
* 
* @return edge = edge Dodecahedron 
 */
   public double getEdge() {
      return edge;
   }

/** 
* setEdge: sets Dodecahedron edge.
* only sets edge & return true if edge > zero
* 
* @param edgeIn = sets Dodecahedron edge
* @return isSet = true / false
 */
   public boolean setEdge(double edgeIn) {
      boolean isSet = false;
      if (edgeIn > 0) {
         edge = edgeIn;
         isSet = true;
      } 
      return isSet;
   }
   
/** 
* surfaceArea: calculates Surface Area(A).
* A = 3 * sqrt((25 + 10)*(sqrt(5)) * a^2
* a = uses d.getEdge() to get edge length(a)
* 
* @param
* @return total = total of surfaceArea
 */
   public double surfaceArea() {
      double underRoot = 25 + (10 * Math.sqrt(5));
      double firstPart = 3 * (Math.sqrt(underRoot));
      double total = firstPart * (Math.pow(getEdge(), 2));
      return total;
   }

/** 
* volume: calculates Volume(V).
* V = ((15 + (7 * sqrt(5))) / 4) * a^3
* a = uses d.getEdge() to get edge length(a)
* 
* @param
* @return total = total of volume
 */
   public double volume() {
      double firstPart = ((15 + (7 * Math.sqrt(5))) / 4);
      double total = firstPart * Math.pow(getEdge(), 3);
      return total;
   }

/** 
* surfacetoVolumeRatio: calculates Surface/Volume(A/V).
* surfaceArea() / volume ()
* 
* @param
* @return surfaceArea = total of Surface/Volume
 */
   public double surfaceToVolumeRatio() {
      double surfaceArea = surfaceArea() / volume();
      return surfaceArea;
   }

/** 
* toString: string representation of Dodecahedron.
* outputs, label, colol, edge
* 
* @return output = String representation of Dodecahedron
 */
   public String toString() {
      String output = "Dodecahedron \"" + label;
      output += "\" is \"" + color;
      output += "\" with 30 edges of length " + edge + " units.\n";
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      output += "\tsurface area = " + fmt.format(surfaceArea()) 
                  + " square units\n";
      output += "\tvolume = " + fmt.format(volume()) 
                  + " cubic units\n";
      output += "\tsurface/volume ratio = " 
                  + fmt.format(surfaceToVolumeRatio());
      return output;
   }

}