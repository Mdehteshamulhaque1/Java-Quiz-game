import java.util.Scanner;

public class JavaQuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        // Questions
        String[] questions = {
            "Which of the following is the correct way to declare and initialize this variable?",
            "You want to print numbers from 1 to 5 in a Java program. Which loop correctly prints these numbers in order (1, 2, 3, 4, 5)?",
            "In a Java program, you want to check if a user's input number is positive. Which conditional statement correctly checks this?"
        };

        // Options
        String[][] options = {
            {
                "1. int score = 85;",
                "2. String score = 85;",
                "3. double score = 85;",
                "4. integer score = 85;"
            },
            {
                "1. for (int i = 1; i <= 5; i++) {\n   System.out.println(i);\n}",
                "2. for (int i = 0; i < 5; i++) {\n   System.out.println(i);\n}",
                "3. while (int i = 1; i <= 5; i++) {\n   System.out.println(i);\n}",
                "4. for (int i = 1; i < 5; i++) {\n   System.out.println(i);\n}"
            },
            {
                "1. if (userInput > 0) { System.out.println(\"Positive!\"); }",
                "2. if (userInput == 0) { System.out.println(\"Positive!\"); }",
                "3. if (userInput >= 0) { System.out.println(\"Positive!\"); }",
                "4. if (userInput.equals(0)) { System.out.println(\"Positive!\"); }"
            }
        };

        // Correct option numbers (1-based)
        int[] correctAnswers = {1, 1, 1};

        System.out.println("Welcome to the Java Beginner Quiz Game!");
        System.out.println("Test your knowledge about Java Language!");

        while (playAgain) {
            int score = 0;

            for (int i = 0; i < questions.length; i++) {
                System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);

                for (String option : options[i]) {
                    System.out.println(option);
                }

                // Input validation
                int userAnswer;
                do {
                    System.out.print("Your guess (1-4): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a number between 1 and 4.");
                        System.out.print("Your guess (1-4): ");
                        scanner.next();
                    }
                    userAnswer = scanner.nextInt();
                    if (userAnswer < 1 || userAnswer > 4) {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } while (userAnswer < 1 || userAnswer > 4);

                if (userAnswer == correctAnswers[i]) {
                    System.out.println("That's correct!");
                    score++;
                } else {
                    System.out.println("Oops, that's not right. The correct answer was option " +
                        correctAnswers[i] + ": " +
                        options[i][correctAnswers[i] - 1].substring(3));
                }
            }

            System.out.println("\nQuiz Done! Your score: " + score + "/" + questions.length);
            if (score == questions.length) {
                System.out.println("Wow, you're a Java expert! Perfect score!");
            } else if (score > 0) {
                System.out.println("Great effort! Try again to become a better coder!");
            } else {
                System.out.println("No worries, let's learn more about Java and try again!");
            }

            // Clear input buffer
            scanner.nextLine();
            
            // Input validation for play again
            String response;
            do {
                System.out.print("\nWant to play again? (yes/no): ");
                response = scanner.nextLine().toLowerCase();
                if (!response.equals("yes") && !response.equals("no")) {
                    System.out.println("Please enter 'yes' or 'no'.");
                }
            } while (!response.equals("yes") && !response.equals("no"));
            
            playAgain = response.equals("yes");
            System.out.println();
        }

        System.out.println("Thanks for playing! Come back anytime!");
        scanner.close();
    }
}