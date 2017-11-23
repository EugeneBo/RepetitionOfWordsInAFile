import java.io.*;
import java.util.*;

public class RepetitionOfWords {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, Integer> words = new HashMap<>();

        Scanner scanner = new Scanner(new FileInputStream("C:/test.txt"));

        while (scanner.hasNextLine()) {
            for (String i : (scanner.nextLine().toLowerCase().trim().replaceAll("[\\pP]+\t", "").split("\\s"))) {

                if (!words.containsKey(i)) {
                    words.put(i, 1);
                } else {
                    words.put(i, words.get(i) + 1);
                }
            }
        }

        scanner.close();

//        for (Map.Entry i : words.entrySet()) {
//            System.out.print(i.getKey() + "\t - " + i.getValue() + "; ");  //первый вариант вывода
//        }
//
//        System.out.println();
//
//        for (String i : words.keySet()) {
//            System.out.print(i + "\t - " + words.get(i) + "; "); // второй вариант вывода
//        }
//
//        System.out.println();



        List sortedList = new ArrayList(words.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });

        System.out.println(sortedList);


    }


}