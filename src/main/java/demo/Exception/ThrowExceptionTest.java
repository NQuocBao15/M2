package demo.Exception;

public class ThrowExceptionTest {
    public static void main(String[] args) {
        try {
            ThrowException throwException = new ThrowException(2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
