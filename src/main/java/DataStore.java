import java.util.HashMap;
import java.util.Map;

public class DataStore {
    //Map of names to Person instances.
    private Map<String, Counts> countsMap = new HashMap<>();

    //this class is a singleton and should not be instantiated directly!
    private static DataStore instance = new DataStore();
    public static DataStore getInstance(){
        return instance;
    }

    //private constructor so people know to use the getInstance() function instead
    private DataStore(){
        //dummy data
        countsMap.put("First", new Counts(13,11,"1 | ABC"));
        countsMap.put("Second", new Counts(14,12,"2 | DEF"));
        countsMap.put("Third", new Counts(15,13,"3 | GHI"));
    }

    public Counts getCounts(String name) {
        return countsMap.get(name);
    }

    public void putCounts(Counts counts) {
        countsMap.put(counts.getTable(), counts);
    }
}
