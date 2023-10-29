import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* int[] arr = {22,66,33,77,-5,234,12,500,-99,-564

                1)- Сортировка ->
                2)- Сортировка <-
                3)Поиск элемента в массиве с начало возращает сам элемент иначе -1
                4)Поиск элемента в массиве с конца возращает сам элемент иначе -1
                5)Поиск элемента в массиве с начало возращает индекс элемента  иначе -1
                6)Поиск элемента в массиве с конца возращает индекс элемента  иначе -1
                7)Поиск элемента в массиве возращает true если элемент есть в массиве иначе false


                **
                Задание
                У вас есть 2 массива
                int[] arr = {1,4,5,7,8,12,14,15,15,15,15,900}
                int[] arr2 = {-1,0,9,9,9,9,10,15,921}

                result = {-1,0,1,4,5,7,8,9,9,9,9,10,12,14,15,15,15,15,15,900,921}

                Функция которая принимает 2 массива и возращает ноовый массив.Который обединяет 2 массива
                --Нельзя все собрать в 1 массив а потом отсартировать

    */
        int[] arr = {22,66,33,77,-5,234,12,500,-99,-564};
        int[] arr2 = {1,4,5,7,8,12,14,15,15,15,15,900};
        int[] arr3 = {-1,0,9,9,9,9,10,15,921};
        Scanner scanner = new Scanner(System.in);
        menu(scanner, arr, arr2, arr3);
    }

    public static void menu(Scanner scanner, int [] arr, int[] arr2, int[] arr3){
        int userInput;
        while(true){
            System.out.print("Добрый день ознакомьтесь с функционалом: \n" +
                    "(1) Сортировка ->\n" +
                    "(2) Сортировка <-\n" +
                    "(3)Поиск элемента в массиве с начала, возращает сам элемент иначе -1\n" +
                    "(4)Поиск элемента в массиве с конца, возращает сам элемент иначе -1\n" +
                    "(5)Поиск элемента в массиве с начала, возращает индекс элемента  иначе -1\n" +
                    "(6)Поиск элемента в массиве с конца, возращает индекс элемента  иначе -1\n" +
                    "(7)Поиск элемента в массиве возращает true если элемент есть в массиве иначе false\n" +
                    "(0)Выход из программы)\n" +
                    "Выберите действие : ");
            userInput = scanner.nextInt();
            switch (userInput){
                case 1:
                    printingArray(sortingLeftToRight(arr));
                break;
                case 2:
                    printingArray(sortingRighToLeft(arr));
                    break;
                case 3:
                    System.out.println(SearchElementAtFirst(scanner, arr));
                    break;
                case 4:
                    System.out.println(SearchElementFromTheEnd(scanner, arr));
                    break;
                case 5:
                    System.out.println(SearchIndexAtFirst(scanner, arr));
                    break;
                case 6:
                    System.out.println(SearchIndexFromTheEnd(scanner, arr));
                    break;
                case 7:
                    System.out.println(isElementInArray(scanner, arr));
                    break;
                case 8:
                    printingArray(twoArrayInOne(arr2,arr3));
                    break;
                case 0:
                    System.out.println("Прощайте");
                    return;

            }
        }


    }
    public static void printingArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }


    public static int[] sortingLeftToRight(int [] arr){
        //1)- Сортировка ->

        int value;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    value = arr[i];
                    arr[i] = arr[j];
                    arr[j] = value;
                }
            }
        }
        return arr;
    }

    public static int[] sortingRighToLeft(int [] arr){
        //2)- Сортировка <-
        int value;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]){
                    value = arr[i];
                    arr[i] = arr[j];
                    arr[j] = value;
                }
            }
        }
        return arr;
    }

    public static int SearchElementAtFirst(Scanner scanner, int arr[]){
       // 3)Поиск элемента в массиве с начало возращает сам элемент иначе -1

        System.out.println("Введите элемент который вы хотите найти: ");
        int userInput = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (userInput == arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int SearchElementFromTheEnd(Scanner scanner, int arr[]){
        //4)Поиск элемента в массиве с конца возращает сам элемент иначе -1
        System.out.println("Введите элемент который вы хотите найти: ");
        int userInput = scanner.nextInt();
        for (int i = arr.length-1; i >= 0; i--) {
            if (userInput == arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }
    public static int SearchIndexAtFirst(Scanner scanner, int [] arr){
        //  5)Поиск элемента в массиве с начало возращает индекс элемента  иначе -1

        System.out.println("Введите элемент, Индекс которого вы хотите найти: ");
        int userInput = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (userInput == arr[i]) {
                return i;
            }
        }
        return -1;
    }
    public static int SearchIndexFromTheEnd(Scanner scanner, int [] arr) {
        // 6)Поиск элемента в массиве с конца возращает индекс элемента  иначе -1
        System.out.println("Введите элемент, Индекс которого вы хотите найти: ");
        int userInput = scanner.nextInt();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (userInput == arr[i]) {
                return i;
            }
        }
        return -1;
    }
    public static boolean isElementInArray(Scanner scanner, int [] arr){
        // 7)Поиск элемента в массиве, возращает true если элемент есть в массиве, иначе false
        System.out.println("Введите элемент, наличие которого вы хотите проверить: ");
        int userInput = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (userInput == arr[i]) {
                return true;
            }
        }
        return false;
    }
    public static int[] twoArrayInOne(int [] arr, int [] arr2) {

        int[] newArr = new int [(arr.length) + (arr2.length)];

        for (int i = 0, j =0, z =0; i < arr.length || j< arr2.length ;  ) {
            if(i >= arr.length){
                newArr[z] = arr2[j];
                j++;
                z++;
                continue;
            }
            if (i< arr.length & arr[i] <= arr2[j] ){
                newArr[z] = arr[i];
                i++;
                z++;
            } else {
                newArr[z] = arr2[j];
                j++;
                z++;
            }
        }
        return newArr;
    }
}