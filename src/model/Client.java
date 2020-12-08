package model;

import java.io.Serializable;

public class Client extends People implements Serializable {
    private String codeClient;

    public Client() {}

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeClient == null) ? 0 : codeClient.hashCode());
        return result;
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
