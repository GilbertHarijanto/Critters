/**@Gilbert CS145 Lion
  *@version 1.0 (04/22/2023)
  *@see Lion class*/
import java.awt.*;
import java.util.Random;

public class Lion extends Critter 
   {
   private int count;
   private Color lionColor;
   
   public Lion() {
      count = 0;
      Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
      Random rand = new Random();
      int randomColors = rand.nextInt(colors.length);
      lionColor = colors[randomColors];
   }
   
   /**Construct and initialize the getMove function
   @param info gets the information where does the Lion moves*/
   /**returns the move of the Lion
   @return INFECT infects other animals in front of the Lion
   @return LEFT turns left if there is a wall in front or to the right of the Lion
   @return HOP whenever there is an empty space in front of the Lion*/
   public Action getMove(CritterInfo info) {
      count++;
      if (count == 3) {
         Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
         Random rand = new Random();
         int randomColors = rand.nextInt(colors.length);
         lionColor = colors[randomColors];
         count=0;
      }
      
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      }    
      else if (info.getFront() == Neighbor.WALL ){
         return Action.LEFT;
      }
      else if (info.getRight() == Neighbor.WALL ){
         return Action.LEFT;
      }
      else if (info.getFront() == Neighbor.SAME ){
         return Action.RIGHT;
      }
      else {
         return Action.HOP;
      }     
   }
   
   /**returns the color of the Lion
   @return lionColor returns the color of the lion that have been allternating every 3 steps from the random function above*/
   public Color getColor() {
      return lionColor;
    }

   /**returns the letter representing the Lion
   @return L as the letter that represents the Lion*/
    public String toString() {
        return "L";
    }
}