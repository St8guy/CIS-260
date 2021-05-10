import java.awt.*;

public class Driver
{
    
    public static void main(String[] args){
        
        //construct DrawingPanel, and get its Graphics context
        DrawingPanel panel = new DrawingPanel(480, 480);
        Graphics g = panel.getGraphics();
        
        //Test Step 1 - construct mountain map data
        Assignment2_Leeseberg map = new Assignment2_Leeseberg("Colorado_480x480.dat", 480, 480);
        
         //Test Step 2 - min, max, minRow in col
         int min = map.findMinValue();
         System.out.println("Min value in map: "+min);
         
         int max = map.findMaxValue();
         System.out.println("Max value in map: "+max);
         
         int minRow = map.indexOfMinInCol(0);
         System.out.println("Row with lowest val in col 0: "+minRow);
         
         //Test Step 3 - draw the map
         map.drawMap(g);
         g.setColor(new Color(255, 0, 0));
         map.drawLowestElevPath(g, minRow);
        
    }


}