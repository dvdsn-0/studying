package les10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import javax.swing.JOptionPane;


public class Shop {
    static Hashtable<String, Integer> goods = new Hashtable<String, Integer>();
    static Hashtable<String, String> users = new Hashtable<String, String>();

    static boolean isAuth(String login, String pass) {
        var e = users.keys();
        while (e.hasMoreElements()) {
            var l = e.nextElement();//логин
            var p = users.get(l);//пароль
            if (login.equals(l) && pass.equals(p)) {
                return true;
            }
        }
        return false;
    }

    static void show() {
        var e = goods.keys();
        String title = "";
        while (e.hasMoreElements()) {
            title = e.nextElement();
            System.out.println(title + " стоит " + goods.get(title));
        }
    }

    static boolean delete(String title) {
        var e = goods.keys();
        while (e.hasMoreElements()) {
            if (title.equals(e.nextElement())) {
                goods.remove(title);
                return true;
            }
        }
        return false;
    }

    static void search(String title) {
        var e = goods.keys();
        while (e.hasMoreElements()) {
            if (title.equals(e.nextElement())) {
                System.out.println(title + " стоит " + goods.get(title));
            }
        }
    }

    static void max() {
        var e = goods.keys();
        int max = 0;
        String title = "", name = "";
        while (e.hasMoreElements()) {
            title = e.nextElement();
            if (max < goods.get(title)) {
                max = goods.get(title);
                name = title;
            }
        }
        System.out.println("Самый дешевый товар: " + name + " - " + max);
    }

    static void min() {
        var e = goods.keys();
        int min = goods.get(e.nextElement());
        String title = "", name = "";
        while (e.hasMoreElements()) {
            title = e.nextElement();
            if (min > goods.get(title)) {
                min = goods.get(title);
                name = title;
            }
        }
        System.out.println("Самый дорогой товар: " + name + " - " + min);
    }

    public static void main(String[] args) throws IOException {
        users.put("admin", "12345");
        users.put("user", "123");
        goods.put("A", 123);
        goods.put("C", 333);
        goods.put("B", 222);
        goods.put("D", 23);

        String login = JOptionPane.showInputDialog("Введите логин");
        String pass = JOptionPane.showInputDialog("Введите пароль");
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String command = "", title = "";
        int price;
        if (isAuth(login, pass)) {
            var end = false;
            for (; ; ) {
                if (end) {
                    break;
                }
                System.out.println("Введите команду (ADD,DELETE,SHOW,SEARCH,MAX,MIN,END)");
                command = reader.readLine();
                switch (command) {
                    case "ADD":
                        for (; ; ) {
                            System.out.println("Введите название товара или STOP");
                            title = reader.readLine();
                            if (title.equalsIgnoreCase("STOP")) {
                                break;
                            }
                            System.out.println("Введите цену для товара " + title);
                            price = Integer.parseInt(reader.readLine());
                            goods.put(title, price);
                        }
                        break;
                    case "SHOW":
                        show();
                        break;
                    case "DELETE":
                        System.out.println("Введите название товара для удаления или STOP");
                        title = reader.readLine();
                        if (delete(title)) System.out.println("Позиция удалена");
                        else System.out.println("Позиция не найдена");
                        break;
                    case "SEARCH":
                        System.out.println("Введите название товара для его поиска или STOP");
                        title = reader.readLine();
                        search(title);
                        break;
                    case "MAX" :
                        max();
                        break;
                    case "MIN" :
                        min();
                        break;
                    case "END":
                        System.out.println("Работа с системой завершена!");
                        end = true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Доступ отсутствует!!!");
        }
    }
}
