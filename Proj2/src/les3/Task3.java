package les3;

/**
 * 2) Найти среднее арифметическое всех з/п для всех офисов
 * 3) Найти максимальный оклад из всех офисов
 */

public class Task3 {
    static int[] createOffice(String address, int col) {
        int office[] = new int[col];
        System.out.println("Офис по адресу: " + address);
        for (var i = 0; i < office.length; i++) {
            office[i] = (int) (Math.random() * 70000 + 30000);
            System.out.println(office[i]);
        }
        System.out.println("-----------------------------------------------------------");
        return office;
    }

    /**
     * Подсчет средней зп по офису
     */

    static int getMidZp(int office[]) {
        int s = 0;
        for (var i = 0; i < office.length; i++) {
            s += office[i];
        }
        s = s / office.length;
        return s;
    }

    /**
     * Подсчет максимальной зп по офису
     */

    static int getMaxZp(int office[]) {
        int s = 0;
        for (var i = 0; i < office.length; i++) {
            if (s < office[i]) {
                s = office[i];
            }
        }
        return s;
    }


    public static void main(String[] args) {
        int office1[] = createOffice("Офис в г. Москва", 10);
        int office2[] = createOffice("Офис в г. Новосибирск", 15);
        int office3[] = createOffice("Офис в г. Санкт-Петербург", 8);
        //Запрашиваем и выводим среднюю зп по офисам:
        System.out.println("Средняя ЗП в оф. №1: " + getMidZp(office1) + "\tСредняя ЗП в оф. №2: " + getMidZp(office2) + "\tСредняя ЗП в оф. №3: " + getMidZp(office3) + "\t");
        //Запрашиваем и выводим макс. ЗП по сотрудникам офисов:
        System.out.println("Макс. зп в оф. №1: " + getMaxZp(office1) + "\tМакс. зп в оф. №2: " + getMaxZp(office2) + "\tМакс. зп в оф. №3: " + getMaxZp(office3));
    }
}