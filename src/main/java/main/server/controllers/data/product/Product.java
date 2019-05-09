package main.server.controllers.data.product;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Product {

    private String name;
    private int price;
    private int quantity;
    private boolean used;
    private int contactNumber;
    //Czy jest produkt na sprzedaż
    private boolean active;

    private static HashMap<Class<? extends Product>,List<String>> additionalFieldsMap = new HashMap<>();
    private List<String> additionalFields;

    Product(String name,int price,int contactNumber){
        this.name = name;
        this.price = price;
        this.contactNumber = contactNumber;
        intiAdditionalFields();
    }

    Product(){
        intiAdditionalFields();
    }

    private void intiAdditionalFields() {
        if(!additionalFieldsMap.containsKey(this.getClass())) {
            Field[] fields = getClass().getDeclaredFields();
            List<String> fieldNames = new LinkedList<>();
            for(Field field : fields){
                if(field.isAnnotationPresent(Additional.class)){
                    fieldNames.add(field.getName());
                }
            }
            additionalFieldsMap.put(this.getClass(),fieldNames);
        }
        this.additionalFields = additionalFieldsMap.get(this.getClass());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<String> getAdditionalFields() {
        return additionalFields;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
