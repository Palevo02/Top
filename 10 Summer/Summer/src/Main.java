/*String

1) public static char charAt(int index)  - возвращает символ строки по указанному index-у
2) public static boolean equals(String str)- возвращает true если str == arr по значению
3) public static String toLowerCase()- возвращает string все символы в нижнем регистре
4) public static String toUpperCase()- возвращает string все символы в верхнем регистре
5) public static int indexOf(char c) - возвращает index первого вхождения в противном случаи -1
6) public static int indexOf(String c) - возвращает index первого вхождения в противном случаи -1
7) public static int indexOf (char c , int fromIndex) - возвращает index первого вхождения начиная с fromIndex в противном случаи -1
8) public static int lastIndexOf(char c) - возвращает index первого вхождения c конца в противном случаи -1
9) public static int lastIndexOf(String c) - возвращает index первого вхождения c конца  в противном случаи -1

10) public static String trim()- возвращает string удалив пробелы слева и справа
11) public static boolean startsWith(String str)- возвращает true если строка начинаеться на str в 12) противном случаи false
13) public static boolean endsWith(String str)- возвращает true если строка заканчиваеться на str в противном случаи false
14) public static boolean equalsIgnoreCase(String str)- возвращает true если строка ровна str не учитывая регистр
15) public static char[] toCharArray()- возвращает массив символов
*/


import java.rmi.server.ExportException;
import java.util.ArrayList;

public class Main {
    public static char[] arr = new char[0];

    public static int length(){
        return arr.length;
    }

    public static void change(String str){
        arr = str.toCharArray();
    }

    public static void main(String[] args) {
        String name = "Vladislav";
        String str = "la";
        char chr = 'd';
        change(name);
        print(name, str, chr);


    }

    public static void print(String name, String str, char chr){
        char [] newArr = toCharArray(name);
        try {
            System.out.println(charAt(5));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            System.out.println(equals(str));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            System.out.println(toLowerCase());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(toUpperCase());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(indexOf(chr));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(indexOf(str));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(indexOf(chr,3));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(lastIndexOf(chr));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(lastIndexOf(str));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(trim());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(startsWith(str));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(endsWith(str));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(equalsIgnoreCase(str));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static char charAt(int index) throws Exception{
        //возвращает символ строки по указанному index-у
        return arr[index];
    }

    public static boolean equals(String str) {
        //возвращает true если str == arr по значению
        try{

        }catch (Exception ex){

        }
        char[] strArr = new char[str.length()];
        strArr = str.toCharArray();
        boolean isCheak = false;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == strArr [0]){
                for(int j = 0, z = i; j < strArr.length; j++, z++){
                    if(strArr[j] == arr[z]){
                        isCheak = true;
                    } else {
                        isCheak = false;
                        break;
                    }
                    if(j == strArr.length-1 && isCheak){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String toLowerCase(){
        // возвращает string все символы в нижнем регистре
        char [] newArr = new char [arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 65 && arr[i] <= 90){
                newArr[i] = (char) (arr[i] +32);
            } else {
                newArr[i] = arr[i];
            }
        }
        String result = new String(newArr);
        return result;
    }

    public static String toUpperCase(){
        // возвращает string все символы в верхнем регистре
        char [] newArr = new char [arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 97 && arr[i] <= 122){
                newArr[i] = (char) (arr[i] -32);
            } else {
                newArr[i] = arr[i];
            }
        }
        String result = new String(newArr);
        return result;
    }

    public static int indexOf(char c){
        // - возвращает index первого вхождения в противном случаи -1
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(String c){
        //- возвращает index первого вхождения в противном случаи -1
        char [] newArr = c.toCharArray() ;
        boolean isCheak = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == newArr[0]){
                for( int z = 0, j = i; z< newArr.length;){
                    if (arr[j] == newArr[z]){
                        isCheak = true;
                        j++;
                        z++;
                    }
                    if(isCheak && z >= newArr.length){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOf (char c , int fromIndex){
        //- возвращает index первого вхождения начиная с fromIndex в противном случаи -1
        for (int i = fromIndex; i < arr.length; i++) {
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }
    public static int lastIndexOf(char c){
         // - возвращает index первого вхождения c конца в противном случаи -1
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }
    public static int lastIndexOf(String c){
        // - возвращает index первого вхождения c конца  в противном случаи -1
        char [] newArr = c.toCharArray();
        boolean isCheak = false;
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] == newArr [newArr.length-1]){
                for(int z = newArr.length-1, j = i; z>=0; ){
                    if (arr[j] == newArr[z]){
                        isCheak = true;
                        z--;
                        j--;
                    }
                    if(isCheak && z <= 0){
                        return  j;
                    }
                }
            }
        }
        return -1;
    }

    public static String trim(){
        //- возвращает string удалив пробелы слева и справа
        int space = 0;
        for (int i = 0; i< arr.length; i++){
            if(arr[i] == ' '){
                space++;
            }
        }
        char [] newArr = new char [arr.length - space];
        for (int i = 0, j = 0; i < arr.length; i++) {

            if(arr[i] != ' '){
                newArr[j] = arr[i];
                j++;
            }
        }
        String result = new String(newArr);
        return result;
    }

    public static boolean startsWith(String str){
        //- возвращает true если строка начинаеться на str в 12) противном случаи false
        boolean isCheak = false;
        char [] newArr = str.toCharArray();
        for (int i = 0; i < newArr.length; i++) {
            if(newArr[i] == arr[i]){
                isCheak = true;
            } else {
                return false;
            }
        }
        return isCheak;
    }
    public static boolean endsWith(String str){
    //- возвращает true если строка заканчиваеться на str в противном случаи false
        char [] newArr = str.toCharArray();
        boolean isCheak = false;
        for (int i = arr.length-1, j = newArr.length-1; i> (arr.length-newArr.length); i--, j--) {
            if( arr[i] == newArr[j]){
                isCheak = true;
            } else {
                return false;
            }
        }
        return isCheak;
    }
    public static boolean equalsIgnoreCase(String str){
        //- возвращает true если строка ровна str не учитывая регистр
        boolean isCheak = false;
        char [] newArr = toLowerCase().toCharArray();
        char [] arrStr = str.toLowerCase().toCharArray();

        for (int i = 0; i < newArr.length; i++) {
            if( newArr[i] == arrStr[0]){
                for (int j = 0, z = i; j < arrStr.length; ){
                    if(newArr[z] == arrStr[j]){
                        isCheak = true;
                        j++;
                        z++;
                    } else {
                        isCheak = false;
                        break;
                    }
                    if(j >= arrStr.length && isCheak){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static char[] toCharArray(String str){
        //- возвращает массив символов
        char [] newArr = new char[str.length()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = str.charAt(i);
        }
        return newArr;
    }

}