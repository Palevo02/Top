import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userNumber1;
        int userNumber2;
        char userOperator;
        Scanner scanner = new Scanner(System.in);
        userNumber1 = userInputNumbers(scanner);//Ввод первого числа
        userOperator = userInputOperators(scanner);//Ввод оператора
        userNumber2 = userInputNumbers(scanner);//Ввод второго числа
        System.out.println(userNumber1 + " " + userOperator + " " + userNumber2 + " = " + mathLogic(userNumber1,userNumber2,userOperator) );
    }

    public static int userInputNumbers(Scanner scanner) {
        int userNumber;
        System.out.print("Введите число: ");
        userNumber = scanner.nextInt();
        return userNumber;

    }

    public static char userInputOperators(Scanner scanner) {
        char userOperator;
        while(true) {
            System.out.print("Введите действие(+ , - , * , /): ");
            userOperator = scanner.next().charAt(0);
            if (userOperator == '+' || userOperator == '-' || userOperator == '*' || userOperator == '/') {
                return userOperator;
            } else {
                System.out.println("Вы ввели неверное значение");
            }
        }
    }
    public static int mathLogic(int userNumber1, int userNumber2, char userOperator){
        int result;
        if(userOperator == '+'){
            result = userNumber1 + userNumber2;
            return result;
        } else if (userOperator == '-'){
            result = userNumber1 - userNumber2;
            return result;
        } else if (userOperator == '/'){
            result = userNumber1 / userNumber2;
            return result;
        } else if (userOperator == '*'){
            result = userNumber1 * userNumber2;
            return result;
        } else {
            System.out.println("Неизвестная ошибка");
            return 0;
        }
    }
}


