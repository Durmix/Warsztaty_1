import java.util.Scanner;

public class Zad_3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int attempts = 0, min = 0, max = 1000, guess = 0;
        String reply;

        System.out.println("Welcome in the GUESS THE NUMBER GAME. Insert 'higher', 'lower' or 'correct' without capital letters");

        while (true) {

            attempts++;
            guess = ((max - min) / 2) + min;
            System.out.println("My guess: " + guess);

            while (true) {
                reply = scan.nextLine();

                if ("higher".equals(reply)) {
                    min = guess;
                } else if ("lower".equals(reply)) {
                    max = guess;
                } else if ("correct".equals(reply)) {
                    System.out.println("I won in " + attempts + " attempts!");
                    return;
                } else {
                    System.out.println("Don't cheat!");
                    continue;
                }
                break;
            }
        }

    }
}
