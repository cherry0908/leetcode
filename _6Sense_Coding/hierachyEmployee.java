import java.io.*; 
import java.util.*; 

class Employee {
    
    // hashmap: key is manager, value is a list of employees
    private HashMap<Integer, List<Integer>> hashmap;
    // store ceo as root of the hierachy
    private int CEO;

    public Employee(List<List<Integer>> input){
        this.hashmap = new HashMap<>();

        for (List<Integer> list : input) {
            // CEO has no manager
            if (list.size() == 1) {
                this.CEO = list.get(0);
                hashmap.put(list.get(0), new ArrayList<>());
            }
            else {
                int employee = list.get(0);
                int manager = list.get(1);

                if (!hashmap.containsKey(manager)) {
                    hashmap.put(manager, new ArrayList<>());
                }

                List<Integer> employee_list = hashmap.get(manager);
                employee_list.add(employee);
                hashmap.put(manager, employee_list);
            }
        }
    }

    public void dfsHelper(int id, int level){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }
        sb.append(id);
        
        System.out.println(sb.toString());
        
        if (!hashmap.containsKey(id)) {
            return;
        }
        
        List<Integer> nexts = hashmap.get(id);
        for (int next : nexts) {
            dfsHelper(next, level + 1);
        }
    }
    
    public void printHierachy() {
        System.out.println(hashmap);
        
        dfsHelper(CEO, 1);
    }
}

public class Main
{
	public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        input.add(list);
        list = new ArrayList<>();
        list.add(2);
        list.add(1);
        input.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(1);
        input.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(2);
        input.add(list);
        list = new ArrayList<>();
        list.add(5);
        list.add(4);
        input.add(list);
        
        System.out.println(input);
        
        Employee e = new Employee(input);
        e.printHierachy();
        
	}
}