package controller;

import model.Electronic;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Electronic> electronicArrayList;
    private static double payments;
    private static double amount;


    public Cart() {
        electronicArrayList = new ArrayList<>();
    }


    public void addToCart() {
        System.out.println("Nhập tên sản phẩm cần mua ");
        String input = sc.nextLine();
        int index = 0;
        for (int i = 0; i < ListProducts.itemArrayList.size(); i++) {
            if (input.equals(ListProducts.itemArrayList.get(i).getProductsName())) {
                System.out.println("Tên sản phẩm cần mua là \n " + ListProducts.itemArrayList.get(i).toString());
                System.out.println("Nhập số lượng cần mua ");
                int input1 = Integer.parseInt(sc.nextLine());
                if (electronicArrayList.contains(ListProducts.itemArrayList.get(i))) {
                    Electronic electronic = electronicArrayList.get(electronicArrayList.indexOf(ListProducts.itemArrayList.get(i)));
                    amount += input1;
                    payments = electronic.getPrice() * amount;
                    index++;
                } else {
                    electronicArrayList.add(ListProducts.itemArrayList.get(i));
                    amount += input1;
                    payments += ListProducts.itemArrayList.get(i).getPrice() * amount;
                    ListProducts.itemArrayList.get(i).setSumAmount(ListProducts.itemArrayList.get(i).getSumAmount() - input1);
                    index++;

                }

            }
        }
        if (index == 0) {
            System.out.println("không có sản phẩm " + input);
        }

    }

    public void show() {
        for (Electronic e : electronicArrayList) {
            System.out.println(e.toString() + "\n" + "số lượng mua " + amount + "\n" + "Tổng số tiền " + payments + "\n");
        }
    }

    public void addProducts(Electronic e) {
        if (electronicArrayList.contains(e)) {
            Electronic electronic = electronicArrayList.get(electronicArrayList.indexOf(e));
            amount += amount;
            payments += electronic.getPrice() * amount;
        } else {
            electronicArrayList.add(e);
        }
    }


    public ArrayList<Electronic> getElectronicArrayList() {
        return electronicArrayList;
    }
}
