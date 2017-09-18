package phonecatalog;

/**
 *
 * @author Max
 */
public class PhoneCatalog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileSeeker example = new FileSeeker();
        example.start("D:\\work");
        example.print();
    }
    
}
