import java.util.Hashtable;

public class Office {
    Hashtable<Integer, Man> men = new Hashtable<Integer, Man>();

    class Man {
        String name;
        int oklad;

        public Man(String name, int oklad) {
            this.name = name;
            this.oklad = oklad;
        }
    }

    public Office() {
        men.put(1, new Man("Иванов", 50000));
        men.put(2, new Man("Петров", 70000));
        men.put(3, new Man("Сидоров", 40000));
    }

    /**
     * реализовать алгоритм поиска зарплаты по введенной с клавиатуры ФИО
     */

    int getZp(String name) {
        String n = name;
        var e = men.elements();
        Man m;
        int r = 0;
        while (e.hasMoreElements()) {
            m = e.nextElement();
            if (m.name == n) {
                r = m.oklad;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Office().getZp("Сидоров"));
    }

}
