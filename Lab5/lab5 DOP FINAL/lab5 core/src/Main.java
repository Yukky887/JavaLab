import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание1:");

        String[] wordArr = {"Стол", "Стул", "Кровать", "Лампа", "Компьютер", "Монитор", "Гитара", "Микрофон", "Камера", "Кресло", "Гитара", "Стол", "Гитара"};
        HashMap<String, Integer> wordList =  new HashMap<String, Integer>();
        for (String a : wordArr){
            wordList.merge(a, 1,(f,g) -> g+f);
        }
        System.out.println(wordList.entrySet());

        // Сортировка по возрастанию номеров телефонов
        System.out.println("Задание2:");
        Telephone_book tp_bk = new Telephone_book();
        tp_bk.add("Вадим", "122");
        tp_bk.add("Парви сджон", "118");
        tp_bk.add("Аовыч", "199");
        tp_bk.add("Димон", "133");
         tp_bk.add("Вадим", "144");
        /*tp_bk.add("Вовыч", "111");*/
        /*tp_bk.add("Димон", "117");*/
        /*tp_bk.add("Вадим", "131");*/

        tp_bk.printAllSorted();
    }
}
