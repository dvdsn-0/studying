package les1;
import javax.swing.JOptionPane;

/*
Объявить две целочисленные переменные «a» и «b» и задать им произвольные начальные значения. Затем написать скрипт, который работает по следующему принципу:
	если $a и $b положительные, вывести их разность;
	если $а и $b отрицательные, вывести их произведение;
	если $а и $b разных знаков, вывести их сумму;
*/

public class Pract3task1 {
	public static void main(String[] args) {
		Integer a, b;
		a = Integer.parseInt(JOptionPane.showInputDialog("Первое значение (a): "));
		b = Integer.parseInt(JOptionPane.showInputDialog("Первое значение (b): "));
		if (a > 0 && b > 0) //Оба положительные
		{
			JOptionPane.showMessageDialog(null, "a - b = " + (a-b));
		}
		if (a < 0 && b < 0) //Оба отрицательные
		{
			JOptionPane.showMessageDialog(null, "a * b = " + (a*b));
		}
		if ((a > 0 && b < 0) || (a < 0 && b > 0)) //Разных знаков
		{
			JOptionPane.showMessageDialog(null, "a + b = " + (a+b));
		}
	}

}
