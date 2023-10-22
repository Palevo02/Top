import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        System.out.println(dictionary.addLang("ru"));
        System.out.println(dictionary.addLang("ru"));
        System.out.println(dictionary.addLang("en"));
        System.out.println(dictionary.addLang("kz"));
        dictionary.printLang();
        ArrayList<String> arrWords = new ArrayList<>();
        arrWords.add("Кот");
        arrWords.add("Котёнок");
        System.out.println(dictionary.addWord("en","cat",arrWords));
        System.out.println(dictionary.addWord("en","cat","Кот"));
        System.out.println(dictionary.addWord("en","cat","Кота"));

        System.out.println(dictionary.addWord("en","dog","Пёс"));
        System.out.println(dictionary.addWord("en","dog","Собака"));
        System.out.println(dictionary.addWord("en","doggy","Собачка"));
        dictionary.printWordsLang("en");
        dictionary.searchTranslateWord("en","dog");
        dictionary.searchTranslateIncompleteWord("en","do");
    }
}

class Dictionary {
    private Map<String, Map<String, List<String>>> dictionary;

    {
        dictionary = new TreeMap<>();
    }

    public boolean addLang(String lang) {
        lang = lang.toLowerCase();
        if (dictionary.containsKey(lang)) {
            return false;
        }
        dictionary.put(lang, new TreeMap<>());
        return true;
    }
    public boolean removeLang(String lang){
        lang = lang.toLowerCase();
        if(dictionary.containsKey(lang)){
            dictionary.remove(lang);
            return true;
        }
        return false;
    }
    private List<String > arrToLowerCase(List<String> arrWords){
        List<String> listArr =new ArrayList<String>();
        for(String str: arrWords){
            listArr.add(str.toLowerCase());
        }
        return listArr;
    }
    public boolean addWord(String lang, String key, List <String> arrWords){
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        arrWords = arrToLowerCase(arrWords);
        if(dictionary.containsKey(lang)){
            if(dictionary.get(lang).containsKey(key)){
                return false;
            } else {
                dictionary.get(lang).put(key,arrWords);
                return true;
            }
        }else{
            if(addLang(lang))
            return addWord(lang, key, arrWords);
            else return false;
        }
    }
    public boolean addWord(String lang, String key, String word){
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        word = word.toLowerCase();
        if(dictionary.containsKey(lang)){
            if(dictionary.get(lang).containsKey(key)){
                if(dictionary.get(lang).get(key).contains(word)){
                    return false;
                }else {
                    dictionary.get(lang).get(key).add(word);
                    return true;
                }
            } else {
                ArrayList<String> arrWords = new ArrayList<>();
                arrWords.add(word);
                dictionary.get(lang).put(key,arrWords);
                return true;
            }
        }else{
            if(addLang(lang))
                return addWord(lang, key, word);
            else return false;
        }
    }

    public void printLang() {
        int count = 1;
        for (String lang : dictionary.keySet()) {
            System.out.println(count ++ + ") " + lang);
        }
    }
    public void printWordsLang(String lang){
        int count = 1;
        int count2 = 1;
        lang = lang.toLowerCase();
        for(String str: dictionary.get(lang).keySet()){
            System.out.print(count++ + ") " + str + ": ");
            for(String tr: dictionary.get(lang).get(str)){
                if(count2 != 1){
                    System.out.print(", ");
                }
                System.out.print(tr);
                count2++;
            }
            System.out.println();
            count2 = 1;
        }
    }
    public void searchTranslateWord(String lang,String key){
        int count = 1;
        lang = lang.toLowerCase();
        key = key.toLowerCase();

        System.out.print("\n"+key + ": ");
        for (String word: dictionary.get(lang).get(key)) {
            if(count !=1){
                System.out.print(", ");
            }
            System.out.print(word );
            count++;

        }
    }
    public void searchTranslateIncompleteWord (String lang, String key){
        int count = 1;
        key = key.toLowerCase();
        lang = lang.toLowerCase();
        System.out.println();
        for (String str: dictionary.get(lang).keySet()) {
            if(str.contains(key)){
                searchTranslateWord(lang, str);
            }
        }
    }
}