// Programmer: Rizon Takabe
// Class: CS 141 Face-to-face
// Date: 4/6/23
// Assignment: Lab 1 Guessing Game
// Purpose: Make a program that takes in integers and tells user higher or lower until they guess the randomly generated int
// I worked on this in vscode, so far I've really liked how it sped up the coding for me. Also I used an array to keep track of the stats

//library
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args){
        final int guessRange = 99;
        int[] gamesAndGuessesAndBest = new int[3];

        intro(guessRange);
        gamesAndGuessesAndBest = gameWhileLoop(guessRange);
        stats(gamesAndGuessesAndBest);
    } // end of main method

    public static void intro(int guessRange){
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and "+(guessRange+1));
        System.out.println("and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.\n");
    } // end of intro method

    public static int game(int guessRange){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int answer = random.nextInt(guessRange)+1;
        int guessCount = 0;
        int guess = 0;

        System.out.println("My numbers between 1 and "+(guessRange+1));
        while (guess != answer) {
            System.out.print("Your guess? ");
            guess = scanner.nextInt();

            if (guess > answer) {
                System.out.println("It's lower.\n");
            } else if (guess < answer) {
                System.out.println("It's higher.\n");
            }
            guessCount++;
        }
        if (guessCount == 1) {
            System.out.println("You got it right on your first try! You aren't cheating right?");
        } else {
            System.out.println("You got it right in "+guessCount+" guesses!");
        } // check if plural
        return guessCount;
    } // end of game method

    public static int[] gameWhileLoop(int guessRange){
        Scanner scanner = new Scanner(System.in);
        int totalGames = 0;
        int guesses = 0;
        int totalGuesses = 0;
        int bestGame = 99999;
        String choice = "";
        boolean playAgain = true;

        while (playAgain) {
            guesses = game(guessRange);
            totalGuesses += guesses;
            if (guesses < bestGame) {
                bestGame = guesses;
            }
            totalGames++;
            System.out.print("Play again? ");
            choice = scanner.next();
            if (choice.toUpperCase().charAt(0)=='N'){
                playAgain = false;
            } else if (choice.toUpperCase().charAt(0)=='Y'){
                System.out.println("YAYYY!! :D");
            } else {
                System.out.println("Imma just assume that means you want to play again...");
            }
        } // end of while loop

        System.out.println("Okay... :(\n");
        int[] gamesAndGuessesAndBest = new int[]{totalGames, totalGuesses, bestGame};
        return gamesAndGuessesAndBest;
    } // end of game while loop method

    public static void stats(int[] gamesAndGuessesAndBest){
        System.out.println("Overall results:");
        System.out.println("\ttotal games: "+gamesAndGuessesAndBest[0]);
        System.out.println("\ttotal guesses: "+gamesAndGuessesAndBest[1]);
        System.out.printf("\tguesses/game: %.1f%s",((double)gamesAndGuessesAndBest[1]/gamesAndGuessesAndBest[0]),"\n");
        System.out.println("\tbest game: "+gamesAndGuessesAndBest[2]);
    } // end of stats method
} // end of class
