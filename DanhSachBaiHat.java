/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._hoangngocgianghi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class DanhSachBaiHat extends ArrayList<BaiHat> {
//    public void output(){
//    for(BaiHat baihat : this)
//                baihat.output();
//}
     // 1. Hien thi danh sach bai hat (khong sap xep)
    public void output() {
        System.out.println("\n=== DANH SACH BAI HAT ===");
        System.out.printf("%-10s %-30s %-12s %-12s %-10s%n", 
                         "Ma BH", "Ten Bai Hat", "Thoi Luong", "Yeu Thich", "The Loai");
        System.out.println("------------------------------------------------------------------------");
        for (BaiHat baihat : this) {
            baihat.output();
        }
    }
   
    //2.
    public void sapXepTheoTen() {
        Collections.sort(this);
        System.out.println("\n>>> Da sap xep theo ten bai hat!");
}
    
    // 3. Sap xep theo ten va thoi luong
    public void sapXepTheoTenVaThoiLuong() {
        Collections.sort(this, new Comparator<BaiHat>() {
            @Override
            public int compare(BaiHat bh1, BaiHat bh2) {
                // Sap xep theo ten truoc
                int soSanhTen = bh1.tenBaiHat.compareToIgnoreCase(bh2.tenBaiHat);
                if (soSanhTen != 0) {
                    return soSanhTen;
                }
                // Neu ten giong nhau thi sap xep theo thoi luong
                return Double.compare(bh1.thoiLuong, bh2.thoiLuong);
            }
        });
        System.out.println("\n>>> Da sap xep theo ten va thoi luong!");
    }
    
// 4. Them bai hat moi (Khong tham so)
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- THEM BAI HAT MOI ---");
        try {
            System.out.print("Nhap ma bai hat: ");
            int ma = Integer.parseInt(sc.nextLine());

            System.out.print("Nhap ten bai hat: ");
            String ten = sc.nextLine();

            System.out.print("Nhap thoi luong: ");
            double thoiLuong = Double.parseDouble(sc.nextLine());

            System.out.print("Yeu thich (true/false): ");
            boolean yeuThich = Boolean.parseBoolean(sc.nextLine());

            System.out.print("The loai (1 ky tu): ");
            char theLoai = sc.nextLine().charAt(0);

            BaiHat bhMoi = new BaiHat(ma, ten, thoiLuong, yeuThich, theLoai);
            this.add(bhMoi);
            System.out.println(">>> Da them moi thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi nhap lieu! Vui long thu lai.");
        }
    }

    // 5. Sua bai hat (Khong tham so)
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap MA bai hat can sua: ");
        try {
            int maTimKiem = Integer.parseInt(sc.nextLine());
            boolean timThay = false;
            
            for (BaiHat bh : this) {
                if (bh.maBaiHat == maTimKiem) {
                    System.out.println("Tim thay: " + bh.tenBaiHat);
                    System.out.print("Nhap ten moi: ");
                    bh.tenBaiHat = sc.nextLine();
                    
                    System.out.print("Nhap thoi luong moi: ");
                    bh.thoiLuong = Double.parseDouble(sc.nextLine());
                    
                    System.out.print("Yeu thich (true/false): ");
                    bh.yeuThich = Boolean.parseBoolean(sc.nextLine());
                    
                    System.out.println(">>> Da cap nhat xong!");
                    timThay = true;
                    break;
                }
            }
            if (!timThay) System.out.println("Khong tim thay ma: " + maTimKiem);
        } catch (Exception e) {
            System.out.println("Nhap sai dinh dang!");
        }
    }

    // 6. Xoa bai hat (Khong tham so)
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap MA bai hat can xoa: ");
        try {
            int maXoa = Integer.parseInt(sc.nextLine());
            BaiHat canXoa = null;
            
            for (BaiHat bh : this) {
                if (bh.maBaiHat == maXoa) {
                    canXoa = bh;
                    break;
                }
            }
            
            if (canXoa != null) {
                this.remove(canXoa);
                System.out.println(">>> Da xoa bai hat ma " + maXoa);
            } else {
                System.out.println("Khong tim thay bai hat de xoa!");
            }
        } catch (Exception e) {
            System.out.println("Nhap sai dinh dang!");
        }
    }

    // 8. Import bai hat tu file 
    public void nhapTuFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().equals("")) continue;
                String arr[] = line.split("[,]+");

                BaiHat baihat = new BaiHat(Integer.parseInt(arr[0].trim()), arr[1].trim(),Double.parseDouble(arr[2].trim()),Boolean.parseBoolean(arr[3].trim()),arr[4].trim().charAt(0));
                this.add(baihat);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} 
