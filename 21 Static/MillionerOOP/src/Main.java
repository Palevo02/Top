import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }
}
class Game{
    User user = new User();
    int userInput;
    public void play(){


        Question [] questions = new Question[] {
                new Question("Кто был первым человеком в космосе?",
                        new String [] {"Юрий Гагарин","Иосиф Сталин","Нил Армстронг","Евгений Леонов"}, 1),
                new Question("Какая страна является самой большой в мире?",
                        new String[] {"США","Великобритания","Россия","Китай"},3),
                new Question("В какой день американцы празднуют День Независимости?",
                        new String[]{"23 Февраля","20 Августа","4 Июля","8 Марта"},3),
                new Question("Какой цвет получится если смешать красный и синий?",
                        new String[]{"Бирюзовый","Оранжевый","Зеленый","Фиолетовый"},4),
                new Question("Сколько будет 2+2*2?",
                        new String[]{"6","8","2","4"},1)};

        while(true){
            System.out.println("Добро пожаловать в игру! У вас есть 3 подсказки: 50/50 , Помощь зала и Звонок другу." +
                    "\nИх нельзя использовать на последнем вопросе" +
                    "\nЧтобы использовать подсказку выберите 0" );
            for (int i = 0; i < questions.length; i++) {
                if(i == questions.length -1)
                    System.out.println("Обратите внимание что это последний вопрос. \nПодсказки больше недоступны");
                questions[i].printQuestion();
                System.out.println("\nВаш выбор: ");
                userInput = user.userInput(0,4);
                if(userInput == 0){
                    questions[i].choiceClue(user, i, questions.length);
                    userInput  = user.userInput(1,4);
                } if(questions[i].cheakAnswer(userInput)){
                    System.out.println("Ответ верный");
                    user.setScore(user.getScore()+((i+1)*100));
                    if(i == questions.length -1){
                        user.setScore(user.getScore()+1000);
                        printEnd();
                    }
                } else {
                    System.out.println("Ответ неверный! \nПравильный ответ: " + questions[i].getCorrectAnswer());
                    printEnd();

                    if(userInput== 0){
                        return;
                    } else if (userInput == 1 ){
                        break;
                    }

                }
            }
        }

    }
    void printEnd(){
        user.setFiftyFifty(true);
        user.setCallFriend(true);
        user.setHelpHall(true);
        System.out.println("Ваш счёт: " +user.getScore()+
                "\nВы хотите прекратить игру?  0 - Закончить игру / 1 - Продолжить игру");
        userInput = user.userInput(0,1);
    }
}
class Question{
    private String question;
    private String [] answers;
    private int correctAnswer;
    Random rand = new Random();
    int userInput = 0;


    public Question(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public void printQuestion(){
        System.out.println(this.question + "\nВарианты ответа: ");
        for (int i = 0; i < answers.length; i++) {
            System.out.print(i+1 +") "+ answers[i] + " ");
        }
    }
    public boolean cheakAnswer(int answer){
        if(answer == this.correctAnswer){
            return true;
        } else {
            return false;
        }
    }
    public void choiceClue(User user,int count, int size){
        if(count < size-1){
            System.out.println("Ваши подсказки: \n1)50/50 = " + user.isFiftyFifty()+"\n2)Помощь зала = "+ user.isHelpHall()+
                    "\n3)Звонок другу = " + user.isCallFriend() + "\n0) Отказаться от подсказки на этом ходу ");
            while (true){
                userInput = user.userInput(0,3);
                switch (userInput){
                    case 0:
                        printQuestion();
                        return;
                    case 1: fiftyFifty(user);
                        return;
                    case 2: helpHall(user);
                        return;
                    case 3: callFriend(user);
                        return;
                }
            }
        }   else {
            System.out.println("Подсказки недоступны");
            printQuestion();
        }
    }
    public void choiceClue(User user){
            System.out.println("Ваши подсказки: \n1)50/50 = " + user.isFiftyFifty()+"\n2)Помощь зала = "+ user.isHelpHall()+
                    "\n3)Звонок другу = " + user.isCallFriend() + "\n0) Отказаться от подсказки на этом ходу ");
            while (true){
                userInput = user.userInput(0,3);
                switch (userInput){
                    case 0:
                        printQuestion();
                        return;
                    case 1: fiftyFifty(user);
                        return;
                    case 2: helpHall(user);
                        return;
                    case 3: callFriend(user);
                        return;
                }
            }
    }
    public void fiftyFifty(User user){
        if(user.isFiftyFifty()){
            user.setFiftyFifty(false);
            int falseAnswer = 0;
            falseAnswer = rand.nextInt(4)+1;
            while(falseAnswer == correctAnswer){
                falseAnswer = rand.nextInt(4)+1;
            }
            if(rand.nextBoolean()){
                System.out.println("\nПодсказка 50/50:" +
                        "\nОставшиеся варианты ответа: " +correctAnswer + ") " +answers[correctAnswer-1]  +
                        " и " + falseAnswer + ") "+ answers[falseAnswer-1]);
            } else {
                System.out.println("\nПодсказка 50/50:" +
                        "\nОставшиеся варианты ответа: " + falseAnswer + ") "+ answers[falseAnswer-1] +
                        " и " + correctAnswer +") "+ answers[correctAnswer-1]);
            }
        } else {
            System.out.println("Подсказка уже использована");
            choiceClue(user);
        }
    }
    public void helpHall(User user){
        if(user.isHelpHall()){
            user.setHelpHall(false);
            int falseAnswer = rand.nextInt(4)+1;
            if(rand.nextBoolean()){
                System.out.println("Зал кричит: \"" + correctAnswer + " " + answers[correctAnswer-1] + "\" \nА каков будет ваш ответ?");
            } else {
                System.out.println("Зал кричит: \"" + falseAnswer + " " + answers[falseAnswer-1] + "\" \nА каков будет ваш ответ?");
            }
        } else {
            System.out.println("Подсказка уже использована");
            choiceClue(user);
        }
    }
    public void callFriend(User user){
        if(user.isCallFriend()){
            user.setCallFriend(false);
            int falseAnswer = rand.nextInt(4)+1;
            if(rand.nextBoolean()){
                System.out.println("Ваш друг говорит что это: \"" + correctAnswer + " " + answers[correctAnswer-1] + "\" \nА каков будет ваш ответ?");
            } else {
                System.out.println("Ваш друг говорит что это: \"" + falseAnswer + " " + answers[falseAnswer-1] + "\" \nА каков будет ваш ответ?");
            }
        } else {
            System.out.println("Подсказка уже использована");
            choiceClue(user);
        }
    }
}

class User {
    private int userInput;
    private int Score;
    private boolean fiftyFifty = true;
    private boolean helpHall = true;
    private boolean callFriend = true;
    Scanner scanner = new Scanner(System.in);

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public boolean isFiftyFifty() {
        return fiftyFifty;
    }

    public void setFiftyFifty(boolean fiftyFifty) {
        this.fiftyFifty = fiftyFifty;
    }

    public boolean isHelpHall() {
        return helpHall;
    }

    public void setHelpHall(boolean helpHall) {
        this.helpHall = helpHall;
    }

    public boolean isCallFriend() {
        return callFriend;
    }

    public void setCallFriend(boolean callFriend) {
        this.callFriend = callFriend;
    }

    public int userInput(int min, int max){
        while (true) {
                try{
                    userInput = Integer.parseInt(scanner.nextLine());
                    if ( userInput >= min && userInput <= max  )
                    return userInput;
                    else System.err.println("Ваше число больше или меньше кол-ва ответов");
                }catch (Exception ex){
                    System.err.println("Неправильный формат ответа");
                }
        }
    }
}