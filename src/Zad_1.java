import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zad_1 {

    public static void main(String[] args) {
        Random rand = new Random();
        int input = 0, attempts = 0;
        int searchedNumber = rand.nextInt(100) + 1;
        Scanner scan = new Scanner(System.in);
        boolean win = false;

        while (!win) {

            System.out.print("Guess the number: ");

            try {
                input = scan.nextInt();
                attempts++;
            } catch (InputMismatchException e) {
                System.out.println("Maybe try to insert a number?");
                scan.nextLine();
                continue;
            }
            if (input < searchedNumber) {
                System.out.println("try higher");
            } else if (input > searchedNumber) {
                System.out.println("try lower");
            } else {
                System.out.print("Good job! Took you " + attempts + " tries.");
                win = true;
            }
        }
    }

}
