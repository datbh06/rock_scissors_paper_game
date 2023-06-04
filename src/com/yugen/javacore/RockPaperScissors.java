package com.yugen.javacore;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Define an enum to represent
    // the choices of rock, paper and scissors.
    enum Choice {
        ROCK, PAPER, SCISSORS;

        //Method to generate a random choice for the computer
        public static Choice getRandomChoice() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

        //Method to determine the result of the game
        // based on the user's choice and the computer's
        public String getResult(Choice other) {
            if (this == other) {
                return "Draw";
            }
            switch (this) {
                case ROCK:
                    return (other == SCISSORS) ? "You win" : "You lose";
                case SCISSORS:
                    return (other == PAPER) ? "You win" : "You lose";
                case PAPER:
                    return (other == ROCK) ? "You win" : "You lose";
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        //Loop to repeatedly display the menu
        // and play the game until user chooses to quit
        while (playAgain) {
            System.out.println("Menu:");
            System.out.println("1. Play Rock, Scissors, Paper");
            System.out.println("2. Quit");
            System.out.print("Enter your choice: ");
            int menuChoice = sc.nextInt();
            sc.nextLine();

            if (menuChoice == 1) {
                //Generate a random choice for the computer
                Choice computerChoice = Choice.getRandomChoice();

                //Prompt the user to enter their choice and validate their input
                Choice userChoice = null;

                while (userChoice == null) {
                    System.out.println("Enter your choice rock | paper | scissors: ");
                    String choice = sc.next();
                    try {
                        userChoice = Choice.valueOf(choice.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid choice. Please try again!");
                    }
                }

                System.out.println("Your choice: " + userChoice);
                System.out.println("Computer choice: " + computerChoice);

                System.out.println(userChoice.getResult(computerChoice));
            } else if (menuChoice == 2) {
                // If the user chooses to quit, set playAgain false to exit the loop
                playAgain = false;
                System.out.println("Good Bye!!!! :)");
            } else {
                // If the user enters an invalid menu choice, print an error message
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }
}
