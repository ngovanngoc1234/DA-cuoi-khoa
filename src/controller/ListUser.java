package controller;

import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListUser implements UserController{
    Scanner sc = new Scanner(System.in);
    private static ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    public User checkUser() {
        User user = null;
        User user1 = new User("admin", "ngoc", User.ADMIN_ROLE);
        User users = new User("user", "ngovanngoc", User.USER_ROLE);
        userArrayList.add(user1);
        userArrayList.add(users);
        try {
            System.out.println("-----Thông Tin Đăng Nhập-----");
            System.out.println("Tên tài khoản");
            String name = sc.nextLine();
            System.out.println("Mật khẩu");
            String passWord = sc.nextLine();
            for (User user5 : userArrayList) {
                if (name.equals(user5.getYouName()) && passWord.equals(user5.getPassword())) {
                    System.out.println("----Đăng Nhập Thành Công----");
                    return user = user5;
                }
            }
            System.out.println("Sai tài khoản hoặc mật khẩu");
        } catch (Exception e) {
            System.out.println("Nhập vào đê ");
        }
        return null;
    }


    public void addInfos() {
        //doc file gan vao bien list user
        int number = 0;
        do {
            System.out.println("1: Thêm tài khoản mới");
            System.out.println("2: Thoát ");
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number == 1) {
                    User user = new User();
                    System.out.println("Mời Nhập Thông Tin ");
                    user.createAccount();
                    int index = 0;
                    for (User value : userArrayList) {
                        if (user.getYouName().equals(value.getYouName())) {
                            index++;
                        }
                    }
                    if (index == 0) {
                        userArrayList.add(user);
                        System.out.println("Thêm thành công ");
                    } else {
                        System.out.println("Tài khoản đã tồn tại");
                    }
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Nhập vào đi");
            }
        } while (number != 2);
        //ghi vao file
    }

    @Override
    public void show() {
        for (User u : userArrayList) {
            System.out.println(u.toString());
        }
    }

    @Override
    public void edit() {
        int n = 0;
        do {
            System.out.println("chọn chức năng ");
            System.out.println("1: Đổi password ");
            System.out.println("2: Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập lại password cũ ");
                    String pass = sc.nextLine();
                    for (User user : userArrayList) {
                        if (pass.equals(user.getPassword())) {
                            System.out.println("Nhập password mới ");
                            String password = sc.nextLine();
                            System.out.println("Xác Nhận Lại password ");
                            String passwords = sc.nextLine();
                            if (password.equals(passwords)) {
                                user.setPassword(passwords);
                            } else {
                                System.out.println("Xác Nhận password sai ");
                            }
                        }
                    }
                }
            }catch (NumberFormatException|NullPointerException e) {
                System.out.println("nhập lại đi ");
            }
        } while (n != 3);

    }

    @Override
    public void deleter() {
        System.out.println("nhập thông tin người dùng cần xóa");
        String name = sc.nextLine();
        int index = 0;
        for (int i = 0; i < userArrayList.size(); i++) {
            if (name.equals(userArrayList.get(i).getYouName())) {
                System.out.println("thông tin tài khoản đã xóa " + userArrayList.get(i).toString());
                userArrayList.remove(userArrayList.get(i));
                index++;
            }
        }
        if (index == 0) {
            System.out.println("người dùng không tồn tại ");
        }
    }
}
