package model;

public class Item {
    private String productsName;
    private double price;
    private String producer;

    public Item() {}

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Item(String productsName, double price, String producer) {
        this.productsName = productsName;
        this.price = price;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productsName='" + productsName + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                '}';
    }
}
