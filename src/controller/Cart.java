package controller;

import model.Electronic;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Electronic> electronicArrayList;
    private static double payments;


    public Cart() {
        electronicArrayList = new ArrayList<>();
    }


    public void addToCart() {
        System.out.println("Nhập tên sản phẩm cần mua ");
        String input = sc.nextLine();
        int j = 0;
        for (int i = 0; i < ListProducts.itemArrayList.size(); i++) {
            if (input.equals(ListProducts.itemArrayList.get(i).getProductsName())) {
                System.out.println("Tên sản phẩm cần mua là \n " + ListProducts.itemArrayList.get(i).toString());
                System.out.println("Nhập số lượng cần mua ");
                int input1 = Integer.parseInt(sc.nextLine());
                electronicArrayList.add(ListProducts.itemArrayList.get(i));
                ListProducts.itemArrayList.get(i).setAmount(input1);
                payments += ListProducts.itemArrayList.get(i).getPrice() * ListProducts.itemArrayList.get(i).getAmount();
                ListProducts.itemArrayList.get(i).setSumAmount(ListProducts.itemArrayList.get(i).getSumAmount() - input1);
                j++;
                break;
            } else {
                if (electronicArrayList.contains(ListProducts.itemArrayList.get(i))) {
                    Electronic electronic = electronicArrayList.get(electronicArrayList.indexOf(ListProducts.itemArrayList.get(i)));
                    electronic.setAmount(electronic.getAmount() + ListProducts.itemArrayList.get(i).getAmount());
                    payments += electronic.getPrice() * electronic.getAmount();
                } else {
                    electronicArrayList.add(ListProducts.itemArrayList.get(i));
                }
            }
        }
        if (j == 0) {
            System.out.println("không có sản phẩm " + input);
        }

    }

    public void show() {
        for (Electronic e : electronicArrayList) {
            System.out.println(e.toString() + "\n" + "Tổng số tiền " + payments + "\n");
        }
    }

    public ArrayList<Electronic> getElectronicArrayList() {
        return electronicArrayList;
    }
}
