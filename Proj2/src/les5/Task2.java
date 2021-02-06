package les5;

import java.util.Scanner;

/**
 * Дано предложение. Определить число слов в нем.
 */

public class Task2 {

    public static void main(String[] args) {
        String stroka = "Жили были дед и бабка";
        System.out.println("В предложении " + (stroka.indexOf(" ") + 1) + " слов");
    }

}