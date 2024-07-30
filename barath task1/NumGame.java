import java.util.Random;
import java.util.Scanner;

public class NumGame {
    public static void main(String args[])throws InterruptedException{
    Scanner scan=new Scanner(System.in);
    int no_of_round=5;
    String name;
    boolean lose=false;

    System.out.println("\n----------------------NUMBER GUESSING GAME----------------------\n");
    Thread.sleep(1000);

    System.out.println("Enter your Name");
    name= scan.nextLine();

    Thread.sleep(1000);
    System.out.printf("Hi %s Welcome to the Number game\n\n",name);
    Thread.sleep(1000);

  

    System.out.printf("About Game: there are totally 5 attempts in each round you can enter into next round only if you win  \n",no_of_round);
    Thread.sleep(1000);
    boolean playAgain;
    do {
        int round=1;
        
        Random random = new Random();
    
        while(no_of_round>=round){
            int attempts=0;
            int chances=5;
            int min_val=1 , max_val=100;
            int randomNumber = random.nextInt(101);

            Thread.sleep(1000);
            System.out.println("round:"+round);
            Thread.sleep(1000);
            System.out.println("Guess the Number between ( 1 to 100 )");
            Thread.sleep(1000);
            
           
            while(true){
            Thread.sleep(1000);
            System.out.printf("\nyou have %d chances\n",chances);
            Thread.sleep(1000);
         
            System.out.println("Enter the guessed number :");
            int guess=scan.nextInt();
            Thread.sleep(1000);
            if(guess<=min_val || guess>=max_val){
               System.out.printf("Invalid Enter the Number between %d and %d\n",min_val,max_val);
               
            }
            else if(guess==randomNumber){
                int baseScore = 100;
                System.out.println(attempts);

                int score = baseScore - (attempts * 20) ;
                System.out.println(score);
                round++;
                int Actual_score =  Math.max(score, 0);
                System.out.printf("Correct! You've guessed the number in %d attempts.\n", chances);
                System.out.printf("Your score is: %d \n", Actual_score);
                break;
            }
            else if(guess>randomNumber){
                max_val=guess;
                System.out.printf("the guessed number  is high the number is between %d and %d\n",min_val,max_val);
                attempts+=1;
                chances-=1;
            }
            else{
                min_val=guess;
                System.out.printf("the guessed number is low the number is betwen %d and %d\n",min_val,max_val);
                attempts+=1;
                chances-=1;

            }  

            if(chances==0){
                System.out.println("you lose ");
                System.out.println("the number is :"+randomNumber );
                lose=true;
                break;
               }
           }
         
           if(lose){
            break;
           }
        
            }

    
        System.out.print("Do you want to play again? (yes/no): ");
        playAgain = scan.next().equalsIgnoreCase("yes");
    } while (playAgain);
    scan.close();
    }
    
}
