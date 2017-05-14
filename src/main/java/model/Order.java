package model;

import model.enums.OrderStatus;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrey on 26.04.2017.
 */

@Entity
@Table(name = "orders")
@Proxy(lazy = false)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public OrderStatus getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany
    @JoinColumn(name = "orderId")
    public Set<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(Set<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    @OneToMany
    @JoinColumn(name = "orderId")
    private Set<ProductInOrder> productInOrders;

    @ManyToOne
    @JoinColumn(name = "userId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)

    private OrderStatus status;
}
