package model;

public class Client extends People {
    private String codeClient;

    public Client() {
    }

    public Client(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    @Override
    public String toString() {
        return "Thông tin khách hàng  " +
                "Họ tên " + getName() +
                "Tuổi " + getAge() +
                "Số điện thoại " + getNumberPhone() +
                "Địa chỉ " + getAddress() +
                "Email " + getEmail();
    }
}
