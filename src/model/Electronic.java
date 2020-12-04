package model;

public class Electronic extends Item {
    private String productCode;
    private int sumAmount;

    public Electronic() {}

    public Electronic(String productCode, int amount) {
        this.productCode = productCode;
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
        return "Thông tin sản phẩm " + "\n"+
                "Mã sản phẩm " + getProductCode() +
                "  Tên sản phẩm " + getProductsName() +
                "  Nhà sản xuất "+ getProducer() +
                "  Giá sảm phẩm " + getPrice() ;
    }
}
