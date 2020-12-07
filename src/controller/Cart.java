package controller;

import model.Electronic;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Electronic> electronicArrayList;
    private static double sumPayments;


    public Cart() {
        electronicArrayList = new ArrayList<>();
    }


    public void addToCart() {
        System.out.println("Nhập tên sản phẩm cần mua ");
        String input = sc.nextLine();
        int index = 0;
        double sum = 0;
        for (int i = 0; i < ListProducts.itemArrayList.size(); i++) {
            if (input.equals(ListProducts.itemArrayList.get(i).getProductsName())) {
                System.out.println("Tên sản phẩm cần mua là \n " + ListProducts.itemArrayList.get(i).toString());
                System.out.println("Nhập số lượng cần mua ");
                int input1 = Integer.parseInt(sc.nextLine());
                if (ListProducts.itemArrayList.get(i).getSumAmount() >= input1) {
                    if (electronicArrayList.contains(ListProducts.itemArrayList.get(i))) {
                        Electronic electronic = electronicArrayList.get(electronicArrayList.indexOf(ListProducts.itemArrayList.get(i)));
                        input1 += electronic.getAmount();
                        electronic.setAmount(input1);
                        sum = (electronic.getPrice() * electronic.getAmount()) - electronic.getPayments();
                        electronic.setPayments(sum);
                        sumPayments += electronic.getPayments();
                        index++;
                    } else {
                        electronicArrayList.add(ListProducts.itemArrayList.get(i));
                        ListProducts.itemArrayList.get(i).setAmount(input1);
                        sum += ListProducts.itemArrayList.get(i).getPrice() * ListProducts.itemArrayList.get(i).getAmount();
                        ListProducts.itemArrayList.get(i).setPayments(sum);
                        sumPayments += ListProducts.itemArrayList.get(i).getPayments();
                        ListProducts.itemArrayList.get(i).setSumAmount(ListProducts.itemArrayList.get(i).getSumAmount() - input1);
                        index++;
                    }
                } else {
                    System.out.println("Trong kho còn  ^.^ " + ListProducts.itemArrayList.get(i).getSumAmount());
                }

            }
        }
        if (index == 0) {
            System.out.println("không có sản phẩm " + input);
        }
    }

    public void show() {
        for (Electronic e : electronicArrayList) {
            System.out.println(e.toString() + "\n" + "số lượng mua " + e.getAmount() + "\n");
        }
        System.out.println("Tổng số tiền " + sumPayments + "\n");
    }


    public ArrayList<Electronic> getElectronicArrayList() {
        return electronicArrayList;
    }
}
