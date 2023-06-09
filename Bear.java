/**@Gilbert CS145 Bear
  *@version 1.0 (04/22/2023)
  *@see Bear class*/
import java.awt.*;


public class Bear extends Critter {
   private boolean polar;
   private boolean isSlash;
   
   /**Construct and initialize if the bear is a polar bear
   @param polar the type of the bear*/
   public Bear(boolean polar){
      this.polar = polar;
   }
   
   /**Construct and initialize the getMove function
   @param info gets the information where does the Bear moves*/
   /**returns the move of the Bear
   @return INFECT infects other animals in front of the Bear
   @return HOP moves forward when there is an empty square in front of the Bear
   @return LEFT turns left if there is a wall in front of the Bear*/
   public Action getMove(CritterInfo info) {
      if (isSlash == true) {
         isSlash = false;
      }
      else if (isSlash == false) {
         isSlash = true;
      }
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } 
      else if (info.getFront() == Neighbor.EMPTY ){
         return Action.HOP;
      }
      else {
         return Action.LEFT;
      }
   }
   
   /**returns the color of the Bear
   @return WHITE makes the polar Bear white
   @return BLACK makes the Bear black*/
   public Color getColor() {     
         if (polar) {
            return Color.WHITE;
         }
         else {
            return Color.BLACK;
         }
      }
   /**returns the symbol representing the Bear
   @return / as the first symbol that alternates between steps
   @return \ after the symbol / and anternate between steps*/   
   public String toString() { 
      if (this.isSlash) {
         return "/";
      }
      else {
         return "\\";
      }
   }
}
