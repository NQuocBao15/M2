package demo;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Numerator: ");
            int numerator = scanner.nextInt();
            System.out.println("Denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator/denominator;
            int residual = numerator%denominator;
            System.out.printf("Result: %d / %d = %d\n",
                    numerator, denominator, result);
            System.out.printf("Residual: %d %% %d = %d\n",
                    numerator, denominator, residual);
        } catch (InputMismatchException e) {
            System.out.println("Input error.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error.");
        } catch (Exception e) {
            System.out.println("Exception error.");
        } finally {
            System.out.println("Hello, this is finally");
        }
    }
}
