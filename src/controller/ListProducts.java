package controller;

import model.Products;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListProducts {
    Scanner sc = new Scanner(System.in);
    public static ArrayList<Products> itemArrayList;

    public ListProducts() {
        itemArrayList = new ArrayList<>();
    }

    public static ArrayList<Products> getItemArrayList() {
        return itemArrayList;
    }

    public void addProducts() {
        Products e = new Products();
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


    public void editWare() {
        System.out.println("nhap ten san pham");
        String name = sc.nextLine();
        int index = 0;
        int temp = 0;
        for (Products electronic : itemArrayList) {
            if (name.equals(electronic.getProductsName())) {
                System.out.println(electronic + "\n so luong san pham con " + electronic.getSumAmount());
                do {
                    System.out.println("Chon chuc nang ");
                    System.out.println("1:Them so luong san pham");
                    System.out.println("2:chinh gia san pham");
                    System.out.println("3:thoat");
                    try {
                        index = Integer.parseInt(sc.nextLine());
                        switch (index) {
                            case 1 -> {
                                System.out.println("nhap so luong can them ");
                                int sl = Integer.parseInt(sc.nextLine());
                                int sum = electronic.getSumAmount();
                                sum += sl;
                                electronic.setSumAmount(sum);
                                System.out.println("so luong sau khi them = " + electronic.getSumAmount());
                            }
                            case 2 -> {
                                System.out.println("Gia cu = " + electronic.getPrice());
                                System.out.println("nhap gia can chinh");
                                double price = Integer.parseInt(sc.nextLine());
                                electronic.setPrice(price);
                                System.out.println("gia sau khi chinh  " + electronic.getPrice());
                            }
                        }
                    } catch (NumberFormatException | NullPointerException e) {
                        System.out.println("nhập vào đê ");
                    }
                } while (index != 3);
                temp++;
            }
            if (temp == 0) {
                System.out.println(" san pham chua co trong kho ");
            }
        }
    }

    public void searchProducts() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Chọn Chức Năng");
            System.out.println("1 : Tìm");
            System.out.println("2 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập Thông Tin Cần Tìm :");
                    String regex = sc.nextLine();
                    int index = 0;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    for (int i = 0; i < itemArrayList.size(); i++) {
                        matcher = pattern.matcher(itemArrayList.get(i).getProductsName());
                        if (matcher.find()) {
                            System.out.println("STT " + i + " : " + itemArrayList.get(i));
                            index++;
                        }
                    }
                    if (index <= 0) {
                        System.out.println("Tên này không có trong danh sách\n ");
                    }
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Nhâp vào đê ");
            }
        } while (n != 2);
    }


    public void sortByPrice() {
        itemArrayList.sort(new SortByPrice());
        for (int i = 0; i < itemArrayList.size(); i++) {
            System.out.println("Sản phẩm được sắp xếp theo giá "+itemArrayList.get(i).toString());
        }

    }


    public static void showProducts() {
        getItemArrayList().sort(new SortProductsByName());
        for (int i = 0; i < itemArrayList.size(); i++) {
            System.out.println("STT " + i + "  " + itemArrayList.get(i));
        }
    }

}