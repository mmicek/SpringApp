package main.server.database.dto;

import main.server.database.AbstractData;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserData extends AbstractData {

    @Id
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_NAME"/*,unique = true*/)
    private String username;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_ROLE")
    private int userRole;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "userId")
    private Set<ProductData> products;

    public UserData() {}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return id + " : " + username;
    }

    public Set<ProductData> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductData> products) {
        this.products = products;
    }
}