package demo.exception;

public class ThrowException {
    private int numerator, denominator;

    public ThrowException(int n, int d) throws Exception {
        if (d==0)
            throw new Exception();

        numerator = n;
        denominator = d;
    }
}
