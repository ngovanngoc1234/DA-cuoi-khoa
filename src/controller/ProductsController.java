package controller;

import java.io.IOException;

public interface ProductsController {
    void addProducts()throws IOException, ClassNotFoundException;
    void editWare();
    void searchProducts();
    void showProducts()throws IOException, ClassNotFoundException;
}
