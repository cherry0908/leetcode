import java.io.*; 
import java.util.*; 

class Solution {
    public String[] logProcess(String[] input) {
        if (input == null || input.length == 0) return new String[]{};
        
        List<String> result = new ArrayList<>();
        int index = 1;
        
        // HashMap<Integer, List<String>> hashmap = new HashMap<>();
        TreeMap<Integer, List<String>> query_map = new TreeMap<>();
        
        for (String str : input) {
            String[] tmp = str.split(":\\s+");
            
            // input string is a query
            if (tmp[0].charAt(0) == 'Q') {
                // all lower case and split into words
                String query = tmp[1].toLowerCase();
                String[] words = query.split("\\W");
                
                // add index and list to the map
                query_map.put(index, Arrays.asList(words));
                index++;
                
                result.add(query);
            }
            
            // input string is a log
            else if (tmp[0].charAt(0) == 'L') {
                // all lower case and split into words
                String log = tmp[1].toLowerCase();
                String[] words = log.split("\\W");
                
                HashSet<String> log_word_set = new HashSet<>(Arrays.asList(words));
                List<Integer> query_index = new ArrayList<>();
                
                // scan all the queries in the query map
                for (int key : query_map.keySet()) {
                    List<String> list = query_map.get(key);
                    int count = list.size();
                    
                    // scan every word in each query
                    for (String s : list) {
                        // if the word can be found in the log word set
                        // decrease the word count
                        if (log_word_set.contains(s)) {
                            count--;
                        }
                        else {
                            break;
                        }
                    }
                    
                    // contain all words from the query
                    // remember the query index for result
                    if (count == 0) {
                        query_index.add(key);
                    }
                }
                
                // use string builder to build the final output string
                StringBuilder sb = new StringBuilder();
                sb.append(tmp[1]);
                sb.append(" Query ID = ");
                
                for (int i : query_index) {
                    sb.append(i + ",");
                }
                
                sb.deleteCharAt(sb.length() - 1);
                
                result.add(sb.toString());
            }
        }
        
        int size = result.size();
        String[] output = new String[size];
        result.toArray(output);
        
        return output;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution s = new Solution();
        String[] input = {"Q: Database", "Q: Database connection is successful.", "Q: Connection failed.", "Q: Database connection failed.", "L: My database connection failed."};
        String[] output = s.logProcess(input);
        
        for (String str : output) {
            System.out.println(str);
        }
	}
}