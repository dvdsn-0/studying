package les1;
import javax.swing.JOptionPane;

//Дано расстояние в метрах. Найти число полных километров в нем.

public class Pract2task1 {

	public static void main(String[] args) {
	JOptionPane.showMessageDialog(null, "В киллометрах: " + (Float.parseFloat(JOptionPane.showInputDialog("Введите значение в метрах: "))/1000));
	}

}
