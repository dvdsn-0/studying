package les3;

/**
 * Вывести текущую дату в формате: "15:30 28.08.2015"
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task2 {

    public static void main(String[] args) {
        System.out.print(new SimpleDateFormat("HH:mm dd.MM.yyyy").format(new Date()));
    }
}
