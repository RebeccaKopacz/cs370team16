import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Request;
import spark.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Counts {
    private int wordCount;
    private int uniqueWords;
    private String table;

    public Counts() { }

    public Counts(int wordCount, int uniqueWords, String table) {
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
        this.table = table;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getUniqueWords() {
        return uniqueWords;
    }

    public String getTable() {
        return table;
    }

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

    public static void main(String args[]) {
        Counts counts = new Counts();
        try {

            String path = "src/main/java/" + args[0];

            File file = new File(path);
            String[] words = null;
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            int totalWordCount = 0;
            Map<String, Integer> map = new TreeMap<>();

            while ((line = br.readLine()) != null) {
                words = line.replaceAll("[^-0-9a-zA-Z' ]", "").toLowerCase().split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() < 1) ;
                    else if (map.containsKey(words[i])) {
                        map.put(words[i], map.get(words[i]) + 1);
                        totalWordCount++;
                    } else {
                        map.put(words[i], 1);
                        totalWordCount++;
                    }
                }
            }
            int uniqueWords = map.size();
            Map<String, Integer> sortedMap = sortByValues(map);

            int i = 0;
            String outputTable = "";
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                if (i < 50) {
                    String temp = (entry.getValue() + "\t |  " + entry.getKey() + "\n");
                    outputTable += temp;
                }
                i++;
            }

            counts.wordCount = totalWordCount;
            counts.uniqueWords = uniqueWords;
            counts.table = outputTable;

            fr.close();
        } catch ( FileNotFoundException e ) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
