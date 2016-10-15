package org.tylubz.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity for order_table
 *
 * @author Sergei
 */
@Entity
@Table(name = "order_table")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "order_status")
    private String orderStatus;


    @OneToOne(//orphanRemoval=true,cascade = CascadeType.ALL,
            cascade = CascadeType.ALL,
            //fetch = FetchType.LAZY)
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_addressid")
    private AddressEntity address;

    @ManyToOne(//cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
            //fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(//cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER)
            //fetch = FetchType.LAZY)
    @JoinTable(name = "order_has_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<ProductEntity> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public AddressEntity getAddressEntity() {
        return address;
    }

    public void setAddressEntity(AddressEntity address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity entity = (OrderEntity) o;

        if (getId() != entity.getId()) return false;
        if (!getPaymentType().equals(entity.getPaymentType())) return false;
        if (!getDeliveryType().equals(entity.getDeliveryType())) return false;
        if (!getPaymentStatus().equals(entity.getPaymentStatus())) return false;
        if (!getOrderStatus().equals(entity.getOrderStatus())) return false;
        if (!address.equals(entity.address)) return false;
        return getUser().equals(entity.getUser());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getPaymentType().hashCode();
        result = 31 * result + getDeliveryType().hashCode();
        result = 31 * result + getPaymentStatus().hashCode();
        result = 31 * result + getOrderStatus().hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }
}
