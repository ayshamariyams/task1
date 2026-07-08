import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int roundsPlayed = 0;
        int roundsWon = 0;
        char playAgain;
        do {
            roundsPlayed++;
            int targetNumber = ThreadLocalRandom.current().nextInt(1, 101);
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n=== Round " + roundsPlayed + " ===");
            System.out.println("Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    roundsWon++;
                    System.out.println("Correct! You guessed the number in " + attempts + " attempt(s).");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was " + targetNumber + ".");
            }

            System.out.println("Attempts used: " + attempts + " / " + maxAttempts);
            System.out.println("Score: " + roundsWon + " win(s) out of " + roundsPlayed + " round(s)");
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        } while (Character.toLowerCase(playAgain) == 'y');

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
