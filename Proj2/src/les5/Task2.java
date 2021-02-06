package les5;

import java.util.Scanner;

/**
 * Дано предложение. Определить число слов в нем.
 */

public class Task2 {

    public static void main(String[] args) {
        int count = 0;
        String stroka = "Жили были дед и бабка";

        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println("В предложении " + count + " слов");
    }

}