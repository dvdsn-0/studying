package les9.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Сгенерировать список номеров автомобилей и сделать метод, который будет проверять наличие номера
 * в списке. В номерах использовать буквы и код региона. Сделать возможность автоматического и ручного
 * заполнения номера (т.е. числа). Код региона, имя владельца для каждого номера вводится с клавиатуры.
 * Серия заполняется по желанию (А001АА164). Дубликатов быть не должно. Организовать поиск владельца
 * автомобиля по номеру
 */

public class Main {
    static List<Line> car = new ArrayList<Line>();

    static class Line {
        String name;
        int num;
        int region;

        public Line(String name, int num, int region) {
            this.name = name;
            this.num = num;
            this.region = region;
        }
    }

    // Поиск номера по фамилии
    static int getNumByName(String name) {
        String n = name;
        var e = new Main().car;
        int r = 0;
        for (var item : e) {
            if (item.name == n) {
                r = item.num;
            }
        }
        return r;
    }

    // Поиск владельца по номеру
    static String getNameByNum(int num) {
        int n = num;
        String r = "";
        for (var item : car) {
            if (item.num == n) {
                r = item.name;
            }
        }
        return r;
    }

    // Добавление записи вручную (с проверкой на дубликаты)
    static boolean addLine(String name, int num, int region) {
        for (var item : car) {
            if (item.num == num) {
                return false;
            }
        }
        car.add(new Line(name, num, region));
        return true;
    }

    // Добавление записи авто
    static boolean addLine(String name, int region) {
        car.add(new Line (name, (int) (Math.random() * 1000 + 1), region));
        return true;
    }


    public static void main(String[] args) throws IOException {
        car.add(new Line("Воронин", 777, 54));
        car.add(new Line("Скворцов", 342, 99));
        car.add(new Line("Лебедев", 248, 37));
        car.add(new Line("Голубева", 935, 150));
        car.add(new Line("Синица", 768, 33));
        car.add(new Line("Дрозд", 345, 44));

        /**
         * Поиск номера по фамилии
         */

        String name = "Лебедев";
        System.out.println(name + " найден с номером " + new Main().getNumByName(name));

        /**
         * Поиск владельца по номеру
         */

        int num = 768;
        System.out.println("Номер " + num + " принадлежит гражданину " + new Main().getNameByNum(768));

        /**
         * Добавление записи вручную (с проверкой на дубликаты)
         */

        var reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя");
        name = reader.readLine();
        System.out.println("Введите номер");// Без проверки на длину
        num = Integer.parseInt(reader.readLine());
        System.out.println("Введите регион");// Без проверки на длину
        int region = Integer.parseInt(reader.readLine());
        if (new Main().addLine(name, num, region)) {
            System.out.println("Запись добавлена");
        }
        else {
            System.out.println("Номер занят");
        };

        /**
         * Добавление записи авто
         */

        System.out.println("Введите имя");
        name = reader.readLine();
        System.out.println("Введите регион");// Без проверки на длину
        region = Integer.parseInt(reader.readLine());
        new Main().addLine(name, region);
    }

}