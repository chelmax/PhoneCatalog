package phonecatalog;

import java.io.*;
import java.util.*;
/**
 *
 * @author Max
 */
public class Catalog {
    
    private ArrayList<PhoneNumber> numbers;

    Catalog() {
        this.numbers = new ArrayList();
    }
    
    public void createCatalog(String path){
        FileSeeker fs = new FileSeeker();
        fs.start(path);
        for(int i = 0; i < fs.getAmountOfFiles(); i++){
            try{
                File f = new File(fs.getFile(i));
                FileReader fr = new FileReader(f);
                String number = "";
                int c;
                while((c = fr.read())!= -1){
                    number += (char) c;
                }
                addNumber(number);
            } catch (Exception ex){
                System.err.println(ex);
            } 
        }
        
        deleteDublicatsAndSort();
    }
    
    public void addNumber(String uncheckedNumber){
        PhoneNumber checkedNumber = checkNumber(uncheckedNumber);
        numbers.add(checkedNumber);
    }
    
    public PhoneNumber checkNumber(String uncheckedNumber){
        PhoneNumber checkedNumber = new PhoneNumber();
            
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uncheckedNumber.length(); i++) {
            char ch = uncheckedNumber.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        uncheckedNumber = sb.toString();
        
        int numberBeginsAt = uncheckedNumber.length() - 7;
        checkedNumber.setNumber(uncheckedNumber.substring(numberBeginsAt));
        
        if((uncheckedNumber.length() - 10) >= 0){ //есть ли код города
            
            String temp = uncheckedNumber.substring(0, numberBeginsAt);
            int cityBeginsAt = temp.length() - 3;
            checkedNumber.setCityCode(temp.substring(cityBeginsAt));
            
            if((temp.length() - 4) >= 0){ //есть ли код страны
                
                temp = uncheckedNumber.substring(0, cityBeginsAt);
                checkedNumber.setCountryCode(temp.substring(0));
                
            }    
        }          
        return checkedNumber;
    }
    
    public void deleteDublicatsAndSort(){
        TreeSet<Long> numbersSet = new TreeSet();
        for (PhoneNumber number : numbers) {
            String temp = number.getCountryCode() + number.getCityCode() + number.getNumber();
            Long longNumber = Long.parseLong(temp);
            numbersSet.add(longNumber); //поправить порядок возрастания
        }
        
        Long[] numbersLongMas; 
        numbersLongMas = numbersSet.toArray(new Long[numbersSet.size()]);
        
        String[] numbersStringMas = new String[numbersLongMas.length];
        for(int i = 0; i < numbersLongMas.length; i++){
            numbersStringMas[i] = numbersLongMas[i].toString();
        }
        
        numbers = new ArrayList();
        
        for (String numberFromMas : numbersStringMas) {
            PhoneNumber number = new PhoneNumber();
            int length = numberFromMas.length();
            number.setNumber(numberFromMas.substring(length - 7, length));
            number.setCityCode(numberFromMas.substring(length - 10, length - 7));
            number.setCountryCode(numberFromMas.substring(0, length - 10));
            numbers.add(number);
        }
    }
    
    public void printCatalog(){
        for (PhoneNumber number : numbers) {
            number.printFullNumber();
        }
    }
}
