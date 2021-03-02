package repository;

import model.Products;

import java.io.IOException;
import java.util.ArrayList;

public interface IDataProduct {

    void writeToFile() throws IOException;
    ArrayList<Products> readDataFromFile() throws IOException, ClassNotFoundException;

}
