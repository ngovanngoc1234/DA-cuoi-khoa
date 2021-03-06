package view;

import service.Cart;
import service.Comments;
import service.ListProducts;
import service.ListUser;
import model.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ListProducts listProducts = new ListProducts();
        Cart cart = new Cart();
        ListUser listUser = new ListUser();
        int cases = 0;
        do {
            listProducts.readDataFromFile();
            listProducts.writeToFile();
            System.out.println("1: Đăng Nhập ");
            System.out.println("2: Đăng Ký ");
            System.out.println("3: Chưa có Tài Khoản ");
            System.out.println("4: exit");
            try {
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1 -> {
                        User user = listUser.checkUser();
                        if (user.getRole() == 0) {
                            int n = 0;
                            do {
                                listProducts.showProducts();
                                System.out.println("Mời chọn chức năng ");
                                System.out.println("1: Tìm kiếm sản phẩm ");
                                System.out.println("2: Sắp Xếp giá sản phẩm ");
                                System.out.println("3: Chọn mua sản phẩm ");
                                System.out.println("4: xem hóa đơn sản phẩm ");
                                System.out.println("5: Đánh giá góp ý");
                                System.out.println("6: Thông tin tài khoản ");
                                System.out.println("7: Thoát");
                                try {
                                    n = Integer.parseInt(sc.nextLine());
                                    switch (n) {
                                        case 1 -> listProducts.searchProducts();
                                        case 2 -> listProducts.sortByPrice();
                                        case 3 -> cart.addToCart();
                                        case 4 -> cart.show();
                                        case 5 -> {
                                            Comments.comments();
                                        }
                                        case 6 -> {
                                            int number = 0;
                                            do {
                                                System.out.println("chọn chức năng ");
                                                System.out.println("1: xem thông tin tài khoản ");
                                                System.out.println("2: chỉnh sửa thông tin người dùng ");
                                                System.out.println("3: thoát");
                                                try {
                                                    number = Integer.parseInt(sc.nextLine());
                                                    switch (number) {
                                                        case 1 -> listUser.show();
                                                        case 2 -> listUser.edit();
                                                    }
                                                } catch (NullPointerException | NumberFormatException e) {
                                                    System.out.println("nhập lại đi ");
                                                }
                                            } while (number != 3);
                                        }
                                    }
                                } catch (NumberFormatException | NullPointerException e) {
                                    System.out.println("mời nhập lại ");
                                }
                            } while (n != 7);
                        } else if (user.getRole() == 1) {
                            int n = 0;
                            do {
                                System.out.println("Mời chọn chức năng ");
                                System.out.println("1: Thêm sản phẩm ");
                                System.out.println("2: Tìm kiếm sản phẩm ");
                                System.out.println("3: Nhập kho sản phẩm ");
                                System.out.println("4: sắp xếp giá sản phẩm ");
                                System.out.println("5: Quản lý thông tin người dùng ");
                                System.out.println("6: Thông tin đánh giá của người dùng ");
                                System.out.println("7: Thoát");
                                try {
                                    n = Integer.parseInt(sc.nextLine());
                                    switch (n) {
                                        case 1 -> listProducts.addProducts();
                                        case 2 -> listProducts.searchProducts();
                                        case 3 -> listProducts.editWare();
                                        case 4 -> listProducts.showProducts();
                                        case 5 -> {
                                            int number = 0;
                                            do {
                                                System.out.println("Chọn chức năng");
                                                System.out.println("1: Hiện thị người dùng ");
                                                System.out.println("2: xóa người dùng ");
                                                System.out.println("3: Thêm người dùng ");
                                                System.out.println("4: thoát ");
                                                try {
                                                    number = Integer.parseInt(sc.nextLine());
                                                    switch (number) {
                                                        case 1 -> listUser.show();
                                                        case 2 -> listUser.deleter();
                                                        case 3 -> listUser.addInfos();
                                                    }
                                                } catch (NumberFormatException | NullPointerException e) {
                                                    System.out.println("nhập lại đi");
                                                }
                                            } while (number != 4);
                                        }
                                        case 6 -> {
                                            Comments.showCMT();
                                        }
                                    }
                                } catch (NullPointerException | NumberFormatException e) {
                                    System.out.println("nhập lại đê");
                                }
                            } while (n != 7);
                        }
                    }
                    case 2 -> listUser.addInfos();
                    case 3 -> {
                        int num = 9;
                        do {
                            System.out.println("Mời chọn chức năng ");
                            System.out.println("1: Tìm kiếm sản phẩm ");
                            System.out.println("2: Sắp Xếp giá sản phẩm ");
                            System.out.println("3: Chọn mua sản phẩm ");
                            System.out.println("4: xem hóa đơn sản phẩm ");
                            System.out.println("5: Thoát");
                            try {
                                num = Integer.parseInt(sc.nextLine());
                                switch (num) {
                                    case 1 -> listProducts.searchProducts();
                                    case 2 -> listProducts.sortByPrice();
                                    case 3 -> cart.addToCart();
                                    case 4 -> cart.show();
                                }
                            } catch (NullPointerException | NumberFormatException e) {
                                System.out.println("nhạp lại ");
                            }
                        } while (num != 5);
                    }
                }
            } catch (Exception e) {
                System.out.println("mời chọn chức năng ");
            }
        } while (cases != 4);
    }
}