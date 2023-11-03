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
        String lang = "";
        String word = "";
        String tr = "";
        while (true) {
            System.out.print("\nПриветствуем в вас в словаре!\nВведите 1 : Показать весь словарь"
                    + "\nВведите 2: Показать список добавлленых языков "
                    + "\nВведите 3: Показать слова только одного языка"
                    + "\nВведите 4: Добавить язык"
                    + "\nВведите 5: Удалить язык"
                    + "\nВведите 6: Добавить слово"
                    + "\nВведите 7: Удалить слово"
                    + "\nВведите 8: Удалить перевод слова"
                    + "\nВведите 9: Поиск слова"
                    + "\nВведите 10: Поиск слова");
            System.out.println();
            inputUser = userInputInt(scanner);
            try {
                switch (inputUser) {
                    case 1:
                        dictionary.printWords();
                        break;
                    case 2:
                        dictionary.printLang();
                        break;
                    case 3:
                        System.out.print("Введите язык: ");
                        lang = userInputString(scanner);
                        dictionary.printWordsLang(lang);
                        break;
                    case 4:
                        System.out.println("Введите язык для добавления: ");
                        lang = userInputString(scanner);
                        dictionary.addLang(lang);
                        break;
                    case 5:
                        System.out.println("Введите язык для удаления: ");
                        lang = userInputString(scanner);
                        dictionary.removeLang(lang);
                        break;
                    case 6:
                        System.out.println("Введите язык: ");
                        lang = userInputString(scanner);
                        System.out.println("Введите новое слово:");
                        word = userInputString(scanner);
                        System.out.println("Введите его перевод: ");
                        tr = userInputString(scanner);
                        dictionary.addWord(lang, word, tr);
                        break;
                    case 7:
                        System.out.println("Введите язык: ");
                        lang = userInputString(scanner);
                        System.out.println("Введите слово для удаления: ");
                        word = userInputString(scanner);
                        dictionary.removeWord(lang, word);
                        break;
                    case 8:
                        System.out.println("Введите язык: ");
                        lang = userInputString(scanner);
                        System.out.println("Введите слово: ");
                        word = userInputString(scanner);
                        System.out.println("Введите перевод для удаления: ");
                        tr = userInputString(scanner);
                        dictionary.removeTranslate(lang, word, tr);
                        break;
                    case 9:
                        System.out.println("Введите язык");
                        lang = userInputString(scanner);
                        System.out.println("Введите слово или его часть: ");
                        word = userInputString(scanner);
                        dictionary.searchTranslateIncompleteWord(lang, word);
                        break;
                    case 10:
                        System.out.println("Введите язык");
                        lang = userInputString(scanner);
                        System.out.println("Введите слово:");
                        word = userInputString(scanner);
                        dictionary.searchUnknown(lang, word);
                }
            } catch (Exception ex) {
                System.err.println("Ошибка ввода");
            }

        }
    }

    public int userInputInt(Scanner scanner) {
        int input = 0;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            System.err.println("Ошибка ввода");
        }
        return input;
    }

    public String userInputString(Scanner scanner) {
        String input = "";
        try {
            input = scanner.nextLine();
        } catch (Exception ex) {
            System.err.println("Ошибка ввода");
        }
        return input;
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

    public List<String> checkList(List<String> nowArrWord, List<String> newArrWord) {
        for (String word : newArrWord) {
            if (!nowArrWord.contains(word)) {
                nowArrWord.add(word);
            }
        }
        return nowArrWord;
    }

    public boolean addWord(String lang, String key, List<String> arrWords) {
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        arrWords = arrToLowerCase(arrWords);
        if (dictionary.containsKey(lang)) {
            if (dictionary.get(lang).containsKey(key)) {
                List<String> arr = dictionary.get(lang).get(key);
                List<String> arrNew = checkList(arr, arrWords);
                if (arr.size() != arrNew.size()) {
                    dictionary.get(lang).put(key, arrNew);
                    return true;
                }
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

    public boolean removeWord(String lang, String key) {
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        if (dictionary.containsKey(lang)) {
            if (dictionary.get(lang).containsKey(key)) {
                dictionary.get(lang).remove(key);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean removeTranslate(String lang, String key, String tr) {
        lang = lang.toLowerCase();
        key = key.toLowerCase();
        tr = tr.toLowerCase();
        if (dictionary.containsKey(lang) && dictionary.get(lang).containsKey(key) && dictionary.get(lang).get(key).contains(tr)) {
            dictionary.get(lang).get(key).remove(tr);
            return true;
        } else {
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
        if (count == 1) {
            System.out.println("В словаре пока нет слов");
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
        for (String keyLang : dictionary.keySet()) {
            if (lang.equals(keyLang)) {
                count++;
                for (String str : dictionary.get(lang).keySet()) {
                    if (str.contains(key)) {
                        searchTranslateWord(lang, str);
                    }
                }
            }
        }
        if (count == 1) {
            System.out.println("Такого языка нет");
        }
    }
    public void searchUnk(String lang, String key){

    }

    public void searchUnknown(String lang, String key) {
        key = key.toLowerCase();
        lang = lang.toLowerCase();
        int count = 0, i = 0, j = 0;
        char[] keyArr = key.toCharArray();
        boolean isCorrect = false;
        System.out.println();
        for (String word : dictionary.get(lang).keySet()) {
            for (; i < word.length(); ) {
                if (j <= key.length() - 1) {
                    if (key.charAt(j) == word.charAt(i)) {
                        isCorrect = true;
                        j++;
                    } else if (key.charAt(j) == '*') {
                        isCorrect = true;
                    } else if (key.charAt(j) == '_') {
                        isCorrect = true;
                        j++;
                    } else {
                        isCorrect = false;
                        break;
                    }
                    i++;
                } else {
                    isCorrect = false;
                    break;
                }
            }
            check(isCorrect,lang,key,word,i,j);
            i = j = 0;
        }
    }

    private void check(boolean isCorrect, String lang, String key,String word, int i, int j) {
        int count = 0;
        if (isCorrect && j >= key.length() || j + 1 == key.length()) {
            System.out.print(word + ": ");
            for (String tr : dictionary.get(lang).get(word)) {
                if (count != 0) {
                    System.out.print(", ");
                }
                System.out.print(tr);
                count++;
            }
            System.out.println();
        }
    }
}