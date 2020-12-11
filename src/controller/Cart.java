package controller;

import model.Client;
import model.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart implements CartController {
    Scanner sc = new Scanner(System.in);
    private final ArrayList<Products> electronicArrayList;
    private static double sumPayments;

    public Cart() {
        electronicArrayList = new ArrayList<>();
    }


    @Override
    public void addToCart() {
        System.out.println("Nhập tên sản phẩm cần mua ");
        String input = sc.nextLine();
        int index = 0;
        double sum = 0;
        for (int i = 0; i < ListProducts.itemArrayList.size(); i++) {
            if (input.equals(ListProducts.itemArrayList.get(i).getProductsName())) {
                System.out.println("Tên sản phẩm cần mua là \n " + ListProducts.itemArrayList.get(i).toString());
                System.out.println("Nhập số lượng cần mua ");
                try {
                    int input1 = Integer.parseInt(sc.nextLine());
                    if (ListProducts.itemArrayList.get(i).getSumAmount() >= input1) {
                        if (electronicArrayList.contains(ListProducts.itemArrayList.get(i))) {
                            Products electronic = electronicArrayList.get(electronicArrayList.indexOf(ListProducts.itemArrayList.get(i)));
                            input1 += electronic.getAmount();
                            electronic.setAmount(input1);
                            sum = (electronic.getPrice() * electronic.getAmount()) - electronic.getPayments();
                            electronic.setPayments(sum);
                            sumPayments += electronic.getPayments();
                        } else {
                            electronicArrayList.add(ListProducts.itemArrayList.get(i));
                            ListProducts.itemArrayList.get(i).setAmount(input1);
                            sum += ListProducts.itemArrayList.get(i).getPrice() * ListProducts.itemArrayList.get(i).getAmount();
                            ListProducts.itemArrayList.get(i).setPayments(sum);
                            sumPayments += ListProducts.itemArrayList.get(i).getPayments();
                            ListProducts.itemArrayList.get(i).setSumAmount(ListProducts.itemArrayList.get(i).getSumAmount() - input1);
                        }
                        index++;
                    } else {
                        System.out.println("Trong kho còn  ^.^ " + ListProducts.itemArrayList.get(i).getSumAmount());
                    }
                    Client client = new Client();
                    System.out.println("Mời nhập thông tin cá nhân ");
                    System.out.println("Họ Tên ");
                    String name = sc.nextLine();
                    client.setName(name);
                    System.out.println("Nhâp Số Điện Thoại ");
                    String phone = sc.nextLine();
                    client.setNumberPhone(phone);
                    System.out.println("Nhập Địa chỉ ");
                    String address = sc.nextLine();
                    client.setAddress(address);
                    String code = "HVNCLC";
                    client.setCodeClient(code + i);
                    ListProducts.itemArrayList.get(i).setClient(client);
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.println("nhập số cơ mà ");
                }
            }
        }
        if (index == 0) {
            System.out.println("không có sản phẩm " + input);
        }
    }


    @Override
    public void show() {
        System.out.println(java.time.LocalDateTime.now() + "\n");
        for (Products e : electronicArrayList) {
            System.out.println(e.toString() + "\n" + "số lượng mua " + e.getAmount());
            System.out.println("Thông tin khách hàng");
            System.out.println("Mã khách hàng " + e.getClient().getCodeClient());
            System.out.println("Tên Khách hàng : " + e.getClient().getName());
            System.out.println("Số điện thoại khách : " + e.getClient().getNumberPhone());
            System.out.println("Địa chỉ chỉ khách  : " + e.getClient().getAddress());
        }
        System.out.println("\nTổng số tiền " + sumPayments + "\n");
    }


    public ArrayList<Products> getElectronicArrayList() {
        return electronicArrayList;
    }
}
