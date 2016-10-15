package org.tylubz.model.data;

/**
 * Created by Sergei on 14.10.2016.
 */
public class UserInfo{
    private String username;
    private Float money;

    public UserInfo(String username,Float money){
        this.username = username;
        this.money = money;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        return getUsername().equals(userInfo.getUsername());

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
