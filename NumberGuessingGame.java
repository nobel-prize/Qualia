import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Module 1: Random Number Generation
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Module 2: User Input and Validation
    public static int getUserGuess(Scanner scanner) {
        int guess = -1;
        while (true) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
        return guess;
    }

    // Module 3: Game Logic and Feedback
    public static void playGame(int targetNumber, Scanner scanner) {
        int attempts = 0;
        int userGuess;

        do {
            userGuess = getUserGuess(scanner);
            attempts++;

            if (userGuess > targetNumber) {
                System.out.println("Too high! Try a lower number.");
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
            }

        } while (userGuess != targetNumber);

        // Module 5: Result Display
        System.out.println("You guessed the number in " + attempts + " attempts.");
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + min + " and " + max + ".");

        int targetNumber = generateRandomNumber(min, max);

        // Start Game
        playGame(targetNumber, scanner);

        scanner.close();
    }
}
