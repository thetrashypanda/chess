
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Banneret extends Piece {

    
    public Banneret(boolean isWhite, String img_file) {
        super(isWhite, img_file);
    }
    
    @Override
    public String toString(){
      return "A " + super.toString() + " Banneret";
    }

    

    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.

    //PIECE RULES AND DIRECTIONS
    //It can move FORWARD in a STRAIGHT LINE like a ROOK
    //It can move BACKWARDS in TWO DIAGONALS like a BISHOP
    //Obviously, it is 'flipped' for the black version of the piece




    public ArrayList<Square> getControlledSquares(Square [][] board, Square start) {
      ArrayList<Square> legalMoves = new ArrayList<Square>();
      int x = start.getCol();
      int y = start.getRow();
      
      //Can move directly forward like a rook or backwards in both diagonals like a bishop
      int tempXright = x;
      int tempXleft = x;
      int tempYup = y;
      int tempYdown = y;
      if((start.getOccupyingPiece()).getColor() == true){
        boolean tempCheck = true;

        //start
        while(tempCheck){
          //y variables are inverse due to board having 0,0 at the top
          
          tempYup -= 1;
          if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
            tempCheck = false;
          }else if((board[tempYup][x]).getOccupyingPiece() != null && board[tempYup][x].getOccupyingPiece().getColor() == true){
            tempCheck = false;
          }else{
          legalMoves.add(board[tempYup][x]);
          
          if(board[tempYup][x].isOccupied()){
            tempCheck = false;
          }
        }
        }
        //end
        //re-initialize variables
        tempXright = x;
        tempXleft = x;
        tempYup = y;
        tempYdown = y;
        

      tempCheck = true;
        //start
        while(tempCheck){

          tempYdown += 1;
          tempXleft -= 1;
          if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
            tempCheck = false;
          }else{
          legalMoves.add(board[tempYdown][tempXleft]);
          
          if(board[tempYdown][tempXleft].isOccupied()){
            tempCheck = false;
          }
        }
        }
        //end
        
        //re-initialize variables
        tempXright = x;
        tempXleft = x;
        tempYup = y;
        tempYdown = y;
        

      tempCheck = true;
        //start
        while(tempCheck){
          
          tempYdown += 1;
          tempXright += 1;
          if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
            tempCheck = false;
          }else{
          legalMoves.add(board[tempYdown][tempXright]);
          
          if(board[tempYdown][tempXright].isOccupied()){
            tempCheck = false;
          }
        }
        }
        //end
        System.out.println(legalMoves.toString());
        return legalMoves;

      }else if((start.getOccupyingPiece()).getColor() == false){
        boolean tempCheck = true;
        tempXright = x;
        tempXleft = x;
        tempYup = y;
        tempYdown = y;
        //start
        while(tempCheck){
          
          //y variables are inverse due to board having 0,0 at the top
          tempYdown += 1;
          if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
            tempCheck = false;
          }else{
          legalMoves.add(board[tempYdown][x]);
          
          if(board[tempYdown][x].isOccupied()){
            tempCheck = false;
          }
        }
        }
        //end
        //re-initialize variables
        tempXright = x;
        tempXleft = x;
        tempYup = y;
        tempYdown = y;
        

      tempCheck = true;
        //start
        while(tempCheck){
          
          tempYdown -= 1;
          tempXleft -= 1;
          if(tempXright > 7 || tempXleft < 0 || tempYdown < 0 || tempYup > 7){
            tempCheck = false;
          }else{
          legalMoves.add(board[tempYdown][tempXleft]);
          if(board[tempYdown][tempXleft].isOccupied()){
            tempCheck = false;
          }
        }
        }
        //end
        
        //re-initialize variables
        tempXright = x;
        tempXleft = x;
        tempYup = y;
        tempYdown = y;
        

      tempCheck = true;
        //start
        while(tempCheck){
       
          tempYdown -= 1;
          tempXright += 1;
          if(tempXright > 7 || tempXleft < 0 || tempYdown < 0 || tempYup > 7){
            tempCheck = false;
          }else{
          legalMoves.add(board[tempYdown][tempXright]);
          if(board[tempYdown][tempXright].isOccupied()){
            tempCheck = false;
          }
        }
        }
        //end


        System.out.println(legalMoves.toString());
        return legalMoves;
      }
      return legalMoves;




    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.








    //HAVE THE END AT 7 AND 0
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        int x = start.getCol();
        int y = start.getRow();
        
        //Can move directly forward like a rook or backwards in both diagonals like a bishop
        int tempXright = x;
        int tempXleft = x;
        int tempYup = y;
        int tempYdown = y;
        if((start.getOccupyingPiece()).getColor() == true){
          boolean tempCheck = true;

          //start
          while(tempCheck){
            //y variables are inverse due to board having 0,0 at the top
            
            tempYup -= 1;
            if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
              tempCheck = false;
            }else if((b.getSquareArray()[tempYup][x]).getOccupyingPiece() != null && b.getSquareArray()[tempYup][x].getOccupyingPiece().getColor() == true){
              tempCheck = false;
            }else{
            legalMoves.add(b.getSquareArray()[tempYup][x]);
            
            if(b.getSquareArray()[tempYup][x].isOccupied()){
              tempCheck = false;
            }
          }
          }
          //end
          //re-initialize variables
          tempXright = x;
          tempXleft = x;
          tempYup = y;
          tempYdown = y;
          

        tempCheck = true;
          //start
          while(tempCheck){

            tempYdown += 1;
            tempXleft -= 1;
            if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
              tempCheck = false;
            }else if((b.getSquareArray()[tempYdown][tempXleft]).getOccupyingPiece() != null && b.getSquareArray()[tempYdown][tempXleft].getOccupyingPiece().getColor() == true){
              tempCheck = false;
            }else{
            legalMoves.add(b.getSquareArray()[tempYdown][tempXleft]);
            
            if(b.getSquareArray()[tempYdown][tempXleft].isOccupied()){
              tempCheck = false;
            }
          }
          }
          //end
          
          //re-initialize variables
          tempXright = x;
          tempXleft = x;
          tempYup = y;
          tempYdown = y;
          

        tempCheck = true;
          //start
          while(tempCheck){
            
            tempYdown += 1;
            tempXright += 1;
            if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
              tempCheck = false;
            }else if((b.getSquareArray()[tempYdown][tempXright]).getOccupyingPiece() != null && b.getSquareArray()[tempYdown][tempXright].getOccupyingPiece().getColor() == true){
              tempCheck = false;
            }else{
            legalMoves.add(b.getSquareArray()[tempYdown][tempXright]);
            
            if(b.getSquareArray()[tempYdown][tempXright].isOccupied()){
              tempCheck = false;
            }
          }
          }
          //end
          System.out.println(legalMoves.toString());
          return legalMoves;

        }else if((start.getOccupyingPiece()).getColor() == false){
          boolean tempCheck = true;
          tempXright = x;
          tempXleft = x;
          tempYup = y;
          tempYdown = y;
          //start
          while(tempCheck){
            
            //y variables are inverse due to board having 0,0 at the top
            tempYdown += 1;
            if(tempXright > 7 || tempXleft < 0 || tempYdown > 7 || tempYup < 0){
              tempCheck = false;
            }else if(((b.getSquareArray()[tempYdown][x]).getOccupyingPiece() != null) && (((b.getSquareArray()[tempYdown][x]).getOccupyingPiece()).getColor() == false)){
              tempCheck = false;
            }else{
            legalMoves.add(b.getSquareArray()[tempYdown][x]);
            
            if(b.getSquareArray()[tempYdown][x].isOccupied()){
              tempCheck = false;
            }
          }
          }
          //end
          //re-initialize variables
          tempXright = x;
          tempXleft = x;
          tempYup = y;
          tempYdown = y;
          

        tempCheck = true;
          //start
          while(tempCheck){
            
            tempYdown -= 1;
            tempXleft -= 1;
            if(tempXright > 7 || tempXleft < 0 || tempYdown < 0 || tempYup > 7){
              tempCheck = false;
            }else if((b.getSquareArray()[tempYdown][tempXleft]).getOccupyingPiece() != null && b.getSquareArray()[tempYdown][tempXleft].getOccupyingPiece().getColor() == false){
              tempCheck = false;
            }else{
            legalMoves.add(b.getSquareArray()[tempYdown][tempXleft]);
            if(b.getSquareArray()[tempYdown][tempXleft].isOccupied()){
              tempCheck = false;
            }
          }
          }
          //end
          
          //re-initialize variables
          tempXright = x;
          tempXleft = x;
          tempYup = y;
          tempYdown = y;
          

        tempCheck = true;
          //start
          while(tempCheck){
         
            tempYdown -= 1;
            tempXright += 1;
            if(tempXright > 7 || tempXleft < 0 || tempYdown < 0 || tempYup > 7){
              tempCheck = false;
            }else if((b.getSquareArray()[tempYdown][tempXright]).getOccupyingPiece() != null && b.getSquareArray()[tempYdown][tempXright].getOccupyingPiece().getColor() == false){
              tempCheck = false;
            }else{
            legalMoves.add(b.getSquareArray()[tempYdown][tempXright]);
            if(b.getSquareArray()[tempYdown][tempXright].isOccupied()){
              tempCheck = false;
            }
          }
          }
          //end


          System.out.println(legalMoves.toString());
          return legalMoves;
        }
        return legalMoves;


    }
}