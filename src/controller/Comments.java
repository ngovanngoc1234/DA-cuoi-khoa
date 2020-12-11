package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void csvFile() {
        String fileName = "comments.csv";
        writeCsvFile(fileName);
    }

    public static void writeCsvFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName,true);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (String s : list) {
                fileWriter.append(s);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Góp ý thành công !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }


    public static void csvReader() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("comments.csv"));
            while ((line = br.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }


    public static ArrayList<String> parseCsvLine(String csvLine) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            stringArrayList.addAll(Arrays.asList(splitData));
        }
        return stringArrayList;
    }


    public static void printCountry(ArrayList<String> country) {
        for (String s : country) {
            System.out.println(s);
        }
    }


    public static void comments() {
        csvFile();
        System.out.println("Nhập thông tin đánh giá ");
        String cmt = sc.nextLine();
        list.add(cmt);
    }


    public static void showCMT(){
        csvReader();
        System.out.println("thông tin đánh giá ");
        for (String s : list) {
            System.out.println(s + "\n");
        }
        System.out.println("Đang phát triển \n");
    }

}