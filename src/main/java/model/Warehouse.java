package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 26.04.2017.
 */
@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String city;
    private String address;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "warehouseId")
    private Set<ProductsOnWarehouses> productsOnWarehouses = new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "warehouseId")
    public Set<ProductsOnWarehouses> getProductsOnWarehouses() {
        return productsOnWarehouses;
    }

    public void setProductsOnWarehouses(Set<ProductsOnWarehouses> productsOnWarehouses) {
        this.productsOnWarehouses = productsOnWarehouses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
