package org.tylubz.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Entity for user_table table
 *
 * @author Sergei
 */
@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH},//orphanRemoval = true,
            mappedBy = "user",fetch = FetchType.EAGER)
//            mappedBy = "user")
    private List<OrderEntity> orders;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH},
            fetch = FetchType.EAGER)
            //fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address")
    private AddressEntity addressEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public void addOrder(OrderEntity entity){
        orders.add(entity);
        entity.setUser(this);
    }
    public void removeOrder(OrderEntity entity){
       // entity.setUser(null);
        boolean a = this.orders.equals(entity);
        this.orders.remove(entity);
        int f=3;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (getId() != that.getId()) return false;
        if (!getUsername().equals(that.getUsername())) return false;
        if (!getUserType().equals(that.getUserType())) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        if (getSecondName() != null ? !getSecondName().equals(that.getSecondName()) : that.getSecondName() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(that.getBirthDate()) : that.getBirthDate() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        return getPassword().equals(that.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getUserType().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
