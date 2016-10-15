package org.tylubz.model.data;

/**
 * Created by Sergei on 14.10.2016.
 */
public class ProductInfo implements Comparable<ProductInfo>{
    private Float money;
    private Float price;

    public ProductInfo(){}
    public ProductInfo(Float money,Float price) {
        this.money = money;
        this.price = price;
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
        return "ProductInfo{" +
                "money=" + money +
                ", price=" + price +
                '}';
    }
    @Override
    public int compareTo(ProductInfo other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        return this.money.compareTo(other.money);
    }
}
