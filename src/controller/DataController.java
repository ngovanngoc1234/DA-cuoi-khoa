package controller;

import model.Products;

import java.io.IOException;
import java.util.ArrayList;

public interface DataController {
    <T> void writeToFile()throws IOException;
    <T> ArrayList<Products> readDataFromFile()throws IOException, ClassNotFoundException ;

}
