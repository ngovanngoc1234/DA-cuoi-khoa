package view;

import controller.Cart;
import controller.Comments;
import controller.ListProducts;
import controller.ListUser;
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
            System.out.println("1: Đăng Nhập ");
            System.out.println("2: Đăng Ký ");
            System.out.println("3: exit");
            cases = Integer.parseInt(sc.nextLine());
            switch (cases) {
                case 1:
                    User user = listUser.checkUser();
                    if (user.getRole() == 0) {
                        int n = 0;
                        do {
                            System.out.println("Mời chọn chức năng ");
                            System.out.println("1: Tìm kiếm sản phẩm ");
                            System.out.println("2: Sắp Xếp giá sản phẩm ");
                            System.out.println("3: Chọn mua sản phẩm ");
                            System.out.println("4: xem hóa đơn sản phẩm ");
                            System.out.println("5: Đánh giá góp ý");
                            System.out.println("6: Thoát");
                            n = Integer.parseInt(sc.nextLine());
                            ListProducts.showProducts();
                            switch (n) {
                                case 1:
                                    listProducts.searchProducts();
                                    break;
                                case 2:
                                    listProducts.sortByPrice();
                                    break;
                                case 3:
                                    cart.addToCart();
                                    break;
                                case 4:
                                    cart.show();
                                    break;
                                case 5:
                                    Comments.comments();
                            }
                        } while (n != 6);
                    } else if (user.getRole() == 1) {
                        int n = 0;
                        do {
                            System.out.println("Mời chọn chức năng ");
                            System.out.println("1: Thêm sản phẩm ");
                            System.out.println("2: Tìm kiếm sản phẩm ");
                            System.out.println("3: Nhập kho sản phẩm ");
                            System.out.println("4: sắp xếp giá sản phẩm ");
                            System.out.println("5: Quản lý thông tin người dùng ");
                            System.out.println("6 Thoát");
                            n = Integer.parseInt(sc.nextLine());
                            switch (n) {
                                case 1:
                                    listProducts.addProducts();
                                    break;
                                case 2:
                                    listProducts.searchProducts();
                                    break;
                                case 3:
                                    listProducts.editWare();
                                    break;
                                case 4:
                                    listProducts.sortByPrice();
                                    break;
                                case 5:
                                    int number = 0;
                                    do {
                                        System.out.println("Chọn chức năng");
                                        System.out.println("1: Hiện thị người dùng ");
                                        System.out.println("2: xóa người dùng ");
                                        System.out.println("3: Thêm người dùng ");
                                        System.out.println("4: thoát ");
                                        number = Integer.parseInt(sc.nextLine());
                                        switch (number) {
                                            case 1:
                                                listUser.showUser();
                                                break;
                                            case 2:
                                                listUser.deleter();
                                                break;
                                            case 3:
                                                listUser.addInfos();
                                                break;
                                        }
                                    } while (number != 4);
                            }
                        } while (n != 4);
                    }
                    break;
                case 2:
                    listUser.addInfos();
                    break;
            }
        } while (cases != 3);
    }
}