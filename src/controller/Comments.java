package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Comments {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> list = new ArrayList<>();

    public static void comments() {
        System.out.println("Nhập thông tin đánh giá ");
        String cmt = sc.nextLine();
        list.add(cmt);
    }

    public static void showCMT() {
        System.out.println("thông tin đánh giá ");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
