/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._hoangngocgianghi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Menu {
    private final String BaiHat;
List<String> list = new ArrayList<>();

    public Menu(String BaiHat) {
        this.BaiHat = BaiHat;
    }

    public void addItem(String element) {
        list.add(element);
    }

    public static void sayBye() {
        System.out.println("Huhu dung bo di ma");
    }

    public int getChoice() {
        int rs = 0;
        try {
            display();
            System.out.println("Vui long chon mot chuc nang: ");
            Scanner sc = new Scanner(System.in);
            rs = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("So khong hop le!");
        }
        return rs;
    }

    public void display(){
        System.out.println("\n*** " + BaiHat + " ***"); 
        int index = 1; 
        for (String element : list) {
            System.out.println(index + ". " + element);
            index++; 
        }
    }
}
