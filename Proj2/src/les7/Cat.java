package les7;

public class Cat {
    private double originWeight;//исходный вес
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double feed;
    static int count = 0;

    public Cat() {
        weight = Math.random() * 3000 + 1500;
        originWeight = weight;
        minWeight = 1000;
        maxWeight = 9000;
        count++;
    }

    /**
     * 3. Создать в классе Cat ещё один конструктор так, чтобы массу кошки можно было задавать при создании кошки,
     * и создать в главном классе метод генерации кошки.
     */

    public Cat(int weightCat) {
        weight = weightCat;
        originWeight = weight;
        minWeight = 1000;
        maxWeight = 9000;
        count++;
    }

    public void meow() {
        weight--;
        System.out.println("Мяу");
    }

    public void feed(double amount) {
        weight += amount;
        feed += amount;
    }

    public double getFeed() {
        return feed;
    }

    public String getStatus() {
        if (weight < minWeight) {
            this.count--;
            return "Game over";
        } else if (weight > originWeight && weight < maxWeight) {
            return "sleeping";
        } else if (weight > maxWeight) {
            this.count--;
            return "clinic";

        } else {
            return "playing";
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *  2. Создать у класса Cat статическую переменную count, которая будет увеличиваться, если кошку создали,
     *  и убывать, если кошка попала к ветеринару и статический метод getCount(),
     *  который будет возвращать количество кошек.
     * */

    public static int getCount() {
        return count;
    }


}
