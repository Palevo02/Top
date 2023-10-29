public class Main {

//    public static int indexOf(char c , int fromIndex) - возвращает index первого вхождения начиная с fromIndex в противном случаи -1
//    public static int lastIndexOf(char c) - возвращает index первого вхождения c конца в противном случаи -1
//    public static int lastIndexOf(String c) - возвращает index первого вхождения c конца  в противном случаи -1
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
        char chr = 'a';
        change(name);
        System.out.println(indexOf(chr));
        System.out.println(lastIndexOf(chr));
        System.out.println(lastIndexOf(str));



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
}