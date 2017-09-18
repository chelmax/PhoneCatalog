package phonecatalog;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class Catalog {
    
    private ArrayList<PhoneNumber> numbers;

    Catalog() {
        numbers = new ArrayList();
    }
    
    public void createCatalog(String path){
        FileSeeker fs = new FileSeeker();
        fs.start(path);
        for(int i = 0; i < fs.getAmountOfFiles(); i++){
            try{
                File f = new File(fs.getFile(i));
                FileReader fr = new FileReader(f);
                String number = "";
                try{
                    while(true)
                        number += fr.read();
                } catch (EOFException ignore){
                    
                }  
                addNumber(number);
            } catch (Exception ex){
                System.err.println(ex);
            } 
        }
    }
    
    public void addNumber(String uncheckedNumber){
        PhoneNumber checkedNumber = new PhoneNumber();
        checkedNumber =  checkNumber(uncheckedNumber);
        numbers.add(checkedNumber);
    }
    
    public PhoneNumber checkNumber(String uncheckedNumber){
        PhoneNumber checkedNumber = new PhoneNumber();
        //следующее мое задание
        return checkedNumber;
    }
}
