import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
    public static double scale = Math.pow(10, 2);
    public static void main(String[] args) {
        Animals cat;
        cat = new Animals();
        cat.type = "Кот";
        cat.name = "Барон";
        cat.weight = 5;
        cat.age = 4;
        cat.color = "Рыжий";
        cat.voice = "Мяу";
        cat.voice();
        cat.play();
        info(cat);

        Animals parrot = new Animals();
        parrot.type = "Попугай";
        parrot.name = "Попуг";
        parrot.weight = 1;
        parrot.age = 3;
        parrot.color = "Жёлтый";
        parrot.voice = "Чик-Чирик";
        parrot.voice();
        parrot.voice();
        info(parrot);

        Animals dog = new Animals();
        dog.type = "Собака";
        dog.name = "Джульета";
        dog.weight =120;
        dog.age =  6;
        dog.color = "Чёрный";
        dog.voice = "Вуф";
        dog.voice();
        dog.play();
        info(dog);
    }

    static class Animals{
        public String type;
        public String name;
        public double weight;
        public int age;
        public String color;
        public String voice;

        public void eat(){
            weight =Math.ceil((weight+(weight*0.05))*scale)/scale ;
        }
        public void voice(){
            System.out.println(voice + " " + voice);
        }
        public void play (){
            weight =Math.ceil((weight-(weight*0.05))*scale)/scale ;
        }
    }
    public static void info(Animals animal){
        System.out.println(animal.type + "\n" + animal.name + "\n" + animal.weight + "\n" + animal.age +
                "\n" + animal.color + "\n" + animal.voice);
    }
}