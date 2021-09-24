class FileSystem {
    private class FileProperty implements Comparator<FileProperty>{
        public String name;
        public boolean isDirectory;
        private StringBuilder content = new StringBuilder();
        private Map<String, FileProperty> fileNameMap = new TreeMap<>();
        
        public FileProperty(String name, String content){
            this.name = name;
            this.content.append(content);
            isDirectory = false;
        }
        
        public FileProperty(String name, boolean isDirectory){
            this.name = name;
            this.isDirectory = isDirectory;
        }
        
        public int compare(FileProperty f1, FileProperty f2){
            return f1.name.compareTo(f2.name);
        }
        
        public int hashCode(){
            return Objects.hashCode(name);
        }
        
        public FileProperty mkdir(String dirName){
            FileProperty dir = fileNameMap.get(dirName);
            if(dir == null){
                dir = new FileProperty(dirName, true);
                fileNameMap.put(dirName, dir);
            }
            return dir;
        }
        
        public void addFileContent(String fileName, String content){
            FileProperty file = fileNameMap.get(fileName);
            if(file == null){
                file = new FileProperty(fileName, content);
                fileNameMap.put(fileName, file);
            }else{
                file.content.append(content);
            }
        }
        
        public String getFileContent(String fileName){
            return fileNameMap.get(fileName).content.toString();
        }
        
        public List<String> ls(){
            return fileNameMap.keySet().stream().collect(Collectors.toList());
        }
        
        public FileProperty getDir(String dirName){
            return fileNameMap.get(dirName);
        }
        
        public String toString(){
            return name;
        }
    }
    

    FileProperty root = new FileProperty("/", true);
    

    public FileSystem() {
        
    }
    
    public List<String> ls(String path) {
        FileProperty directory = root;
        String[] pathSegments = getPathSegments(path.substring(1));
        for(String segment : pathSegments){
        	FileProperty dir = directory.getDir(segment);
            if(dir == null){
                break;
            }else if(dir.isDirectory){
                directory = dir;    
            }else{
                return List.of(dir.name);
            }
        }
        // System.out.println("Directories in "+directory+""+directory.ls());
        return directory.ls();
    }
    
    public void mkdir(String path) {
        FileProperty directory = root;
        String[] pathSegments = getPathSegments(path.substring(1));
        for(String segment : pathSegments){
            FileProperty existingDirectory = directory.getDir(segment);
            if(existingDirectory == null){
                directory = directory.mkdir(segment);
            }else {
                directory = existingDirectory;  
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        FileProperty directory = root;
        String[] pathSegments = getPathSegments(filePath.substring(1));
        for(int i= 0; i<pathSegments.length - 1; i++){
            FileProperty existingDirectory = directory.getDir(pathSegments[i]);
            if(existingDirectory == null){
                directory = directory.mkdir(pathSegments[i]);
            }else{
                directory = existingDirectory;
            }   
        }
        directory.addFileContent(pathSegments[pathSegments.length - 1], content);
    }
    
    public String readContentFromFile(String filePath) {
        FileProperty directory = root;
        String[] pathSegments = getPathSegments(filePath.substring(1));
        for(int i= 0; i<pathSegments.length - 1; i++){
            FileProperty existingDirectory = directory.getDir(pathSegments[i]);
            if(existingDirectory == null){
                directory = directory.mkdir(pathSegments[i]);
            }else{
                directory = existingDirectory;
            }   
        }
        return directory.getFileContent(pathSegments[pathSegments.length - 1]);
    }
    
    private String[] getPathSegments(String path){
        return path.split("\\/");
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