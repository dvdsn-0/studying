package les1;
import javax.swing.JOptionPane;

//Дано два числа. Если хотя бы одно из них больше 30, то вывести yes, иначе no.

public class Pract3task2 {
	public static void main(String[] args) {
		Integer a, b;
		a = Integer.parseInt(JOptionPane.showInputDialog("Первое значение (a): "));
		b = Integer.parseInt(JOptionPane.showInputDialog("Первое значение (b): "));
		if (a > 30 || b > 30)
		{
			JOptionPane.showMessageDialog(null, "yes");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "no");
		}
	}

}