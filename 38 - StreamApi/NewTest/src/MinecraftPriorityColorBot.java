import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.*;

public class MinecraftPriorityColorBot {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        int x = 100;
        int y = 100;

        List<Pair<Color, Integer>> targetColors = new ArrayList<>();
        targetColors.add(new Pair<>(new Color(255, 0, 0), 3)); // красный цвет с высоким приоритетом
        targetColors.add(new Pair<>(new Color(0, 255, 0), 2)); // зеленый цвет с средним приоритетом
        targetColors.add(new Pair<>(new Color(0, 0, 255), 1)); // синий цвет с низким приоритетом

        targetColors.sort(Comparator.comparing(Pair::getValue)); // сортируем по приоритету

        while (true) {
            BufferedImage screenCapture = robot.createScreenCapture(new java.awt.Rectangle(x, y, 100, 100));

            for (int i = 0; i < screenCapture.getWidth(); i++) {
                for (int j = 0; j < screenCapture.getHeight(); j++) {
                    Color pixelColor = new Color(screenCapture.getRGB(i, j));
                    for (Pair<Color, Integer> targetColor : targetColors) {
                        if (isSimilarColor(pixelColor, targetColor.getKey(), 20)) {
                            robot.mouseMove(x + i, y + j);
                            return;
                        }
                    }
                }
            }
            try {
                Thread.sleep(100); // Пауза на 0.1 секунды (100 миллисекунд)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isSimilarColor(Color c1, Color c2, int tolerance) {
        int rDist = Math.abs(c1.getRed() - c2.getRed());
        int gDist = Math.abs(c1.getGreen() - c2.getGreen());
        int bDist = Math.abs(c1.getBlue() - c2.getBlue());
        return rDist <= tolerance && gDist <= tolerance && bDist <= tolerance;
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
}