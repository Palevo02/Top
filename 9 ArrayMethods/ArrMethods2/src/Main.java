import java.util.Scanner;

public class Main {
    /*  m.replaceAll(oldElement,newElement)  void    - заменяет все числа oldElement, на newElement
    m.replace(oldElement,newElement)     void    - заменяет первое число oldElement, на newElement
    m.removeAll(element)                 void    - удаляет все числа равные element
    m.reverse()                          void    - переворачивает массив наоборот
    m.AddStart(element)                  void    - добовляет в начало массива
    m.AddEnd(element)                    void    - добовляет в конец массива

    arr [1,2,3,4,5,6,2]
 */
    public static int [] arr = new int []{1,2,3,4,5,6,2};
    public static void main(String[] args) {

        replaceAll( 2, 1);
        print();
        replace(1,2);
        print();
        removeAll(2);
        print();
        reverse();
        print();
        addStart(55);
        print();
        addEnd(55);
        print();
    }

    public static void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void replaceAll (int oldElement, int newElement){
        //m.replaceAll(oldElement,newElement) void    - заменяет все числа oldElement, на newElement
        for(int i = 0; i < arr.length; i++){
            if(oldElement == arr [i]){
                arr[i] = newElement;
            }
        }
    }
    public static void replace(int oldElement, int newElement){
        //m.replace(oldElement,newElement)     void    - заменяет первое число oldElement, на newElement
        for (int i = 0; i < arr.length; i++){
            if(oldElement == arr[i]){
                arr[i] = newElement;
                return;
            }
        }
    }
    public static void removeAll(int element){
        //m.removeAll(element)                 void    - удаляет все числа равные element
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(element == arr[i]){
                count++;
            }
        }
        int []newArr = new int [arr.length-count];
        for(int i = 0, j = 0; i < arr.length; i++){
            if(element != arr[i] && j < newArr.length){
                newArr[j] = arr[i];
                j++;
            }
        }
        arr = newArr;
    }

    public static void reverse(){
        //m.reverse()                          void    - переворачивает массив наоборот
        int [] newArr = new int [arr.length];
        for (int i = arr.length-1, j = 0; i >= 0; i--, j++) {
            newArr[j] = arr[i];
        }
        arr = newArr;
    }

    public static void addStart(int element){
        //m.AddStart(element)                  void    - добовляет в начало массива
        int [] newArr = new int [arr.length+1];
        newArr[0] = element;
        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            newArr[j] = arr[i];
        }
        arr = newArr;
    }

    public static void addEnd(int element){
        //m.AddEnd(element)                    void    - добовляет в конец массива
        int [] newArr = new int [arr.length+1];
        newArr[newArr.length-1] = element;
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

}