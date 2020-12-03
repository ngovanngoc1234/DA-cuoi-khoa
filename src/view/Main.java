package view;

import controller.Cart;
import controller.ListProducts;
import model.Electronic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListProducts listProducts = new ListProducts();
        Cart cart = new Cart();
        int input = 9;
        do {
            System.out.println(" mời chọn chức năng");
            System.out.println("1: Thêm mới sản phẩm");
            System.out.println("2: xem sản phẩm ");
            System.out.println("3: chọn mua sản phẩm ");
            System.out.println("4: hiện thị giỏ hàng ");
            input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    listProducts.addProducts();
                    break;
                case 2:
                    listProducts.showProducts();
                    break;
                case 3:
                    cart.addToCart();
                    break;
                case 4:
                    cart.show();
                    break;
            }
        } while (input != 5);


    }
}
