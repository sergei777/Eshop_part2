package org.tylubz.model.data;

/**
 * Created by Sergei on 14.10.2016.
 */
public class ProductInfoWrapper {
    private String productName;
    private Float money;
    private Float price;


    public ProductInfoWrapper(){};

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductInfoWrapper{" +
                "productName='" + productName + '\'' +
                ", money=" + money +
                ", price=" + price +
                '}';
    }
}
