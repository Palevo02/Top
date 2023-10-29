import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("Чтобы выйти введите 0 \nВведите выражение: ");
            String expression = scanner.nextLine();
            try{
                if (expression == "0"){
                    return;
                } else if ( expression.contains("+")){
                    String[] numbers = expression.split("\\+");
                    System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
                } else if ( expression.contains("-")){
                    String[] numbers = expression.split("\\-");
                    System.out.println(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]));
                } else if ( expression.contains("*")){
                    String[] numbers = expression.split("\\*");
                    System.out.println(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]));
                } else if ( expression.contains("/")){
                    String[] numbers = expression.split("/");
                    System.out.println(Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]));
                } else {
                    System.out.println("Неверное выражение");
                }
            }catch (Exception ex) {
                System.err.println("Неверное выражение");
            }
        }
    }
}