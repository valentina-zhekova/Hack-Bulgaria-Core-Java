import java.lang.reflect.Method;


public class MainClass extends JUnitFailVersion {
    
    @Before
    public void setUp() {
        System.out.println("Turtles everywhere!");
    }
    
    @Execute
    public void test() {
        Method[] beforeTest = this.getClass().getMethods();
        for (Method m : beforeTest)
            System.out.println(m);
        System.out.println("Run for your life!");
    }
    
    public static void main(String[] args) {
        
    }

}
