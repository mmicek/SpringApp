package main.server.database.dto;

import main.server.database.AbstractData;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class ProductData extends AbstractData {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCTS_USER_ID")
    @JoinColumn(name = "USER_ID")
    private Long userId;

    @Column(name = "PRODUCT_LINK")
    private String productLink;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_QUANTITY")
    private int quantity;

    public ProductData(String name,String productLink){
        this.name = name;
        this.productLink = productLink;
        this.quantity = 1;
    }

    public ProductData(){
        this.quantity = 1;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return (int) (this.name.length() + this.userId +
                this.productLink.length()%this.name.length());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ProductData){
            ProductData that = (ProductData) obj;
            return that.userId.equals(this.userId)
                    && that.productLink.equals(this.productLink)
                    && that.name.equals(this.name);
        }
        return false;
    }
}
