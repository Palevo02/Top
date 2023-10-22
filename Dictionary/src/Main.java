import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Menu menu = new Menu();


        System.out.println(dictionary.addLang("ru"));
        System.out.println(dictionary.addLang("ru"));
        System.out.println(dictionary.addLang("en"));
        System.out.println(dictionary.addLang("kz"));
        dictionary.printLang();
        ArrayList<String> arrWords = new ArrayList<>();
        arrWords.add("Кот");
        arrWords.add("Котёнок");
        System.out.println(dictionary.addWord("en", "cat", arrWords));
        System.out.println(dictionary.addWord("en", "cat", "Кот"));
        System.out.println(dictionary.addWord("en", "cat", "Кота"));

        System.out.println(dictionary.addWord("en", "dog", "Пёс"));
        System.out.println(dictionary.addWord("en", "dog", "Собака"));
        System.out.println(dictionary.addWord("en", "doggy", "Собачка"));
        dictionary.printWordsLang("en");
        dictionary.searchTranslateWord("en", "dog");
        dictionary.searchTranslateIncompleteWord("en", "do");
        menu.printMenu(dictionary);
    }
}

class Menu {
    public void printMenu(Dictionary dictionary) {
        Scanner scanner = new Scanner(System.in);
        int inputUser = 0;
        while (true) {
            System.out.print("\nПриветствуем в вас в словаре!\nВведите 1 : Показать весь словарь"
                    + "\nВведите 2: Показать список добавлленых языков "
                    + "\nВведите 3: Показать слова только одного языка"
                    + "\nВведите 4: Добавить язык"
                    + "\nВведите 5: Удалить язык"
                    + "\nВведите 6: Добавить слово"
                    + "\nВведите 7: Удалить слово"
                    + "\nВведите 8: Удалить перевод слова");
            inputUser = Integer.parseInt(scanner.nextLine());
            switch (inputUser) {
                case 1:
                    dictionary.printWords();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
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

    public boolean removeLang(String lang) {
        lang = lang.toLowerCase();
        if (dictionary.containsKey(lang)) {
            dictionary.remove(lang);
            return true;
        }
        return false;
    }

    private List<String> arrToLowerCase(List<String> arrWords) {
        List<String> listArr = new ArrayList<String>();
        for (String str : arrWords) {
            listArr.add(str.toLowerCase());
        }
        return listArr;
    }

    public boolean addWord(String lang, String key, List<String> arrWords) {
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        arrWords = arrToLowerCase(arrWords);
        if (dictionary.containsKey(lang)) {
            if (dictionary.get(lang).containsKey(key)) {
                return false;
            } else {
                dictionary.get(lang).put(key, arrWords);
                return true;
            }
        } else {
            if (addLang(lang))
                return addWord(lang, key, arrWords);
            else return false;
        }
    }

    public boolean addWord(String lang, String key, String word) {
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        word = word.toLowerCase();
        if (dictionary.containsKey(lang)) {
            if (dictionary.get(lang).containsKey(key)) {
                if (dictionary.get(lang).get(key).contains(word)) {
                    return false;
                } else {
                    dictionary.get(lang).get(key).add(word);
                    return true;
                }
            } else {
                ArrayList<String> arrWords = new ArrayList<>();
                arrWords.add(word);
                dictionary.get(lang).put(key, arrWords);
                return true;
            }
        } else {
            if (addLang(lang))
                return addWord(lang, key, word);
            else return false;
        }
    }
    public boolean removeWord(String lang,String key){
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        if(dictionary.containsKey(lang)){
            if(dictionary.get(lang).containsKey(key)){
                dictionary.get(lang).remove(key);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void printLang() {
        int count = 1;
        for (String lang : dictionary.keySet()) {
            System.out.println(count++ + ") " + lang);
        }
    }

    public void printWordsLang(String lang) {
        int count = 1;
        int count2 = 1;
        lang = lang.toLowerCase();
        for (String str : dictionary.get(lang).keySet()) {
            System.out.print(count++ + ") " + str + ": ");
            for (String tr : dictionary.get(lang).get(str)) {
                if (count2 != 1) {
                    System.out.print(", ");
                }
                System.out.print(tr);
                count2++;
            }
            System.out.println();
            count2 = 1;
        }
    }

    public void printWords() {
        int count = 1;
        int count2 = 1;
        int count3 = 1;
        for (String lang : dictionary.keySet()) {
            System.out.print("\nЯзык : " + lang);
            for (String word : dictionary.get(lang).keySet()) {
                count3++;
                System.out.print("\n" + count++ + ") " + word + ": ");
                for (String tr : dictionary.get(lang).get(word)) {
                    if (count2++ != 1) {
                        System.out.print(", ");
                    }
                    System.out.print(tr);
                }
                count2 = 1;
            }
            if (count3 == 1) {
                System.out.println("\nВ словаре этого языка пока нет слов");
            }
            count3 = 1;
        }
    }

    public void searchTranslateWord(String lang, String key) {
        int count = 1;
        int count2 = 1;
        lang = lang.toLowerCase();
        key = key.toLowerCase();

        System.out.print("\n" + key + ": ");
        for (String word : dictionary.get(lang).get(key)) {
            if (count != 1) {
                System.out.print(", ");
            }
            System.out.print(word);
            count++;

        }
    }

    public void searchTranslateIncompleteWord(String lang, String key) {
        int count = 1;
        key = key.toLowerCase();
        lang = lang.toLowerCase();
        System.out.println();
        for (String str : dictionary.get(lang).keySet()) {
            if (str.contains(key)) {
                searchTranslateWord(lang, str);
            }
        }
    }
}