/**@Gilbert CS145 Giant
  *@version 1.0 (04/22/2023)
  *@see Giant class*/
import java.awt.*;

public class Giant extends Critter {
   private int count;
   private String giantName;
   
   public Giant(){
      count = 0;
      giantName="fee";
   }
   
   /**Construct and initialize the getMove function
   @param info gets the information where does the Giant moves*/
   /**returns the move of the Giant
   @return INFECT infects other animals in front of the Giant
   @return HOP moves forward when there is an empty square in front of the Giant
   @return RIGHT turns right if there is a wall in front of the Bear**/
   public Action getMove(CritterInfo info) {
      count++;
      if (count == 6) {
         if (giantName.equals("fee")){
            giantName = "fie";
            count = 0;
         }
         else if (giantName.equals("fie")){
            giantName = "foe";
            count = 0;   
         }
         else if (giantName.equals("foe")){
            giantName = "fum";
            count = 0;    
         }
         else if (giantName.equals("fum")){
            giantName = "fee";
            count = 0;
         }
      }
                   
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } 
      else if (info.getFront() == Neighbor.EMPTY ){
         return Action.HOP;
      }
      else {
         return Action.RIGHT;
      }
   }
   
   /**returns the color of the Giant
   @return GRAY makes the giant's color gray*/
   public Color getColor() {
      return Color.GRAY;
   }

   /**returns the String representing the Giant
   @return giantName alternates different String every 6 steps to represent the giant*/
   public String toString() {
      return giantName;
   }
}