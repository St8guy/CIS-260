import java.util.Scanner;

public class Assignment1_Leeseberg 
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Part 1: Double or Nothing"); //Start of Part 1
      
         System.out.println("How much is your total debt?");
            double totalDebt = input.nextDouble(); //Declare the typed value as double totalDebt      
         System.out.println("How much do you have on hand now?"); 
            double inHand = input.nextDouble(); //Declare the typed value as double inHand
         int counter = 0;
         
         if (inHand <= 0 || totalDebt <= 0) //In-case user inputs a negative number
            {
            System.out.println("This is not a valid input please input a positive number");
            }
         else if(inHand > totalDebt) //If the user has enough to pay back depts before betting
            {
            System.out.println("Total number of bets: 0");
            System.out.println("Total amounmt in hand: " + inHand);
            System.out.println("You have the money to pay your debts already, don't gamble it all away.");
            }
         else
            {
            while(inHand < totalDebt)
               {
               inHand = inHand * 2; //Assume the "All or Nothing" bet always results in a win
               counter++; //Tracks how many bets have been made by counting the number of loops performed
               System.out.println("After " + counter + " bet(s), total in hand is $" + inHand);
               }
            System.out.println("Total number of bets: " + counter);
            System.out.println("Total amount in hand: " + inHand);
            }
            System.out.println(); //Makes the compiler more readable by splitting each part
            
            
            
                    
     System.out.println("Part 2: Pattern"); //Start of Part 2
     
         System.out.println("Enter the value for N:");
            int N = input.nextInt(); //N signifies the number of colums, takes input and assigns to N
         System.out.println("Enter the value for M:");
            int M = input.nextInt(); //M signifies the number of rows, takes input and assigns to M
         int counterN = 0; //Used to limit the amount of colums printed by counting the loops performed
         int counterM = 1; //Used to limit the amount of rows printed by counting the loops performed
         String Odd = "*.";
         String Even = ".*";
         
         while (counterM < M + 1)
            {
               while (counterM % 2 != 0 && counterM < M + 1) //Starting at 1 this will determine if we are in a odd numbered row
                  {
                     if(counterN < N-1)
                        {
                           System.out.print(Odd);
                           counterN = counterN + 1;
                        }else                        
                           {
                              System.out.println(Odd); //Needed to ensure that the output is split into appropriate lines
                              counterN = 0; //Resets the counterN for the next while loop
                              counterM = counterM + 1; //Without this the initial while loop would run indefinitly                            
                           }
                  }                    
               
               while (counterM % 2 == 0 && counterM < M +1) //This will determine if we are in a even numbered row
                  {
                     if(counterN < N-1)
                        {
                           System.out.print(Even);
                           counterN = counterN +1;
                        }else
                           {
                              System.out.println(Even); //Needed to ensure that the output is split into appropriate lines
                              counterN = 0; //Resets the counterN for the next while loop
                              counterM = counterM + 1;
                           }
                  }
            }
     System.out.println();
   
   
   
   
     System.out.println("Part 3: Baby Simulator");
     
        int boy = 0;
        int girl = 0;
     while ( boy < 1 || girl < 1) //The loop will continue to run until both boy and girl are at least 1
        {
           double random = Math.random(); //Produces a random number between 0 and 1    
           if(random < .5)
              {
                 boy = boy + 1;
              }else if(random >= .5)
                 {
                    girl = girl + 1;
                 }
           if( boy >= 1 && girl >= 1) //This will only print on the last loop, as the conditions that make this true will result in the while loop being false
              {
                 System.out.println("Congratulations! You have " + boy + " boy(s) and " + girl + " girl(s).");
              }
      }
   }
}