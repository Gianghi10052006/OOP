/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._hoangngocgianghi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public void xuatRaFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (BaiHat baihat : this) {
                // Format: maBaiHat,tenBaiHat,thoiLuong,yeuThich,theLoai
                String dong = baihat.maBaiHat + "," +
                             baihat.tenBaiHat + "," +
                             baihat.thoiLuong + "," +
                             baihat.yeuThich + "," +
                             baihat.theLoai;
                bw.write(dong);
                bw.newLine();
            }
            System.out.println("\n>>> Export thanh cong " + this.size() + " bai hat ra file: " + tenFile);
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
} 
