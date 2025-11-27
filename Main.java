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
        menu.addItem("Sua Bai hat");        
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
                    baihatList.them();
                }
                case 5 -> {
                    baihatList.sua();
                }
                case 6 -> {
                    baihatList.xoa();
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

