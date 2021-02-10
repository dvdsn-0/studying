package les7;

public class Main {

    public static void main(String[] args) {
        Cat Boris = new Cat(1200);
        Cat Tom = new Cat();
        System.out.println("У нас есть " + Cat.getCount() + " кошачьих");

        /**
         * 1. попробовать перекормить кошку, чтобы она попала к ветеринару
         * */

        int countFeed = 1;
        while (!Boris.getStatus().equalsIgnoreCase("clinic")) {
            Boris.feed(120);
            countFeed++;
            System.out.println(Boris.getWeight());
        }
        System.out.println("Борис покушал " + Boris.getCount() + " раз и попал в клинику");

        /**
         *  2. Создать у класса Cat статическую переменную count, которая будет увеличиваться, если кошку создали,
         *  и убывать, если кошка попала к ветеринару и статический метод getCount(),
         *  который будет возвращать количество кошек.
         * */

        System.out.println("У нас есть " + Cat.getCount() + " кошачьих");
    }
}