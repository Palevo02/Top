import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            int count = 0;
            int countZ = 16;
            for (int i = 0; i < 8; i++) {

                for (int z = 0; z < countZ; z++) {
                    System.out.print(" ");
                }
                for (int c = 0; c <= count; c++) {
                    System.out.print("*");

                }
                for (int v = 0; v < countZ; v++) {
                    System.out.print(" ");
                }
                System.out.println(" ");
                count += 2;
                countZ -= 1;
            }
        }
        {
            int count = 0;
            int countZ = 16;
            for (int i = 0; i < 7; i++) {

                for (int z = 0; z < 16; z++) {
                    System.out.print(" ");
                }
                for (int c = 0; c <= count; c++) {
                    System.out.print("*");

                }
                System.out.println(" ");
                count ++;
                countZ -= 1;
            }
        }
        {
            int count = 6;
            int countZ = 16;
            for (int i = 0; i < 7; i++) {

                for (int z = 0; z < 16; z++) {
                    System.out.print(" ");
                }
                for (int c = 0; c <= count; c++) {
                    System.out.print("*");

                }
                System.out.println(" ");
                count --;
                countZ -= 1;
            }
        }
        {
            int count = 8;
            int countZ = 16;
            for (int i = 0; i < count; i++) {

                for( int z = 0; z<countZ; z++){
                    System.out.print(" ");
                }
                System.out.print("*");

                System.out.println(" ");
                countZ++;
            }
        }
        {
            int count = 8;
            int countZ = 16;
            for (int i = 0; i < count; i++) {

                for( int z = 0; z<countZ; z++){
                    System.out.print(" ");
                }
                System.out.print("*");

                System.out.println(" ");
                countZ--;
            }
        }
        {
            int count = 8;
            int countY = 4;
            int countZ = 16;
            for (int i = 0; i < countY; i++) {

                for( int z = 0; z<countZ; z++){
                    System.out.print(" ");
                }
                for(int y = 0; y< count; y++)
                System.out.print("*");

                System.out.println(" ");

            }
        }
        {
            int count = 7;
            for(int i=0; i<count;i++){
                for(int z =0; z<count; z++){
                    if(i == 0 || i == count-1 || z == 0 || z == count -1){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
        {
            int countX = 7;
            int countY = 7;
            for(int i = 0; i<countY; i++){
                for(int x = 0; x < countX; x++){
                    if(i == 0 || i == countY-1 || i == countY-2 || x == 0 || x == countX-1 ){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                }
                countX--;
                System.out.println("");
            }

        }
        {
            int countX = 8;
            int countY = 8;
            for(int y = 0; y<countY; y++){
                for(int x = 0; x < countX; x++){
                    if(x == y || x == countX-1 || y == 0 ){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                }
                System.out.println(" ");
            }

        }
    }
}