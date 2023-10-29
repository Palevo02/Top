import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String [] questions = {
            "Кто был первым человеком в космосе?",
            "Какая страна является самой большой в мире?",
            "В какой день американцы празднуют День Независимости?",
            "Какой цвет получится если смешать красный и синий?",
            "Последний вопрос!Сколько будет 2+2*2?"};
    public static String [] answers = {"1)Юрий Гагарин","2)Иосиф Сталин","3)Нил Армстронг","4)Евгений Леонов",
        "1)США","2)Великобритания","3)Россия","4)Китай",
        "1)23 Февраля","2)20 Августа","3)4 Июля","4)8 Марта",
        "1)Бирюзовый","2)Оранжевый","3)Зеленый","4)Фиолетовый",
        "1)6","2)8","3)2","4)4"};
    public static int [] trueAnswers = {1,3,3,4,1};
    public static boolean fiftyFifty = true;
    public static boolean hallHelp = true;
    public static boolean friendCall = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print(scanner);

    }
    public static void print(Scanner scanner){
        boolean isTrue = false;
        int countAnswers = 0;
        int userInput = 0;
        System.out.println("Добрый день! Сыграйте и станьте МИЛЛИОНЕРОМ!!Ответьте правильно на 5 вопросов!" +
                "\nУ вас есть 3 подсказки: 50/50, Помощь зала и звонок другу." +
                "\nЧтобы воспользоваться подсказкой напишите 0 и выберите подсказку" +
                "\nПодсказкой нельзя пользоваться на последнем, Самом сложном вопросе!" +
                "\nПервый вопрос:"+
                "\n=====================================================================");
        while(true){
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                if ((fiftyFifty || hallHelp || friendCall) && i !=4){
                    System.out.println("Вы можете использовать подсказку. Напишите 0");
                } else {
                    System.out.println("Подсказки недоступны");
                }
                for (int j = countAnswers; j < countAnswers+4; j++) {
                    System.out.print(answers[j] + " ");
                }
                System.out.println();
                userInput = userInput(scanner, userInput,0,4);
                if(i != 4){
                    userInput = choiceClue(userInput,scanner,i);
                }
                if(userInput == trueAnswers[i]){
                    isTrue = true;
                    System.out.println("Ответ верный" +
                            "\n=====================================================================");
                } else {
                    isTrue = false;
                    System.out.println("Ответ неправильный. В этот раз вы не станете миллионером. Правильный ответ " +
                              answers[(trueAnswers[i]-1)+ countAnswers]);
                    return;
                }
                countAnswers+=4;
                if (isTrue && i ==4){
                    System.out.println("Поздравляем! Вы выиграли миллион !");
                    return;
                }
            }
        }
    }

    public static int choiceClue(int userInput, Scanner scanner, int i){
        if(userInput == 0) {

            System.out.println("Что вы выберите? Если вы не хотите ничего выбирать напишите 0");
            if (fiftyFifty == true) {
                System.out.println("1)У вас осталась 50/50");
            }
            if (hallHelp == true) {
                System.out.println("2)У вас осталась Помощь Зала");
            }
            if (friendCall == true) {
                System.out.println("3)У вас остался звонок другу");
            }
            userInput = userInput(scanner,userInput,0,3);
            if ( userInput == 1 && fiftyFifty == true){
                userInput = fiftyFifty(scanner, i, userInput);
                fiftyFifty = false;
            } else if ( userInput == 2 && hallHelp == true){
                userInput = hallHelp(scanner, userInput, i);
                hallHelp = false;
            }else if ( userInput == 3 && friendCall){
                userInput = callFriend(scanner, userInput, i);
                friendCall = false;
            } else if (userInput == 0){
                System.out.println("Ваш ответ?");
                userInput = scanner.nextInt();
            }

        }
        return userInput;
    }
    public static int fiftyFifty(Scanner scanner, int i, int userInput){
        int rnd = getRandomNumberUsingNextInt(1,5);
        while(rnd == trueAnswers[i]){
            rnd= getRandomNumberUsingNextInt(1,5);
        }
        System.out.println("Вы выбрали подсказку 50 на 50! \nПравильный ответ: " +
                rnd + " или " + trueAnswers[i] + "\nА каков будет ваш ответ? ");
        userInput = userInput(scanner,userInput,1,4);
        return  userInput;
    }
    public static int hallHelp(Scanner scanner, int userInput, int i){
        System.out.println("Зал кричит: " + getRandomNumberUsingNextInt(trueAnswers[i], 5) + " Прислушаетесь ли вы к их ответу?");
        userInput = userInput(scanner,userInput,1,4);
        return userInput;
    }
    public static int callFriend(Scanner scanner, int userInput, int i){
        System.out.println("Вы звоните другу... Ваш лучший друг Алёша: Я уверен что это " +
                getRandomNumberUsingNextInt(trueAnswers[i], 5) +
                "Прислушаетесь ли вы к его совету?");
        userInput = userInput(scanner,userInput,1,4);
        return userInput;
    }
    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
  // public static int userInput(Scanner scanner, int userInput, int answerMinOptions, int answerMaxOptions){
  //     while(true){
  //         userInput = scanner.nextInt();
  //         if(userInput <=answerMaxOptions && userInput >= answerMinOptions){
  //             return userInput;
  //         } else {
  //             System.out.println("Введено некоректное значение. Повторите попытку");
  //         }
  //     }
  // }
    public static int userInput(Scanner scanner, int userInput,int answerMinOptions,int answerMaxOptions){
       while(true){
           try{
               userInput = Integer.parseInt(scanner.nextLine());
               if(userInput <=answerMaxOptions && userInput >= answerMinOptions){
                   return userInput;
               } else {
                   System.err.println("Число вне диапозона.Введите число");
               }
           } catch (NumberFormatException e){
               System.err.println("Некоректнный формат числа.Введите число");
           }
       }
    }

}