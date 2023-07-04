package bd.uz;

import java.util.Random;

public class AquariumUtil {

    public static Random random = new Random();

    public static int getrandom(int n) {
        return random.nextInt(n);
    }

    public static int getrandombetween(int a, int b) {
        return random.nextInt(a, b);

    }

    public static boolean getRandomBool() {
        return random.nextInt(2) == 0;
    }
}
