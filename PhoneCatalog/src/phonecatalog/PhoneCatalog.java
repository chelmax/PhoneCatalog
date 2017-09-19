package phonecatalog;

/**
 *
 * @author Max
 */
public class PhoneCatalog {
    
    private static final String PATH = "D:\\test";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Catalog c = new Catalog();
        c.createCatalog(PATH);
        c.printCatalog();
    }
    
}
