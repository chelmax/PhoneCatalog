package phonecatalog;

import java.io.*;
import java.util.*;

/**
 *
 * @author Max
 */
public class FileSeeker {
    
    private ArrayList<String> pathToFilesList;

    public FileSeeker() {
        this.pathToFilesList = new ArrayList();
    }
    
    
    public void start(String path){
        try{
            File f1 = new File(path);

            if(f1.exists())
                if(f1.isDirectory()){
                    list(path);
                    return;
                }
            System.err.println("Following path doesn't exist or isn't directory");
            
        }catch(Exception ex){
            System.err.println(ex);
        }   
    }
    
    public void list(String path){
        File f1 = new File(path);
        String deeperPath[]  = f1.list();
        
        for(int i = 0; i < deeperPath.length; i++){
            File f2 = new File(path + File.separator + deeperPath[i]);
        
            if(f2.isFile()){
                if(txtCheck(deeperPath[i]))
                    pathToFilesList.add(path + File.separator + deeperPath[i]);
            }else{
              list(path + File.separator + deeperPath[i]); 
            }
        }        
    }
    
    public boolean txtCheck(String pathToFile){
        return pathToFile.endsWith(".class");
    }
    
    public void print(){
        for(int i = 0; i < pathToFilesList.size(); i++){        
            String s = pathToFilesList.get(i);
            System.out.println(s);
        }
    }
}
