import java.util.Scanner;

public class Main {
    public static int [][] arr = {{0,0,0,0,0,0,0,0,0}, {1,2,3,4,5,6,7,8,9}};
    public static int moves = 0;
    public static boolean isWinOne = false;
    public static boolean isWinTwo = false;
    // 0 никто не ходил, 1 ходил первый игрок,2 ходил второй игрок
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(!isWinOne && !isWinTwo){
            print();
            System.out.println("Ход первого игрока");
            inputGamer(scanner, 1);
            moves++;
            if(moves >=5){
                break;
            }
            System.out.println("Ход второго игрока");
            inputGamer(scanner,2);
            isWinOne = checkWin(1);
            isWinTwo = checkWin(2);
        }
        print();
        whoWin();
    //    for (int i = 0; i < arr.length; i++) {
    //        for (int j = 0; j < arr[i].length; j++) {
    //            System.out.print(arr[i][j]);
    //        }
    //        System.out.println();
    //    }
    }
    public static void print(){
        int num = 8;
        int count = 0;
        for (int i = 1; i < num; i++) {
            for (int j = 1; j < num; j++) {
                if (i%2 != 0 || j%2 != 0){
                    System.out.print('=');
                }else if(arr[0][count]==0){
                    System.out.print(arr[1][count]);
                    count++;
                }else if(arr[0][count]==1){
                    System.out.print('X');
                    count++;
                }else if(arr[0][count]==2){
                    System.out.print('O');
                    count++;
                }

            }
            System.out.println();
        }
    }
    public static void inputGamer(Scanner scanner, int numGamer) {
        int input = 0;
        while(true){
            System.out.println("Какую клетку вы хотите занять?");
            input = scanner.nextInt();
            if(input > 0 && input < 10 && arr[0][input-1] == 0 ){
                System.out.println("Вы заняли клетку " + input);
                arr[0][input-1] = numGamer;
                break;
            } else {
                System.out.println("Эту клетку занять нельзя");
            }
        }
    }
    public static boolean checkWin(int numGamer){
        String text = "Три фигуры выстроились в ряд";
        // проверка победы завязанных на 1 клетке
        if(arr[0][0] == numGamer){
            if(arr[0][1] == numGamer){
                if(arr[0][2] == numGamer){
                    System.out.println(text);// победа 1-2-3
                    return true;
                }
            }
            if(arr[0][3] == numGamer){
                if(arr[0][6]== numGamer){
                    System.out.println(text);// победа 1-4-7
                    return true;
                }
            }
            if(arr[0][4] == numGamer){
                if(arr[0][8] == numGamer){
                    System.out.println(text); // победа 1-5-9
                    return true;
                }
            }
        }

        // проверка побед завязанных на 5 клетке
        if (arr[0][4] == numGamer){
            if(arr[0][1] == numGamer){
                if(arr[0][7] == numGamer){
                    System.out.println(text); // победа 2-5-8
                    return true;
                }
            }
            if(arr[0][3] == numGamer){
                if(arr[0][5] == numGamer){
                    System.out.println(text); // победа 4-5-6
                    return true;
                }
            }
            if (arr[0][2] == numGamer){
                if(arr[0][6] == numGamer){
                    System.out.println(text); // победа 3-5-7
                    return true;
                }
            }
        }

        // проверка побед завязанных на 9 клетке
        if(arr[0][8]== numGamer){
            if(arr[0][7]== numGamer){
                if(arr[0][6]== numGamer){
                    System.out.println(text); // победа 7-8-9
                    return true;
                }
            }
            if(arr[0][5] == numGamer){
                if(arr[0][2] == numGamer){
                    System.out.println(text); // победа 3-6-9
                    return true;
                }
            }
        }
        return false;
    }
    public static void whoWin(){
        if(isWinOne && isWinTwo ){
            System.out.println("Ничья");
        } else if (isWinOne) {
            System.out.println("Выиграл первый игрок");
        } else if (isWinTwo){
            System.out.println("Выиграл второй игрок");
        } else {
            System.out.println("Ничья");
        }
    }
}