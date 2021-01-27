package les1;

import javax.swing.JOptionPane;

public class Pract2task1 {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(
				null, "В килkометрах: " + (Float.parseFloat(JOptionPane.showInputDialog("Введите значение в метрах: "))/1000)
				);
	}

}
