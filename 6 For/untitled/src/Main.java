import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length = 0;
        int height = 0;
        int user = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Домашнее задание , выберите часть (1-2): ");
        user = scanner.nextInt();
        if(user == 1) {
            System.out.print("Введите длину стороны квадрата: ");
            length = scanner.nextInt();
            for (int i = 0; i < length; i++) {
                System.out.println("");
                for (int z = 0; z < length; z++) {
                    System.out.print("*");
                }
            }
        } else if (user == 2){
            System.out.print("Введите длину : ");
            length = scanner.nextInt();
            System.out.print("Введите высоту : ");
            height = scanner.nextInt();
            for (int i = 0; i < height; i++) {
                System.out.println("");
                for (int z = 0; z < length; z++) {
                    System.out.print("*");
                }
            }
        }
    }
}