package les3;

/**
 * Вывести все простые числа от 2 до 100. Использовать while
 */

public class Task1 {

    public static void main(String[] args) {
        int i, j;
        boolean f;
        for (i = 2; i < 100; i++) {
            f = true;
            j = 2;
            while (j <= i / 2) {
                if (i % j == 0) {
                    f = false;
                    break;
                }
                j++;
            }
            if (f == true) System.out.print(i + "\t");
        }
    }
}
