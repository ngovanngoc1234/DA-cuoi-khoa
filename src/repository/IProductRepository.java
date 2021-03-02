package repository;

import java.io.IOException;

public interface IProductRepository {
    void addProducts()throws IOException, ClassNotFoundException;
    void editWare();
    void searchProducts();
    void showProducts()throws IOException, ClassNotFoundException;
}
