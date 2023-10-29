import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int homework = 0;
        int userNumber1 = 0;
        int userNumber2 = 0;
        int userNumber3 = 0;
        int number = 0;
        int userInputNumber = 0;
        System.out.print("Домашнее задание на знание if-else.\n Выберите работу (1-4): ");
        homework = scanner.nextInt();
        if(homework == 1) {
            System.out.print("Введите число от 1 до 5 :");
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Большой палец");
            } else if (userInput == 2) {
                System.out.println("Указательный палец");
            } else if (userInput == 3) {
                System.out.println("Средний палец");
            } else if (userInput == 4) {
                System.out.println("Безымянный палец");
            } else if (userInput == 5) {
                System.out.println("Мизинец");
            } else {
                System.out.println("Такого пальца мы не знаем :(");
            }
        } else if (homework == 2) {

            System.out.print("Введите первое число: ");
            userNumber1 = scanner.nextInt();
            System.out.print("Введите второе число: ");
            userNumber2 = scanner.nextInt();
            number = userNumber1 * userNumber2;
            System.out.print("Введите произведение чисел: " + userNumber1 + " и " + userNumber2 + " : ");
            userInputNumber = scanner.nextInt();
            if ( userInputNumber == number) {
                System.out.println("Вы ответили верно");
            } else {
                System.out.println("Вы ошиблись. Правильный ответ: " + number);
            }
        } else if (homework == 3 ){
            System.out.print("Введите первое число: ");
            userNumber1 = scanner.nextInt();
            System.out.print("Введите второе число: ");
            userNumber2 = scanner.nextInt();
            System.out.print("Введите третье число: ");
            userNumber3 = scanner.nextInt();
            if (userNumber1 > userNumber2 && userNumber1 > userNumber3){
                System.out.println("Число " + userNumber1 + " самое большое!");
            } else if (userNumber2 > userNumber1 && userNumber2 > userNumber3) {
                System.out.println("Число " + userNumber2 + " самое большое!");
            } else if (userNumber3 > userNumber1 && userNumber3 > userNumber2) {
                System.out.println("Число " + userNumber3 + " самое большое!");
            } else {
                System.out.println("Ошибка ввода данных,возможно вы ввели равные числа");
            }
        } else if (homework == 4) {
            System.out.print("Введите первое число: ");
            userNumber1 = scanner.nextInt();
            System.out.print("Введите второе число: ");
            userNumber2 = scanner.nextInt();
            System.out.print("Введите третье число: ");
            userNumber3 = scanner.nextInt();
            if (userNumber1 !=userNumber2 && userNumber1 != userNumber3 && userNumber2 !=userNumber3){
                number = (userNumber1 + userNumber2 + userNumber3) / 3 ;
                System.out.println("Среднее трёх чисел : " + number);
            } else {
                System.out.println("Ошибка ввода данных,возможно вы ввели равные числа");
            }

        }
    }
}