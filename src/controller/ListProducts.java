package controller;

import model.Electronic;

import java.util.ArrayList;
import java.util.Scanner;

public class ListProducts {
    Scanner sc = new Scanner(System.in);
    public static ArrayList<Electronic> itemArrayList;

    public ListProducts() {
        itemArrayList = new ArrayList<>();
    }

    public ArrayList<Electronic> getItemArrayList() {
        return itemArrayList;
    }

    public void addProducts() {
        Electronic e = new Electronic();
        System.out.println("Nhập mã sản phẩm ");
        String m = sc.nextLine();
        e.setProductCode(m);
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        e.setProductsName(name);
        System.out.println("Nhập Nhà sản xuất");
        String nsx = sc.nextLine();
        e.setProducer(nsx);
        System.out.println("Nhập Giá sản phẩm ");
        double price = Integer.parseInt(sc.nextLine());
        e.setPrice(price);
        System.out.println("Nhập số lượng sản phẩm");
        int amount = Integer.parseInt(sc.nextLine());
        e.setSumAmount(amount);
        itemArrayList.add(e);
    }


    public void showProducts() {
        for (Electronic e:itemArrayList) {
            System.out.println(e.toString());
        }
    }

}
