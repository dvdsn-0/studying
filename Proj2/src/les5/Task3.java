package les5;

/**
 * Дано предложение. Определить долю
 * (в %) последней буквы в нем. (находим последнюю букву в слове,
 * находим количество таких букв в предложении и считаем пропорцией)
 */

public class Task3 {

    public static void main(String[] args) {
        int count = 0;
        String stroka = "Жили были дед и бабка";

        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) == stroka.charAt(stroka.length() - 1)) {
                count++;
            }
        }
        float percent = (count * 100 / stroka.length());


        System.out.println("Часть буквы '" + stroka.charAt(stroka.length() - 1) + "' в предложении составляет: " + percent + "%");
    }

}