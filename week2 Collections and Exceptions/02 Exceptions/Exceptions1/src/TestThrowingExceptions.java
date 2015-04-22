
public class TestThrowingExceptions {
    
    // hmmmmm
    public void useService() throws ServiceNotAvailableAtTheMomentException {
        throw new ServiceNotAvailableAtTheMomentException();
    }
    
    public static void main(String[] args) {
        TestThrowingExceptions serviceBreakdown = new TestThrowingExceptions();
        try {
            serviceBreakdown.useService();
        } catch (ServiceNotAvailableAtTheMomentException e) {
            System.out.println(e.message());
            e.printStackTrace();
        }
    }
}
