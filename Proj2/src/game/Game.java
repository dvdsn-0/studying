package game;

import java.awt.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) throws IOException, FontFormatException {
		int s = Integer.parseInt(JOptionPane.showInputDialog("Введите сложность игры (1-5)\n" +
				"(влияет на количество жизней и скорость падения предметов)"));
		if(s >= 1 && s <= 5) {
			new Okno(s);
		}
		else {
			JOptionPane.showMessageDialog(null, "Вы ввели некорректно сложность игры!");
		}

	}

}
