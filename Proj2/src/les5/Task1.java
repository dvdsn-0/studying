package les5;

import java.util.Scanner;

/**
 * Дано слово из четного числа букв. Поменять местами его половины. Вывести полученную строку в верхнем регистре.
 */

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Слово из четного количество букв: ");
        String word = scanner.next();

        //Перевожу слово в массив символов
        char array[] = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            array[i] = word.charAt(i);
        }

        //Массив в обратном порядке
        for (int i = 0; i < word.length() / 2; i++) {
            char symbol = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = symbol;
        }

        for (char name : array) {
            System.out.print(name);
        }
    }

}
