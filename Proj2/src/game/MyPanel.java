package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {
    int x = 395;//координата шапки по оси X
    int item1x = (int) (Math.random() * 800 + 50), item1y = -100;
    int item2x = (int) (Math.random() * 800 + 50), item2y = -400;
    int heartx = (int) (Math.random() * 800 + 50), hearty = -900;

    Image shapka, fon, item1, item2, heart1, heart2, heart3, heart4, heart5, heart6, heart, pauseimg;
    int slogn, lives, score; // Сложность, кол-во жизней, рейтинг
    Timer timerDraw;
    Boolean pause = false;

    public MyPanel(int s) throws IOException, FontFormatException {
        slogn = s;
        lives = 6 - slogn;
        shapka = ImageIO.read(getClass().getResource("./img/shapka.png"));
        fon = ImageIO.read(getClass().getResource("./img/fon.jpg"));
        item1 = ImageIO.read(getClass().getResource("./img/item1.png"));
        item2 = ImageIO.read(getClass().getResource("./img/item2.png"));
        pauseimg = ImageIO.read(getClass().getResource("./img/pause.png"));
        heart = ImageIO.read(getClass().getResource("./img/bigheart.png"));
        heart1 = ImageIO.read(getClass().getResource("./img/heart.png"));
        heart2 = heart1;
        heart3 = heart1;
        heart4 = heart1;
        heart5 = heart1;
        heart6 = heart1;



		timerDraw = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();//запускаем paintComponent, который отвечает за отображение элементов на фрейме
			}
		});
		timerDraw.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(fon, 0, 0, null);
        g.drawImage(item1, item1x, item1y, null);
        g.drawImage(item2, item2x, item2y, null);
        g.drawImage(heart, heartx, hearty, null);
        g.drawImage(shapka, x, 410, null);

        switch (lives) {
            case 6:
                g.drawImage(heart6, 210, 10, null);
            case 5:
                g.drawImage(heart5, 170, 10, null);
            case 4:
                g.drawImage(heart4, 130, 10, null);
            case 3:
                g.drawImage(heart3, 90, 10, null);
            case 2:
                g.drawImage(heart2, 50, 10, null);
            case 1:
                g.drawImage(heart1, 10, 10, null);
        }

        if (pause) {
            g.drawImage(pauseimg, 0, 0, null);
        }
    }

}