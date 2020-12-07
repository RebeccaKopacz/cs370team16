import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;
import java.util.*;
public class Counter {

    //Method for sorting the TreeMap based on values
    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }


    public static void main(String args[]) throws IOException{
        File file = new File("file.txt");
        String [] words = null;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        int totalWordCount = 0;
        Map<String,Integer> map=new TreeMap<>();

        while ((line = br.readLine()) != null) {
            words = line.replaceAll("[^-0-9a-zA-Z' ]", "").toLowerCase().split(" ");
            for(int i = 0; i < words.length; i++) {
                if(words[i].length() < 1);
                else if (map.containsKey(words[i])) {
                    map.put(words[i], map.get(words[i])+1);
                    totalWordCount++;
                }
                else {
                    map.put(words[i],1);
                    totalWordCount++;
                }
            }
        }
        int uniqueWords = map.size();
        Map<String, Integer> sortedMap = sortByValues(map);

        System.out.println("TOTAL WORD COUNT: " + totalWordCount);
        System.out.println("TOTAL UNIQUE WORDS: " + uniqueWords + "\n");
        System.out.println("COUNT \t |  WORD");
        int i = 0;
        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()) {
            if(i < 50) {
                System.out.println(entry.getValue() + "\t |  " + entry.getKey());
            }
            i++;
        }

        fr.close();
    }
}