package les4;

public class Task1 {

    public static void main(String[] args) {
        int sum = 0, matrix[][] = {
                {1, 2, 3},
                {4, 5, 6, 9},
                {7, 8, 9},
                {9, 1, 2}
        };
		/*System.out.println(matrix.length);//количество строк
		System.out.println(matrix[0].length);//количество столцов для определенной строки*/

        /**
         * Сумма массива по строкам
         */

        for (int i = 0; i < matrix.length; i++) {//i - номер строк
            for (int j = 0; j < matrix[i].length; j++) { // j - номер стобца
                sum = sum + matrix[i][j];
            }
            System.out.println("Сумма строки " + (i + 1) + " = " + sum);
            sum = 0;
        }
        System.out.println("********************");

        /**
         * Сумма массива по столбцам
         */

        //Нахожу кол-во столбцов
        int dlinaSt = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {//i - номер строк
            if (dlinaSt < matrix[i].length) {
                dlinaSt = matrix[i].length;
            }
            ;
        }

        //Записываю сумму столбцов в массив (элемент массива = сумма одного столбца)
        int stolb[] = new int[dlinaSt];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stolb[j] = stolb[j] + matrix[i][j];
            }
        }

        //Вывод в консоль
        for (int i = 0; i < stolb.length; i++) {
            System.out.println("Сумма столбца " + (i + 1) + " = " + stolb[i]);
        }

    }

}