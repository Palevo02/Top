import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userNumber1;
        int userNumber2;
        int number;
        int userInputNumber;
        System.out.print("Введите первое число: ");
        userNumber1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        userNumber2 = scanner.nextInt();
        number = userNumber1 * userNumber2;
        System.out.println("Введите произведение чисел: " + userNumber1 + " и " + userNumber2 + " : ");
        userInputNumber = scanner.nextInt();
        if ( userInputNumber == number) {

        }
    }
}