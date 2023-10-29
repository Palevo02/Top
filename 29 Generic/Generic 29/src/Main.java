


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//
class Person implements Printable {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class MyArrayInt{
    int[] arr;
    int size;
    int index;

    {
        arr =new int[10];
        index = 0;
    }

    public  void add(int a){
        arr[index++] = a;
    }

    public void print(){
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

//class MyArrayDouble{
//    double[] arr;
//    int size;
//    int index;
//
//    {
//        arr =new double[10];
//        index = 0;
//    }
//
//    public  void add(double a){
//        arr[index++] = a;
//    }
//
//    public void print(){
//        for (int i = 0; i < index; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
//}

interface Printable{

}
class MyArray<T extends Person & Printable> {
    T[] arr;
    int size;
    int index;

    {
        arr = (T[]) new Object[10];
        index = 0;
    }

    public  void add(T a){
        arr[index++] = a;
    }

    public void print(){
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class Math {
//    public static int sum(int a , int b){
//        return  a+b;
//    }
//    public static double sum(double a , double b){
//        return  a+b;
//    }

//    public  static  void print(int result){
//        System.out.println("Result = " + result);
//    }
//    public  static  void print(double result){
//        System.out.println("Result = " + result);
//    }
//    public  static  void print(String result){
//        System.out.println("Result = " + result);
//    }
//    public  static  void print(char result){
//        System.out.println("Result = " + result);
//    }
//    public  static  void print(Person result){
//        System.out.println("Result = " + result.name);
//    }

//    public  static  void print(Object result){
//      /// int num = (int) result;
//        System.out.println("Result = " + result);
//    }

//        public  static  void print(var result){
//        System.out.println("Result = " + result);
//    }

//    public static <T> void print(T result) {
//        System.out.println("Result = " + result);
//    }

//    public static <T> T sum(T a, T b) {
//        return a  + b;
//    }
}
//boxing and unboxing

class Student extends Person{

    public Student(String name) {
        super(name);
    }


}

interface MyFunctional{
    boolean test(int num);
}


interface Comparable{
    int compare(String a,String b);
}
//10-5 = 1
//5 -10=-1
// 5 =5=0
public class Main {

//    public static int sumAll(List<Integer> arr){
//        int sum = 0;
//        for (int num:arr) {
//            sum+=num;
//        }
//        return sum;
//    }
//
//    public static int sumAllCet(List<Integer> arr){
//        int sum = 0;
//        for (int num:arr) {
//            if (num%2==0)    sum+=num;
//        }
//        return sum;
//    }
//
//    public static int sumAllNeCet(List<Integer> arr){
//        int sum = 0;
//        for (int num:arr) {
//            if (num%2!=0)    sum+=num;
//        }
//        return sum;
//    }

//    public static int sumAll(List<Integer> arr , Predicate<Integer> predicate){
//
//    }

    public static int sumAll(List<Integer> arr,MyFunctional predicate1, MyFunctional predicate2){
        int sum = 0;
        for (int num:arr) {
            if (predicate1.test(num) && predicate2.test(num)){
                sum+=num;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.println(sumAll(arr,n -> n<5, n -> n>2));



        Comparable comparable = new Comparable() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        };
        System.out.println();
//     System.out.println(comparable.compare("bba","bab"));

//     Comparable comparable2 = (n1,n2)-> n2.compareTo(n1);

//     System.out.println(comparable2.compare("bba","bab"));

//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//
//        MyFunctional myFunctional = new MyFunctional() {
//            @Override
//            public boolean test(int num) {
//                if (num%2==0) return true;
//                else return false;
//            }
//        };
//
//        System.out.println(myFunctional.test(10));
////
////        System.out.println(10%2==0);
//
//        MyFunctional myFunctional2 = (n)->n%2==0;
//
//        System.out.println("Sum : " + sumAll(arr,myFunctional2));
//        System.out.println("Sum : " + sumAll(arr,myFunctional));
//        System.out.println("Sum : " + sumAll(arr,(n)->n%2==0));
//        System.out.println("Sum : " + sumAll(arr,f->f%2!=0));
//        System.out.println("Sum : " + sumAll(arr,n->n>3));
//        System.out.println("Sum : " + sumAll(arr,n->n!=3));
//        System.out.println("Sum : " + sumAll(arr,n->n!=-1));

//        MyArray<Student> arr2 = new MyArray<>();
//        MyArray<Person> arr = new MyArray<>();
//        arr.add(new Person("Farid"));
//        arr.add(new Person("Farid"));
//        arr.add(new Person("Farid"));
//        arr.add(new Person("Farid"));
//        arr.add(new Person("Farid"));
//        arr.add(new Person("Farid"));
//        arr.print();
//        MyArrayInt myArrayInt = new MyArrayInt();
//        myArrayInt.add(1);
//        myArrayInt.add(2);
//        myArrayInt.add(3);
//        myArrayInt.print();
//
//        MyArrayDouble myArrayDouble = new MyArrayDouble();
//        myArrayDouble.add(1.1);
//        myArrayDouble.add(2.2);
//        myArrayDouble.add(3.3);
//        myArrayDouble.print();

//        int a = 10;
//        Integer a = 10;
//        Integer b = new Integer(10);

//        int -> Integer
//        double -> Double
//        char -> Character
//        fload -> Float
//        long -> Long


//        ArrayList<double> arr = new ArrayList<>();

//var a = 'x';
//        Math.print(100);
//        Math.print(100.4);
//        Math.print("Farid");
//        Math.print('F');
//        Math.print(new Person("Farid"));
//
//      System.out.println("Sum : " + Math.sum(10,20));
//       System.out.println("Sum : " + Math.sum(10.4,20.3));
//      System.out.println("Sum : " + Math.sum(10,20.3));

    }
}