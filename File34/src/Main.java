import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void AddFolderAndFileInFolder(String folderName , String fileName) {
        try {
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File(folder.getAbsolutePath() + "/"+fileName+".txt");

            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFolderAndFileInFolder(String folderName , String fileName) {
        try {
            File folder = new File(folderName);
            if (folder.isDirectory()){
                File file = new File(folderName + "/" +fileName + ".txt");

                if (file.isFile()){
                    System.out.println("Delete file : " + file.delete());
                }

                System.out.println("Delete folder : " + folder.delete());
            }else{
                System.out.println("Ok");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter folder name  :  ");//Farid
//        String folderName = scanner.nextLine();
//        System.out.print("Enter file   name  :  ");//Abdullayev
//        String fileName = scanner.nextLine();
//        System.out.print("Enter  count       :  ");//10
//        Integer count = scanner.nextInt();




        for (int i = 0; i < 10; i++) {
            AddFolderAndFileInFolder("Farid"+i,"Abdullayev"+i);
            deleteFolderAndFileInFolder("Farid"+i,"Abdullayev"+i);

//            AddFolderAndFileInFolder(folderName+i,fileName+i);
        }
        deleteFolderAndFileInFolder("Farid1","Abdullayev1");




        //Udalit vse papki i fayli
        //Udalit vse papki i fayli krome pervoy
        //tolko 1uyu papku i file vse ostalnoe ostanetsa



//        try {
//            File folder = new File("papka");
//            if (folder.exists()) {
//                System.out.println("Takaya papka uje est");
//            } else {
//                folder.mkdir();
//                System.out.println("Papka udacno bilo sozdana");
//            }
//
//            File file = new File(folder.getAbsolutePath()+"/file.txt");
//
//            System.out.println(file.getAbsolutePath());
//            if (file.exists()) System.out.println("Takoy file uje est");
//            else
//            {
//                file.createNewFile();
//                System.out.println("File uspewno bil dobavlen");
//            }
//
//            if (folder.isDirectory()) System.out.println("This is directory");
//            else System.out.println("This is folder");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        folder.delete();
    }
}