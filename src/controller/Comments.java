package controller;

import model.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Comments implements Serializable {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<String> getList() {
        return list;
    }

    public static void setList(ArrayList<String> list) {
        Comments.list = list;
    }

    public static ArrayList<String> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("comments.dat");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        setList((ArrayList<String>) (ojb.readObject()));
        ojb.close();
        fileInputStream.close();
        return getList();
    }


    public static void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("comments.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(getList());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static void comments() throws IOException, ClassNotFoundException {
        setList(readFile());
        System.out.println("Nhập thông tin đánh giá ");
        String cmt = sc.nextLine();
        list.add(cmt);
    }

    public static void showCMT() throws IOException, ClassNotFoundException {
        writeToFile();
        readFile();
        System.out.println("thông tin đánh giá ");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
