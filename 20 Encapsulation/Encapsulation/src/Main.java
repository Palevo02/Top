class Phone{
    private String number;
    private String model;
    private double weight;
    Phone(){
        this.number = "No number";
        this.model  = "No model";
        this.weight = 0;
    }
    Phone(String number, String model, double weight){
        this(number,model);
        this.weight = weight;
    }
    Phone(String number, String model){
        this.number = number;
        this.model = model;

    }
    public void info(){
        System.out.println( "Number: "+this.number +"\nmodel: "+ this.model +"\nweight: " + this.weight + "\n");
    }
    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }
    public void receiveCall(String name, String number){
        System.out.println("Звонит " + name + " " + number);
    }
    public void sendMessage(String... numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " , ");
        }
    }
    public void test(){
        if(this.number.equals("777777")){

        }
    }
    public String getNumber(){
        return this.number;
    }

    public void setNumber(String number) {
        if(number.matches("[0-9]+") && number.length()<16)
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight>0 && weight < 5)
        this.weight = weight;
    }
}


public class Main {
    public static void main(String[] args) {
        Phone samsung = new Phone("89877654321","SM-S918", 0.233);
        Phone iphone = new Phone("89877654322","iPhone 14", 0.240);
        Phone xiaomi = new Phone("89877654323","Redmi 12", 0.199);
        Phone poco = new Phone();

        samsung.info();
        iphone.info();
        xiaomi.info();
        poco.info();

        samsung.setNumber("89877654320");
        samsung.info();

        samsung.receiveCall("Анатолий");
        iphone.receiveCall("Степан");
        xiaomi.receiveCall("Генадий");

        samsung.receiveCall("Анатолий", "89877654328");
        iphone.receiveCall("Степан", "89877654324");
        xiaomi.receiveCall("Генадий", "89877654329");

        System.out.println("Номер телефона: "+ samsung.getNumber());
        System.out.println("Номер телефона: "+ iphone.getNumber());
        System.out.println("Номер телефона: "+ xiaomi.getNumber());
        samsung.sendMessage("89877654321","89877654322","89877654323");
    }
}
