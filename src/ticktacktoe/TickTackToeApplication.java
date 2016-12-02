package ticktacktoe;

import java.util.Scanner;

/**
 * Created by Dell on 13-11-2016.
 */
public class TickTackToeApplication {

    public static void main(String[] args) {
        //Getting input
        Scanner sc = new Scanner(System.in);
        //Allows for continue games
        boolean doYouWantToPlay = true;

        while(doYouWantToPlay){
            //Setting up our token and AI
            System.out.println("Welcome to the Tick Tack Toe Game! You are about to go against\n"
                                + "the master of Tick Tack Toe - SIR JOJIA!!!\n"
                                + "\nPlease choose the character you want to take!"
                                + "\nAlso choose SIR JOJIA's character");
            System.out.println("");
            System.out.println("\nEnter the character that will represent you!");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter the character that will represent SIR JOJIA!");
            char opponentToken = sc.next().charAt(0);
            TickTackToe game = new TickTackToe(playerToken,opponentToken);
            AI ai = new AI();

            //Set up the Game
            System.out.println("\n\nNow we can start the game. \n" +
                               "To play enter a number and your token shall be put in its place \n" +
                               "The numbers go 1 to 9 from left to right\n" +
                               "\nLets see if you can beat SIR JOJIA!!!\n");

            game.printIndexBoard();
            System.out.println();

            //Let's Play
            while(true){
                if (!(game.gameOver().equals("notOver"))) break;
                if(game.currentMarker == game.userMarker) {
                    //User's Turn
                    System.out.println("It's Your Turn.\tEnter a spot for your token");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Please enter another spot!\t" + spot +
                                "is Invalid. Either its already taken or out of range.");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + " spot!");
                } else {
                    // AI's Turn
                    System.out.println("It's My Turn! Ayeee Sajjaaar Saaar!");
                    //Pick Spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + " spot");
                }
                //Print new board
                game.printBoard();
            }
            System.out.println(game.gameOver() + "\n");

            //Set up a new game!!! Asking the user
            System.out.println("Are you scared of Sir Jojia? \nCome lets play another Game!\n" +
                    "\nEnter Y if you want to play! \n Enter any other character if you" +
                    " want to surrender to SIR Jojia!!! ");
            char response;
            response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'Y');
            System.out.println();
            System.out.println();
        }
    }


}
