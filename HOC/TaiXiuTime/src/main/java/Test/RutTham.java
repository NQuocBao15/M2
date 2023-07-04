package Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RutTham {
    static RutTham rutTham = new RutTham();
    static Scanner sc = new Scanner(System.in);
    Set<String> thungPhieuDuThuong = new HashSet<>();

    public RutTham() {
    }
    public boolean themPhieu(String giaTri) {
        return this.thungPhieuDuThuong.add(giaTri);
    }
    public boolean xoaPhieu(String giaTri) {
        return this.thungPhieuDuThuong.remove(giaTri);
    }
    public boolean kiemTraPhieuTonTai(String giaTri) {
        return this.thungPhieuDuThuong.contains(giaTri);
    }
    public void xoaTatCaPhieuDuThuong() {
        this.thungPhieuDuThuong.clear();
    }
    public int laySoLuong() {
        return this.thungPhieuDuThuong.size();
    }
    public String rutMotPhieu() {
        String ketQua;
        Random rd = new Random();
        int viTri = rd.nextInt(this.thungPhieuDuThuong.size()-1);
        ketQua = (String) this.thungPhieuDuThuong.toArray()[viTri];
        return ketQua;
    }


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("______MENU______");
            System.out.println("1. Them ma so du thuong");
            System.out.println("2. Xoa ma so du thuong");
            System.out.println("3. Kiem tra ma so du thuong co ton tai hay khong");
            System.out.println("4. Xoa tat ca cac phieu du thuong");
            System.out.println("5. So luong phieu du thuong");
            System.out.println("6. Rut tham trung thuong");
            System.out.println("0. Thoat khoi chuong trinh");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    rutTham.themPhieuDuThuong();
                    break;
                case 2:
                    rutTham.xoaPhieuDuThuong();
                    break;
                case 3:
                    rutTham.kiemTraPhieuDuThuong();
                    break;
                case 4:
                    rutTham.xoaTatCaPhieuDuThuong();
                    System.out.println("Da xoa tat ca phieu du thuong");
                    break;
                case 5:
                    System.out.println("So luong phieu du thuong: " + rutTham.laySoLuong());
                    break;
            }
        } while (choice != 0);
    }

    public void themPhieuDuThuong() {
        System.out.println("Nhap ma phieu du thuong: ");
        String giaTri = sc.nextLine();
        themPhieu(giaTri);
        System.out.println("Da them phieu du thuong");
    }

    public void xoaPhieuDuThuong() {
        System.out.println("Nhap ma phieu du thuong");
        String giaTri = sc.nextLine();
        xoaPhieu(giaTri);
        System.out.println("Da xoa phieu du thuong");
    }

    public void kiemTraPhieuDuThuong() {
        System.out.println("Nhap ma phieu du thuong");
        String giaTri = sc.nextLine();
        System.out.println("Ket qua kiem tra: " + kiemTraPhieuTonTai(giaTri));
    }
}
