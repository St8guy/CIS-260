import java.util.Scanner;
import java.io.File;

public class Assignment3
{
   public static void main(String[] args)
   {
   //Create a new Scanner object
   Scanner input = new Scanner(System.in);
   
   //Ask the user to write the one review for the movie
   System.out.println("Please insert a one-line review of the movie.");
   String user = input.nextLine();
   
   //Create a array of strings called words
   //the .split will seperate the user string at the locations indicated inside the parenthesis
   // the "\\s+" will have the program split the string at any location where the white-space is one (or more) spaces long
   String[] words = user.split("\\s+");
   
   int location = 0;
   double total = 0;
   double average = 0;
   
   //create a for loop that will run to the length of the words array, so that the array can be any length and the program will run
   for(int counter = 0; counter < words.length; counter++)
      {
      //this will return the total value attached to the current index of words
      double t = wordScore(words[location]);
      
      //this will return the total appearances of the current index of word
      double c = wordAppearances(words[location]);      
      
      if(c != 0) //This will prevent the program from returning a non-existant value as you cannot devide real numbers by zero
      {
         //calculates the average score for each word in the review
         average = (t/c);
      }else if(c == 0)
       {
         average = 0;
       }
      
      
      //keeps tabs on the total average scores of the review
      total = total + average;
      
      System.out.println("The word '" + words[location] + "' appears in " + c + " reviews.");
      System.out.println("The average score associated with the word '" + words[location] + "' is " + average + ".");
      System.out.println();//empty line for readability of the output
      
      //will increment the index of array "words" used
      location++;      
      }
   
   double reviewscore = (total/words.length); //calculates the average score of the review
   System.out.println("The average score of this review based upon the word averages should be " + reviewscore + ".");
   }
   
   public static double wordScore(String word)
   {
   //create a new file type to represent the movieRevies.txt file
   File file = new File("movieReviews.txt");
   double total = 0;
   
   try {
         //This will read the input from the file
         Scanner fInput = new Scanner(file); 
           
         while (fInput.hasNextLine()) 
            {
            String line = fInput.nextLine();
            
            //The .contains allows this if to only run if the imput string "word" is found in the "line" string
            if(line.contains(word))
               {
               String score = line.substring(0,1);
               total = total + Integer.parseInt(score);
               }
            }
         return total;
       } catch(Exception e) {}
   return -1;
   }
   
   public static double wordAppearances(String word)
   {
   //This is the same as the first method except replace the total value with a appearances counter "c"
   File file = new File("movieReviews.txt");
   double c = 0;
   
   try {
         Scanner fInput = new Scanner(file);       
         
         while (fInput.hasNextLine()) 
            {
            String line = fInput.nextLine();
            
            if(line.contains(word))
               {
               c = c + 1;
               }
            }
         return c;
       } catch(Exception e) { }
   return -1;
   }
   
}