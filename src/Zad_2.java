import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Zad_2 {

    public static void main(String[] args) {
        int[] numbers = get_numbers();
        int[] lottoNumbers = lottoNumbers();
        int goodPicks = correctPicks(lottoNumbers,numbers);

        System.out.print(" Your picks: " + Arrays.toString(numbers));

        if (goodPicks < 1) {
            System.out.println(" Sorry, not this time :(");
        } else if (goodPicks >= 1 && goodPicks < 3) {
            System.out.println(" You almost got it, try again!");
        } else {
            System.out.println(" Good job you picked " + goodPicks + " out of 6 winning numbers!");
        }


    }

    private static int[] get_numbers() {
        int[] pickedNumbers = new int[6];
        Scanner scan = new Scanner(System.in);
        boolean check = true;

        for (int i = 0; i < 6; i ++) {
            do {
                check = true;

                System.out.print("Insert " + (i + 1) + ". number: ");
                if (scan.hasNextInt()) {
                    pickedNumbers[i] = scan.nextInt();
                    scan.nextLine();
                } else {
                    System.out.print("Not a number. ");
                    scan.nextLine();
                    i--;
                    continue;
                }

                if (pickedNumbers[i] >= 50 || pickedNumbers[i] <= 0) {
                    System.out.print("Not in a range. ");
                    i--;
                    continue;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (pickedNumbers[i] == pickedNumbers[j]) {
                            System.out.print("Number repeated. ");
                            check = false;
                            break;
                        }
                    }

                }
            } while (!check);
        }

        return pickedNumbers;
    }

    private static int correctPicks (int[] wins, int[] picks) {
        int correctPicks = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (wins[i] == picks[j]) {
                    correctPicks++;
                }
            }
        }

        return correctPicks;
    }

    private static int[] lottoNumbers() {
        Integer[] numbers = new Integer[49];
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(numbers));
        for (int i = 0; i < 6; i++) {
            lottoNumbers[i] = numbers[i];
        }

        System.out.print("Winning numbers: " + Arrays.toString(lottoNumbers));
        return lottoNumbers;
    }
}
