
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
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece captures into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> moves = new ArrayList<>();
      int row = start.getRow();
      int col = start.getCol();
      
      for (int i = -1; i <= 1; i++){
        for (int j = -1; j <= 1; j++){
          if ((row + i <= 7 && col + j <= 7)){
            //b.getSquareArray()[row][col] add to array list of legal moves
            moves.add(board [row + i][col + j]);
          }
        }
      }
     return moves;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //this is the move set for the king who moves exactly one square in any direction.

    //Precondition: Board exists with placed squares.
    //Postcondition: Adds legal moves to moves, returns moves.
    public ArrayList<Square> getLegalMoves(Board b, Square start){

      ArrayList<Square> moves = new ArrayList<>();
      int row = start.getRow();
      int col = start.getCol();

      //b.getSquareArray()[row][col].getOccupyingPiece().getColor()
      //"if square has an opposite color piece then legal capture or empty square around king then legal move, else cant move"
      
      for (int i = -1; i <= 1; i++){
        for (int j = -1; j <= 1; j++){
          if ((row + i <= 7 && col + j <= 7) && (!b.getSquareArray()[row + i][col + j].isOccupied() || b.getSquareArray()[row + i][col + j].getOccupyingPiece().getColor() != color)){
            //b.getSquareArray()[row][col] add to array list of legal moves
            moves.add(b.getSquareArray()[row + i][col + j]);
          }
        }
      }

    	return moves;

    }
}