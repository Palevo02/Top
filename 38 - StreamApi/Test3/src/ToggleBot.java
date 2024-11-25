import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;

public class ToggleBot {

    private static volatile boolean running = true;

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        robot.setAutoDelay(40);

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                    toggleRunning();
                }
            }
        });

        while (true) {
            if (running) {
                // Здесь выполняется сканирование экрана или другие задачи, если программа включена
                Logic();
            } else {
                // Если программа отключена

            }
        }
    }

    public static void toggleRunning() {
        running = !running;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    private static boolean isSimilarColor(Color c1, Color c2, int tolerance) {
        int rDist = Math.abs(c1.getRed() - c2.getRed());
        int gDist = Math.abs(c1.getGreen() - c2.getGreen());
        int bDist = Math.abs(c1.getBlue() - c2.getBlue());
        return rDist <= tolerance && gDist <= tolerance && bDist <= tolerance;
    }


    public static void Logic() throws AWTException {
        Robot robot = new Robot();

        int x = 100;
        int y = 100;

        List<Pair<Color, Integer>> targetColors = new ArrayList<>();
        //targetColors.add(new Pair<>(new Color(247, 244, 205), 10)); // красный цвет с высоким приоритетом
        targetColors.add(new Pair<>(new Color(255, 123, 36), 9)); // красный цвет с высоким приоритетом
        targetColors.add(new Pair<>(new Color(93, 236, 245), 2)); // зеленый цвет с средним приоритетом
        targetColors.add(new Pair<>(new Color(0, 0, 255), 1)); // синий цвет с низким приоритетом

        targetColors.sort(Comparator.comparing(Pair::getValue)); // сортируем по приоритету


            BufferedImage screenCapture = robot.createScreenCapture(new java.awt.Rectangle(x, y, 100, 100));

            for (int i = 0; i < screenCapture.getWidth(); i++) {
                for (int j = 0; j < screenCapture.getHeight(); j++) {
                    Color pixelColor = new Color(screenCapture.getRGB(i, j));
                    for (Pair<Color, Integer> targetColor : targetColors) {
                        if (isSimilarColor(pixelColor, targetColor.getKey(), 35)) {
                            robot.mouseMove(x + i, y + j);
                            return;
                        }
                    }
                }
            }
            try {
                Thread.sleep(100); // Пауза на 0.1 секунды (100 миллисекунд)
            } catch (InterruptedException e) {
            }

    }
}