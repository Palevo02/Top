import java.util.*;
public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addLang("ru");
        dictionary.printLang();
    }
}
class Dictionary{
    private Map<String,Map<String,List<String>>> dictionary;
    {
        dictionary = new TreeMap<>();
    }
    public void addLang(String lang){
        dictionary.put(lang,new TreeMap<>());
    }
    public void printLang(){
        for(String lang: dictionary.keySet()){
            System.out.println(lang);
        }
    }
}