import java.util.Random;
import java.util.Scanner;

public class Zad_4 {

    public static void main(String[] args) {

        System.out.print("Insert cube code: ");
        Scanner scan = new Scanner(System.in);
        String code = scan.nextLine();

        int x = diceCounter(code);
        int y = diceCoder(code);
        int z = offSet(code);
        int value = getValue(x, y);
        int result = z + value;

        System.out.println(result);

    }

    private static int diceCounter(final String code) {

        int dices = 1;

        if (code.charAt(0) != 'D') {
            dices = Integer.parseInt(code.substring(0, code.indexOf("D")));
        }

        return dices;
    }

    private static int diceCoder(final String code) {

        int walls = 0;

        if (code.contains("+")) {
            walls = Integer.parseInt(code.substring(code.indexOf("D") + 1, code.indexOf("+")));
        } else if (code.contains("-")) {
            walls = Integer.parseInt(code.substring(code.indexOf("D") + 1, code.indexOf("-")));
        }

        return walls;
    }

    private static int offSet(final String code) {
        int offset = 0;

        if (code.contains("+")) {
            offset = Integer.parseInt(code.substring(code.indexOf("+")));
        } else if (code.contains("-")) {
            offset = Integer.parseInt(code.substring(code.indexOf("-")));
        }

        return offset;
    }

    private static int getValue(int attempts, int walls) {
        Random rand = new Random();
        int value = 0;

        for (int i = 0; i < attempts; i++) {
            value += rand.nextInt(walls - 1) + 1;
        }

        return value;
    }

}
