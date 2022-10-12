class FileSystem {
    
    class File {
        private boolean isFile;
        private HashMap<String, File> children;
        private String content;
        
        public File() {
            this.isFile = false;
            this.children = new HashMap<>();
            this.content = "";
        }
        
    }

    File root;
    
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        if (path == null || path.length() == 0) {
            return new ArrayList<>();
        }
        
        File curr = root;
        List<String> list = new ArrayList<>();
        
        // the path is not the root path
        if (!path.equals("/")) {
            // dirs[0] == "", starts with i=1
            String[] dirs = path.split("/");
            int n = dirs.length;
            
            for (int i = 1; i < n; i++) {
                if (!curr.children.containsKey(dirs[i])) {
                    return list;
                }

                curr = curr.children.get(dirs[i]);
            }
            
            // if the curr is a file, return a list only include this file
            if (curr.isFile) {
                list.add(dirs[n - 1]);
                return list;
            }
        }
        
        // the curr is a directory, return all the children files and directories
        // add all the children from the hashmap of the current node
        for (String key : curr.children.keySet()) {
            list.add(key);
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    public void mkdir(String path) {
        if (path == null || path.length() == 0 || path.equals("/")) {
            return;
        }
        
        // dirs[0] == "", starts with i=1
        String[] dirs = path.split("/");
        int n = dirs.length;
        
        File curr = root;
        
        for (int i = 1; i < n; i++) {
            if (!curr.children.containsKey(dirs[i])) {
                curr.children.put(dirs[i], new File());
            }
            
            curr = curr.children.get(dirs[i]);
        }
        
    }
    
    public void addContentToFile(String filePath, String content) {
        if (filePath == null || filePath.length() == 0 || filePath.equals("/")) {
            return;
        }
        
        // dirs[0] == "", starts with i=1
        String[] dirs = filePath.split("/");
        
        // file name is the last one in the array
        int n = dirs.length;
        String name = dirs[n - 1];
        
        File curr = root;
        
        for (int i = 1; i < n; i++) {
            if (!curr.children.containsKey(dirs[i])) {
                curr.children.put(dirs[i], new File());
            }
            
            curr = curr.children.get(dirs[i]);
        }
        
        curr.isFile = true;
        curr.content = curr.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        if (filePath == null || filePath.length() == 0 || filePath.equals("/")) {
            return "file path doesn't exist";
        }
        
        // dirs[0] == "", starts with i=1
        String[] dirs = filePath.split("/");
        
        // file name is the last one in the array
        int n = dirs.length;
        String name = dirs[n - 1];
        
        File curr = root;
        
        for (int i = 1; i < n; i++) {
            if (!curr.children.containsKey(dirs[i])) {
                return "file path doesn't exist";
            }
            
            curr = curr.children.get(dirs[i]);
        }
        
        if (curr == null) {
            return "file doesn't exist";
        }
        else if (!curr.isFile) {
            return "this is not a file";
        }
        else {
            return curr.content;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */