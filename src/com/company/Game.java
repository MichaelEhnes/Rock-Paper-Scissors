package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {

    String[] answers = {"rock", "paper", "scissors"};
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    int playerAnswer, computerAnswer, victor = 0;
    String playerReplayResponse;

    public Game(){
        playGame();
    }

    //  Where the game is played
    public void playGame() {

        displayInitialMenu();
        Player player = new Player(scanner.nextLine());
        System.out.println("Welcome " + player.getPlayerName() + ", good luck!");

        while(true){

            while(true) {

                displayGameMenu();

                try{
                    playerAnswer = Integer.parseInt(scanner.nextLine());
                }

                catch(Exception ex) {
                    System.out.println("Please enter a valid number");
                }

                finally {

                    if(playerAnswer >= 1 && playerAnswer <= 4 ) {

                        if(playerAnswer == 4) {
                            displayPlayerStats(player);
                        } else {
                            break;
                        }

                    }
                    else{
                        System.out.println("Please enter a valid number");
                    }
                }
            }

            //  END DISPLAY WHILE LOOP
            computerAnswer = rand.nextInt(3) + 1;
            victor = compareAnswers(player);
            displayResults(player, victor);

            askToReplay();
            playerReplayResponse = scanner.nextLine();

            //  Breaks the main game loop and game is over
            if(!playerReplayResponse.equals("y")) {
                break;
            }

        }

        scanner.close();

    }

    //  Only shown on boot up
    public void displayInitialMenu(){
        System.out.println("Welcome to Rock Paper Scissors");
        System.out.println("What's your name?");
    }

    public void askToReplay(){
        System.out.println("Would you like to play again?");
        System.out.println("Enter 'y' for yes");
    }

    public void displayGameMenu() {
        System.out.println("Please enter a number 1 - 4 as your choice.");
        System.out.println("1 = Rock");
        System.out.println("2 = Paper");
        System.out.println("3 = Scissors");
        System.out.println("4 = Display Stats");
    }

    //  returns 0 on player win, 1 on computer win, 2 on tie
    public int compareAnswers(Player player){

        if(playerAnswer == computerAnswer) {
            player.incrimentTies();
            return 2;
        }

        else if(playerAnswer == 1 && computerAnswer == 3) {
            player.incrementWins();
            return 0;
        }

        else if(playerAnswer == 2 && computerAnswer == 1) {
            player.incrementWins();
            return 0;
        }

        else if(playerAnswer == 3 && computerAnswer == 2) {
            player.incrementWins();
            return 0;
        }

        else {
            player.incrementLosses();
            return 1;
        }

    }

    public void displayResults(Player player, int result) {

        System.out.println("You chose " + answers[playerAnswer - 1] + " and the computer chose " + answers[computerAnswer - 1]);

        if(result == 0) {
            System.out.println("Congrats " + player.getPlayerName() + " you won!");
        }

        else if(result == 1) {
            System.out.println("Oh No! Ya lost " + player.getPlayerName() + "!");
        }

        else {
            System.out.println("Welp, that's a tie!");
        }

    }

    public void displayPlayerStats(Player player) {
        System.out.println("Wins: " + player.getWins());
        System.out.println("Ties: " + player.getTies());
        System.out.println("Losses: " + player.getLosses());
        System.out.println("Win-Loss Ratio: " + player.getWinLoss());
    }

}
