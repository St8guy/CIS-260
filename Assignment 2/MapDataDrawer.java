import java.util.*;
import java.io.*;
import java.awt.*;

public class Assignment2_Leeseberg
{

  private int[][] grid;

  public Assignment2_Leeseberg(String filename, int rows, int cols){
      // initialize grid 
      grid = new int[rows][cols];
      
      //read the data from the file into the grid
      File dataFile = new File(filename);
      try {
         Scanner dataInput = new Scanner(dataFile);
         for (int i=0; i<rows; i++) {
            for (int j=0; j<cols;j++) {
               grid[i][j] = dataInput.nextInt();
            
            }
         }
         
      } catch (Exception e) { e.printStackTrace();}

  }
  
  /**
   * @return the min value in the entire grid
   */
  public int findMinValue() {
      int min = Integer.MAX_VALUE;
   for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[i].length; j++) {
         if (grid[i][j] < min) {
            min = grid[i][j];
         }
      }
   }
   return min;  
 
  }
  /**
   * @return the max value in the entire grid
   */
  public int findMaxValue(){
      int max = Integer.MIN_VALUE;
   for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[i].length; j++) {
         if (grid[i][j] > max) {
            max = grid[i][j];
         }
      }
   }
   return max;  


  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinInCol(int col){
     int min = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int i=0; i<grid.length; i++) {
         if (grid[i][col] < min) {
            min = grid[i][col];
            minIndex = i;
         }
      }
      return minIndex;

  }
  
  /**
   * Draws the grid using the given Graphics object.
   * Colors should be grayscale values 0-255, scaled based on min/max values in grid
   */
  public void drawMap(Graphics g){
      int min = findMinValue();
      int max = findMaxValue();
      
      for (int i=0; i<480; i++) {
         for (int j=0; j<480; j++) {
            int c = (255 * (grid[i][j] - min)) / (max - min);
            g.setColor(new Color(c, c, c));
            g.fillRect(j, i, 1, 1);
         }
      }
   }
public void drawLowestElevPath(Graphics g, int startRow)
      {
         int r = startRow;
         int c = 0;
         int total = grid[r][c];
         g.fillRect(c, r, 1, 1);//This will color the initial position red
         while(c <= 479) //This will ensure that the loop does not go out of bounds of the 2D-Array
         {
            while(r > 0 && r < 479 && c < 479)
               {
               //Three following lines determine elevation difference between array locations
               int up = Math.abs(grid[r][c] - grid[r-1][c+1]);
               int right = Math.abs(grid[r][c] - grid[r][c+1]);
               int down = Math.abs(grid[r][c] - grid[r+1][c+1]);
               if(up < right && up < down)//The three if statements will determine which course of action to take depending on which has the lowest value
                  {
                  r = (r-1);
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1);//                  
                  }
               if(right < up && right < down)
                  {
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1); 
                  }
               if(down < up && down < right)
                  {
                  r = (r+1);
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1); 
                  }
               if(up == down || up == right)//The last two if statements are in case up, down, or right share the same value
                  {
                  r = (r-1);
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1);
                  }
               if(down == right)
                  {
                  r = (r+1);
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1);
                  }
               }
            while(r == 0 && c < 479)//If the path is taken to row = 0 of the array the above code would result in a out of bounds error
               {//This loop removes the posibility of trying to go above row = 0
               int right1 = Math.abs(grid[r][c] - grid[r][c+1]);
               int down1 = Math.abs(grid[r][c] - grid[r+1][c+1]);
               if(right1 <= down1)
                  {
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1); 
                  }
               if(down1 < right1)
                  {
                  r = (r+1);
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1); 
                  }
               }
            while(r == 479 && c < 479)//If the path is taken to the bottom row this altered while loop will acount for that
               {//This while loop removes the ability to move below row = 479
               int right2 = Math.abs(grid[r][c] - grid[r][c+1]);
               int up2 = Math.abs(grid[r][c] - grid[r-1][c+1]);
               if(right2 <= up2)
                  {
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1); 
                  }
               if(up2 < right2)
                  {
                  r = (r-1);
                  c = (c+1);
                  total = (total + grid[r][c]);
                  g.fillRect(c, r, 1, 1); 
                  }
               }
         }
      }
}