package org.tylubz.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.model.data.ProductInfo;
import org.tylubz.model.data.ProductInfoWrapper;
import org.tylubz.model.data.UserInfo;
import org.tylubz.model.entity.OrderEntity;
import org.tylubz.model.entity.ProductEntity;
import org.tylubz.service.interfaces.OrderService;

import java.util.*;


/**
 * Created by Sergei on 11.10.2016.
 */
@Service
public class RemoteRestService {

    private HashMap<String,Float> userHashMap;
    private HashMap<String,ProductInfo> productHashMap;
    private Float totalMoneyAmount;

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String countResult(){
        totalMoneyAmount = new Float(0);
        userHashMap = new HashMap<>();
        productHashMap = new HashMap<>();
        List<OrderEntity> orders = orderService.readAll();
        for(OrderEntity entity : orders){
            addUserElementsToMap(entity);
            addProductElementsToMap(entity);

        }
        //sorting
        Gson gson = new Gson();
        String jsonString;
        List<UserInfo> userInfoList = userInfoMapToList();
        List<ProductInfoWrapper> productInfoWrapperList = productInfoMapToList();

        jsonString ="{ \"userInfoList\" : " + gson.toJson(userInfoList) +
                ", \"productInfoList\" : "+ gson.toJson(productInfoWrapperList)+", \"totalMoneyAmount\" : "+totalMoneyAmount+"}";
        return jsonString;
    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesReverseSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public void addUserElementsToMap(OrderEntity entity){
        Float userMoneyAmount = new Float(0);
        for(ProductEntity productEntity : entity.getProducts()){
            userMoneyAmount +=productEntity.getPrice();
        }
        String username = entity.getUser().getFirstName();
        if(!userHashMap.containsKey(username)) {
            userHashMap.put(username,userMoneyAmount);
        }
        else {
            Float money = userHashMap.get(username);
            money+=userMoneyAmount;
            userHashMap.put(username,money);
        }
        totalMoneyAmount += userMoneyAmount;
    }
    public void addProductElementsToMap(OrderEntity entity){
        for(ProductEntity productEntity : entity.getProducts()){
            String productName = productEntity.getName();
            if(!productHashMap.containsKey(productName)){
                productHashMap.put(productName,new ProductInfo(productEntity.getPrice(),productEntity.getPrice()));
            }
            else {
                ProductInfo tmp = productHashMap.get(productName);
                Float totalPrice = tmp.getMoney();
                totalPrice +=productEntity.getPrice();
                tmp.setMoney(totalPrice);
                productHashMap.put(productName,tmp);
            }
        }
    }


    public List<UserInfo> userInfoMapToList(){
        List<UserInfo> userInfoList = new ArrayList<>();
        for(Map.Entry<String,Float> entry : entriesReverseSortedByValues(userHashMap)){
            userInfoList.add(new UserInfo(entry.getKey(),entry.getValue()));
        }
        return userInfoList;
    }
    public List<ProductInfoWrapper> productInfoMapToList(){
        List<ProductInfoWrapper> list = new ArrayList<>();
        for(Map.Entry<String,ProductInfo> entry : entriesReverseSortedByValues(productHashMap)){
            ProductInfoWrapper wrapper = new ProductInfoWrapper();
            wrapper.setProductName(entry.getKey());
            wrapper.setMoney(entry.getValue().getMoney());
            wrapper.setPrice(entry.getValue().getPrice());
            list.add(wrapper);
        }
        return  list;
    }

}
