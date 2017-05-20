package model;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by Andrey on 26.04.2017.
 */

@Entity
@Table(name = "products_on_warehouse")
@Proxy(lazy = false)
public class ProductsOnWarehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Check(constraints = "amount>=0")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "productId", insertable=true, updatable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouseId" , insertable=true, updatable=false)
    private Warehouse warehouse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "productId", insertable=true, updatable=false)
    public /*Product*/ long getProduct() {
        return product.getId();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "warehouseId", insertable=true, updatable=false)
    public Warehouse getWarehouse() {

        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
