import java.util.*;
import java.util.Locale;

public class Telephone_book {
    private Map<String, TreeSet<String>> tpbk = new TreeMap<>();

    public void add(String name, String number) {
        boolean rep = true;
        String s1 = name.substring(0, 1).toUpperCase() + name.substring(1);
        for (Set x : tpbk.values()) {
            if (x.contains(number)) rep = false;
        }
        if (rep) {
            if (tpbk.containsKey(s1)) {
                if (tpbk.get(s1).add(number) == false) {
                    System.out.println("Номер " + number + " уже существует, добавить невозможно.");
                }
            } else {
                tpbk.put(s1, new TreeSet<>(Collections.singleton(number)));
            }
        } else {
            System.out.println("Номер " + number + " уже существует, добавить невозможно.");
        }
    }

    Set<String> get(String Name) {
        System.out.print(Name + " : ");
        return tpbk.get(Name);
    }



    public void printAllSorted() {
        List<Map.Entry<String, TreeSet<String>>> list = new ArrayList<>(tpbk.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, TreeSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, TreeSet<String>> o1, Map.Entry<String, TreeSet<String>> o2) {
                return o1.getValue().first().compareTo(o2.getValue().first());
            }
        });
        for (Map.Entry<String, TreeSet<String>> entry : list) {
            System.out.println(entry.getKey()  + ": " + entry.getValue());
        }
    }
}