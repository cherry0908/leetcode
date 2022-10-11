import java.io.*; 
import java.util.*; 

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
class Document {
    public int id;
    public String content;
}

class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        HashMap<String, List<Integer>> hashmap = new HashMap<>();

        for (Document doc : docs) {
            // String str = doc.content.toLowerCase();
            // String[] words = str.split("\\W");
            String[] words = doc.content.split("\\s+");

            for (String word : words) {
                if (word.length() > 0) {
                    if (!hashmap.containsKey(word)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(doc.id);
                        hashmap.put(word, list);
                    }
                    else {
                        List<Integer> list = hashmap.get(word);
                        // check this word in this document is indexed already or not
                        if (list.get(list.size() - 1) != doc.id) {
                            list.add(doc.id);
                            hashmap.put(word, list);
                        }
                    }
                }
            }
        }

        return hashmap;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution s = new Solution();
        Document doc1 = new Document();
        doc1.id = 1;
        doc1.content = "This is the content of document1 it is very short";
        Document doc2 = new Document();
        doc2.id = 2;
        doc2.content = "This is the content of document2 it is very long bilabial bilabial heheh hahaha";
        List<Document> docs = new ArrayList<>();
        docs.add(doc1);
        docs.add(doc2);

        System.out.println(s.invertedIndex(docs));
	}
}