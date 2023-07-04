package com.codegym.utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CheckUtils {
    private static final Scanner scanner = new Scanner(System.in);
    public static double retryParseDouble() {
        double result;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai vui lòng nhập lại: ");
                System.out.print("==> ");
            }
        } while (true);
    }

    public static String retryString(String fieldName) {
        String result;
        System.out.print("==> ");
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("%s Không được để trống \n", fieldName);
            System.out.print("==> ");
        }
        return result;
    }

    public static int retryParseInt() {
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai vui lòng nhạp lại");
                System.out.print("==> ");
            }
        } while (true);
    }

    public static long retryParseLong() {
        long result;
        do {
            try {
                result = Long.parseLong(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai vui lòng nhập lại");
                System.out.print("==> ");
            }
        } while (true);
    }
    public static String doubleToVND(double value) {
        String patternVND = ",###VND";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }
    public static void pressEnterToContinue() {
        System.out.print("Ấn Enter để tiếp tục. ");
        scanner.nextLine();
    }
}
