import javax.swing.JOptionPane;

public class MainClass {

    public static void main(String[] args) {
        String b;
        int a = Integer.parseInt(JOptionPane.showInputDialog("Введите значение: "));
        JOptionPane.showMessageDialog(null, a);
    }

}