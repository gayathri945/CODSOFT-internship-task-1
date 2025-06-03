import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static int playGame(Scanner scanner) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; // it Generates a number between 1 and 100
        int maxAttempts = 7;
        int attempts = 0;

        System.out.println("I'm thinking of a number between 1 and 100.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + " of " + maxAttempts + ". Enter your guess: ");
            int guess;

            // here it handles  non-integer input
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // this clears invalid input
                continue;
            }

            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low. Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
                return maxAttempts - attempts + 1; // Higher score for fewer attempts
            }
        }

        System.out.println("Sorry, you've used all attempts. The number was " + numberToGuess + ".");
        return 0; // No score for this round
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int score = playGame(scanner);
            totalScore += score;
            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over.");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total score: " + totalScore);

        scanner.close();
    }
}

    

