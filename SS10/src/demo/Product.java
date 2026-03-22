package demo;

import java.time.LocalDate;

public class Product {
    private int proId;
    private String proName;
    private LocalDate expireDate;
    private double price;

    public Product() {
    }

    public Product(int proId, String proName, LocalDate expireDate, double price) {
        this.proId = proId;
        this.proName = proName;
        this.expireDate = expireDate;
        this.price = price;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", expireDate=" + expireDate +
                ", price=" + price +
                '}';
    }
}

