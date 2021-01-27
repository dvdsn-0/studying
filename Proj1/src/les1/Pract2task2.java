package les1;
import javax.swing.JOptionPane;

//Дано трехзначное число. Найти число десятков, число единиц и произведение цифр

public class Pract2task2 {

	public static void main(String[] args) {
		Integer x, a, b;
		x = Integer.parseInt(JOptionPane.showInputDialog("Введите трехзначное число: "));
		a = x%10;
		b = (x/10)%10;
		JOptionPane.showMessageDialog(null, "Единицы: " + a + "\nДесятки: " + b + "\nИх произведение: " + a*b);
	}

}
