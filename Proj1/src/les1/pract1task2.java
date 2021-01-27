package les1;
import javax.swing.JOptionPane;

//Даны три числа. Увеличьте первое число в два раза, второе число уменьшите на 3, третье число возведите в квадрат и затем найдите сумму новых трех чисел.

public class Pract1task2 {

	public static void main(String[] args) {
        Float a, b, c;
        a = Float.parseFloat(JOptionPane.showInputDialog("Введите значение #1 (a): "));
        b = Float.parseFloat(JOptionPane.showInputDialog("Введите значение #2 (b): "));
        c = Float.parseFloat(JOptionPane.showInputDialog("Введите значение #3 (c): "));
        
        JOptionPane.showMessageDialog(null, "a * 2 = " + a*2 + "\nb / 3 = " + b/3 + "\nc^2 = " + c*c + "\n(a * 2) + (b / 3) + c^2 = " + (a*2+b/3+c*c));
	}

}