public class Main {


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setFoliar(true);
        tree.setAge(5);
        tree.setName("Дуб");
        tree.setHeight(5);
        Flower flower = new Flower();
        flower.setName("Фиалка");
        flower.setBudColor("жёлтый");
        flower.setAge(1);
        flower.setHeight(0.2);
        tree.grow();
        flower.grow();
    }
}

abstract class Plant {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void grow() {
        System.out.println(name + " Растёт - Растёт");
    }
}

class Tree extends Plant {
    double height;
    boolean isFoliar;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isFoliar() {
        return isFoliar;
    }

    public void setFoliar(boolean foliar) {
        isFoliar = foliar;
    }
}

class Flower extends Plant {
    double height;
    String budColor;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBudColor() {
        return budColor;
    }

    public void setBudColor(String budColor) {
        this.budColor = budColor;
    }
}