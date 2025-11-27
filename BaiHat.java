/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._hoangngocgianghi;

/**1
 *
 * @author hoang
 */
public class BaiHat implements Comparable<BaiHat> {
    public int maBaiHat;
    public String tenBaiHat;
    public double thoiLuong;
    public boolean yeuThich;
    public char theLoai;

    public BaiHat(int maBaiHat, String tenBaiHat, double thoiLuong, boolean yeuThich, char theLoai) {
        this.maBaiHat = maBaiHat;
        this.tenBaiHat = tenBaiHat;
        this.thoiLuong = thoiLuong;
        this.yeuThich = yeuThich;
        this.theLoai = theLoai;
    }
    
    public void output() {
    System.out.printf("%-10d %-30s %-12.2f %-12s %-10c%n",  maBaiHat, tenBaiHat, thoiLuong, (yeuThich ? "Co" : "Khong"), theLoai);
}
     @Override
    public int compareTo(BaiHat other) {
        return this.tenBaiHat.compareToIgnoreCase(other.tenBaiHat);
    }
}
