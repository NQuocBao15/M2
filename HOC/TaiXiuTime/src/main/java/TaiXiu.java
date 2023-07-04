import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Locale lc = new Locale("vi", "VN");
        NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
        double wallet = 50000000;
        int choice = 0;
        do {
            String viTien = "VÍ CỦA BẠN CÓ ";
            System.out.printf("%70s\n", viTien+numf.format(wallet));
            System.out.println("----------- MỜI BẠN LỰA CHỌN -----------");
            System.out.println("||          Chọn (1) để chơi.         ||");
            System.out.println("||      Chọn (số bất kỳ) để thoát.    ||");
            System.out.println("----------------------------------------");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("*** BẮT ĐẦU CHƠI: ");
                System.out.println("Bạn muốn cược bao nhiêu?");
                double betAmount;
                do {
                    System.out.print("Nhập số tiền đặt cược: ");
                    betAmount = sc.nextDouble();
                    if (betAmount > wallet) {
                        System.out.println("Số tiền đặt cược không được vượt quá số dư tài khoản!");
                    }
                } while (betAmount > wallet);
                do {
                    System.out.println("****** Người chơi đặt cược "+ numf.format(betAmount));

                    int choiceSicBo;
                    do {
                        System.out.println("****** Chon: 1<-> Tài hoặc 2 <-> Xỉu");
                        choiceSicBo = sc.nextInt();
                    } while (choiceSicBo != 1 && choiceSicBo != 2);

                    int tong = randomXucXac();

                    if (tong == 3 || tong == 18) {
                        wallet -= betAmount;
                        System.out.println("****** Tổng là: " + tong + " => Nhà cái ăn hết, bạn đã thua!");
                        System.out.println("****** Tài khoản của bạn là: " + wallet);
                    } else if (tong <= 10) {
                        System.out.println("****** Tổng là: " + tong + " => Xỉu");
                        if (choiceSicBo == 2) {
                            System.out.println("****** Bạn đã thắng cược");
                            wallet += betAmount;
                        } else {
                            System.out.println("****** Bạn đã thua cược");
                            wallet -= betAmount;
                        }
                    } else {
                        System.out.println("****** Tổng là: " + tong + " => Tài");
                        if (choiceSicBo == 1) {
                            System.out.println("****** Bạn đã thắng cược");
                            wallet += betAmount;
                        } else {
                            System.out.println("****** Bạn đã thua cược");
                            wallet -= betAmount;
                        }
                    }
                } while (choice == 0);
                if(wallet<=0) {
                    System.out.println("\n\nSố Dư Tài Khoản Của Bạn Hiện Tại Không Thể Tiến Hành Đặt Cược!");
                    System.out.println("\n*BỊ SÚT RA NGOÀI DO HẾT TIỀN*");
                    break;
                }
            }
        }  while (choice == 1);
    }

    public static int randomXucXac() {
        Random sicBo = new Random();
        System.out.print("Nhấn Enter để khui từng xúc xắc");
        sc.nextLine();
        sc.nextLine();
        int value1 = sicBo.nextInt(6) + 1;
        System.out.print(value1);
        sc.nextLine();
        int value2 = sicBo.nextInt(6) + 1;
        System.out.print(value2);
        sc.nextLine();
        int value3 = sicBo.nextInt(6) + 1;
        System.out.println(value3);
        System.out.println("****** Kết quả: " + value1 + " - " + value2 + " - " + value3);
        return value1 + value2 + value3;
    }
}