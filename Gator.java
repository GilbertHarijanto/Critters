/**@Gilbert CS145 Gator
  *@version 1.0 (04/29/2023)
  *@see Gator class*/
import java.awt.*;
import java.util.Random;

public class Gator extends Critter {
   private int count;
   private String gatorName;
   private Color gatorColor;
   
   public Gator(){
      count = 0;
      gatorName=":D";
      count = 0;
      Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
      Random rand = new Random();
      int randomColors = rand.nextInt(colors.length);
      gatorColor = colors[randomColors];

   }
   
   /**Construct and initialize the getMove function
   @param info gets the information where does the Gator moves*/
   /**returns the move of the Gator
   @return INFECT infects other animals in front of the Gator
   @return RIGHT turns right if there is a gator behind and there is no entity in front
   @return LEFT turns left if the left of the gator is west and there is a gator in front
   @return LEFT turns left if there is a wall in front or there is an entity on the right
   @return RIGHT turns right if the right of the gator is facing south and there is a gator behind
   @return HOP whenever there is an empty space in front of the Gator*/   

   public Action getMove(CritterInfo info) {
      count++;
      if (count == 1) {
         Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.WHITE, Color.BLACK};
         Random rand = new Random();
         int randomColors = rand.nextInt(colors.length);
         gatorColor = colors[randomColors];
         count=0;

         if (gatorName.equals(":D")){
            gatorName = ":3";
            count = 0;
         }
         else if (gatorName.equals(":3")){
            gatorName = ":O";
            count = 0;   
         }
         else if (gatorName.equals(":O")){
            gatorName = ":C";
            count = 0;    
         }
         else if (gatorName.equals(":C")){
            gatorName = ">:(";
            count = 0;    
         }
         else if (gatorName.equals(">:(")){
            gatorName = ":^)";
            count = 0;    
         }

         else if (gatorName.equals(":^)")){
            gatorName = ":D";
            count = 0;
         }
      }
                   
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } 
      else if (info.getBack() == Neighbor.SAME && info.getFront() == Neighbor.EMPTY ){
         return Action.RIGHT;
      }
      else if (info.getLeftDirection()== Direction.WEST && info.getFront() == Neighbor.SAME){
         return Action.LEFT;
      }
      else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.OTHER){
         return Action.LEFT;
      }
      else if (info.getRightDirection()== Direction.SOUTH && info.getBack() == Neighbor.SAME ){
         return Action.RIGHT;
      }
      else {
         return Action.HOP;
      }
   }
   
   /**returns the color of the Gator
   @return gatorColor returns the color of the lion that have been allternating every step from the random function above*/
   public Color getColor() {
      return gatorColor;
   }

   /**returns the String representing the Gator
   @return gatorName alternates different emoji step to represent the gator*/
   public String toString() {
      return gatorName;
   }
}