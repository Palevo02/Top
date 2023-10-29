import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //m.size()           int     - размер массива
    //m.get(index)       int     - возращает елемент по индексу
    //m.remove(index)    int     - возращает удаляемое число
    //m.contains(value)  boolean - true если value имееться иначе false
    //m.clear()          void    - удаляет все элементы в массиве
    public static void main(String[] args) {
        int[] arr = {22,66,33,77,-5,234,12,500,-99,-564};
        Scanner scanner = new Scanner(System.in);
        menu(arr, scanner);


    }

    public static void menu(int[] arr, Scanner scanner){
        int userInput = 0;
        System.out.println("(1)m.size() = " + size(arr) );
        System.out.print("Введите индекс: ");
        userInput = scanner.nextInt();
        System.out.println("(2)m.get(index) = " + get(arr,userInput));
        System.out.println("(3)m.remove(index) = " + remove(arr, userInput));
        System.out.print("Введите значение(value)");
        userInput = scanner.nextInt();
        System.out.println("(4)m.contains(value) = " + contains(arr, userInput));

    }
    public static int size(int[] arr){
        //m.size()           int     - размер массива
        return arr.length;
    }

    public static int get(int [] arr, int index){
        //m.get(index)       int     - возращает елемент по индексу
        if (index > 0 && index<arr.length-1){
            return arr[index];
        }else{
            System.out.println("Некорекктный индекс");
            return -1;
        }
    }

    public static int remove (int[] arr, int index){
        //m.remove(index)    int     - возращает удаляемое число

        if(index > 0 && index<arr.length-1){
            int [] newArr = new int[arr.length-1];
            int removeNumber = arr[index];
            for (int i = 0, j = 0; j < newArr.length;) {
                if(i == index){
                    i++;
                } else{
                    newArr[j] = arr[i];
                    j++;
                    i++;
                }
            }
            arr = newArr;
            return removeNumber;
        } else{
            System.out.println("Неккоректный индекс");
            return -1;
        }

    }
    public static boolean contains(int [] arr, int value){
        //m.contains(value)  boolean - true если value имееться иначе false
        for (int i = 0; i < arr.length; i++){
            if ( arr[i] == value ){
                return true;
            }
        }
        return false;
    }
    public static void clear (int [] arr){
        //m.clear()          void    - удаляет все элементы в массиве
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        
    }

}