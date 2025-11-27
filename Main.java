/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._hoangngocgianghi;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DanhSachBaiHat baihatList = new DanhSachBaiHat();
        Menu menu = new Menu("Chao ban da den voi kenh bai hat hay");
        menu.addItem("Hien thi danh sach truyen");
        menu.addItem("Sap xep theo ten");
        menu.addItem("Sap xep theo ten va thoi luong");
        menu.addItem("Them bai hat moi");
        menu.addItem("Xoa Bai hat");
        menu.addItem("Thoat");
        
        baihatList.nhapTuFile("DanhSachBaiHat.txt");

        while (true) {
            int choice = menu.getChoice();
            switch (choice) {
                case 1 -> baihatList.output();
                
                case 2 -> {
                    baihatList.sapXepTheoTen();
                    baihatList.output();
                }
                
                case 3 -> {
                    baihatList.sapXepTheoTenVaThoiLuong();
                    baihatList.output();
                }
                
                case 4 -> {
                    
                }
                case 5 -> {

                }
                
                case 6 -> {

                }
                
                case 7 -> {

                }
                
                case 8 -> {
                    System.out.print("\nNhap ten file de doc (VD: data.txt): ");
                    String tenFile = sc.nextLine();
                    baihatList.nhapTuFile(tenFile);
                    baihatList.output();
                }
                
                case 9 -> {
                    System.out.print("\nNhap ten file de ghi (VD: data.txt): ");
                    String tenFile = sc.nextLine();
                    baihatList.xuatRaFile(tenFile);
                }
                
                case 10 -> {
                    System.out.println("\n=== DANH SACH BAI HAT YEU THICH ===");
                    System.out.printf("%-10s %-30s %-12s %-12s %-10s%n", 
                         "Ma BH", "Ten Bai Hat", "Thoi Luong", "Yeu Thich", "The Loai");
                    System.out.println("------------------------------------------------------------------------");
                    boolean found = false;
                    for (BaiHat bh : baihatList) {
                        if (bh.yeuThich) {
                            bh.output();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Khong co bai hat yeu thich nao.");
                }
                
                default -> {
                    Menu.sayBye();
                    return;
                }
            }
            
            System.out.println("\nNhan Enter de tiep tuc...");
            sc.nextLine();
        }
    }

}

