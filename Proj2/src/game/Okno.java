package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.*;

public class Okno extends JFrame {
    static MyPanel panel;
    Timer timerItem;


    public Okno(int s) throws IOException, FontFormatException {
        setSize(916, 546);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Игра");
        panel = new MyPanel(s);
        getContentPane().add(panel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                //System.out.println(keyCode);
                if (keyCode == 27 && panel.pause == false) { //Нажали Esc
                    pause();
                } else if (keyCode == 27 && panel.pause == true) {
                    pause();
                }
                if (keyCode == 39 && panel.pause == false) {//нажали клавишу вправо
                    panel.x += 30;
                } else if (keyCode == 37 && panel.pause == false) {
                    panel.x -= 30;
                }
                if (panel.x > 900 && panel.pause == false) { // Шапка уехала вправо? Возвращаем слева
                    panel.x = -74;
                } else if (panel.x < -74 && panel.pause == false) { // И слева, направо
                    panel.x = 900;
                }
            }
        });
        setVisible(true);

        /**
         * Вывод количества очков (Score: )
         */
        Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("game/quantico.ttf"));
        JLabel htmlLabel = new JLabel();
        htmlLabel.setText("Score: " + panel.score);
        htmlLabel.setFont(font.deriveFont(38f));
        panel.add(htmlLabel);

        timerItem = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Задаем скорость падения предметов с зависимостью от сложности
                 */
                panel.item1y += panel.slogn;
                panel.item2y += panel.slogn;
                panel.hearty += panel.slogn;

                /**
                 * Сверяем условия падения/движения предметов
                 */
                // Падение предмета *баклажан*
                if (inShapka(panel.x, panel.item1x, panel.item1y)) {
                    panel.item1y = crdsRestY(); // Возвращаем предмет на старт (координата Y)
                    panel.item1x = crdsRestX(); // (координата X)
                    panel.score++;
                    htmlLabel.setText("Score: " + panel.score);
                } else if (panel.item1y > 520) { //Если не поймали шапкой
                    panel.item1y = crdsRestY(); // Возвращаем предмет на старт (координата Y)
                    panel.item1x = crdsRestX(); // (координата X)
                    panel.lives--;
                    System.out.println(panel.lives);
                }

                // Падение предмета *груша*
                if (inShapka(panel.x, panel.item2x, panel.item2y)) {
                    panel.item2y = crdsRestY(); // Возвращаем предмет на старт (координата Y)
                    panel.item2x = crdsRestX(); // (координата X)
                    panel.score++;
                    htmlLabel.setText("Score: " + panel.score);
                } else if (panel.item2y > 520) { //Если не поймали шапкой
                    panel.item2y = crdsRestY(); // Возвращаем предмет на старт (координата Y)
                    panel.item2x = crdsRestX(); // (координата X)
                    panel.lives--;
                    System.out.println(panel.lives);
                }

                // Падение предмета *сердце*
                if (inShapka(panel.x, panel.heartx, panel.hearty)) {
                    panel.hearty = -3000; // Возвращаем предмет на старт (координата Y)
                    panel.heartx = crdsRestX(); // (координата X)
                    panel.score++;
                    panel.lives++;
                    htmlLabel.setText("Score: " + panel.score);
                } else if (panel.hearty > 1000) { //Если не поймали шапкой
                    panel.hearty = crdsRestY(); // Возвращаем предмет на старт (координата Y)
                    panel.heartx = crdsRestX(); // (координата X)
                }

                if (!alive()) {
                    pause();
                    JOptionPane.showMessageDialog(null, "Вы проиграли!\nВаш счет: " + panel.score);
                }
            }
        });
        timerItem.start();
    }

    /**
     * Вызов паузы. Останавливаем/запускаем таймер timerItem
     */
    private void pause() {
        if (panel.pause) {
            panel.pause = false;
            timerItem.start();
        } else {
            panel.pause = true;
            timerItem.stop();
        }
    }

    /**
     * Проверяем упал ли предмед в шапку:
     *
     * @param int shapkax - Расположение шапки по X координате
     * @param int itemx - Расположение падающего предмета по X координате
     * @return boolean - Предмет залетел в шапку? true/false
     */
    private boolean inShapka(int shapkax, int itemx, int itemy) {
        if ((shapkax - 10) < itemx && itemx < (shapkax + 80) && itemy > 400) {
            return true;
        }
        return false;
    }

    /**
     * Проверям расстояние между предметами (что бы не было предметов летящих на одной высоте)
     *
     * @param int y - Принимаем расположение другого предмета по координате Y
     * @return boolean - Предмет достаточно далеко от точки старта? true/false
     */
    private boolean inRange(int y) {
        if (y > 100 && y < 300) {
            return true;
        }
        return false;
    }

    /**
     * Получаем стартовую координату Y для падающего предмета
     *
     * @return int = минус 250px от самого высокого предмета
     */
    private int crdsRestY() {
        Integer[] mas = {panel.item1y, panel.item2y};
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (min > mas[i]) {
                min = mas[i];
            }
        }
        return (min - 300);
    }

    /**
     * Получаем стартовую координату X для падающего предмета
     *
     * @return int координата Y
     */
    private int crdsRestX() {
        return ((int) (Math.random() * 790 + 50));
    }

    /**
     * Есть у нас уще жизни?
     *
     * @return boolean - Если 1 или более: true
     */
    private boolean alive() {
        if (panel.lives <= 0) {
            return false;
        }
        return true;
    }

}