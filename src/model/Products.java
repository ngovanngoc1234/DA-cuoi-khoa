package model;

public class Products extends Item {
    private String productCode;
    private int sumAmount;
    private int amount;
    private double payments;
    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public Products() {
    }

    public Products(String productCode, int sumAmount, int amount, double payments, Client client) {
        this.productCode = productCode;
        this.sumAmount = sumAmount;
        this.amount = amount;
        this.payments = payments;
        this.client = client;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
        return result;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    public int getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(int sumAmount) {
        this.sumAmount = sumAmount;
    }

    @Override
    public String toString() {
        return "Thông tin sản phẩm " + "\n" +
                "Mã sản phẩm " + getProductCode() +
                "  Tên sản phẩm " + getProductsName() +
                "  Nhà sản xuất " + getProducer() +
                "  Giá sảm phẩm " + getPrice();

    }
}
