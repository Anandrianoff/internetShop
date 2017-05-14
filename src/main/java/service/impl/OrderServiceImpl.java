package service.impl;

import model.Order;
import model.ProductInOrder;
import model.ProductsOnWarehouses;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import repository.ProductInOrderRepository;
import repository.ProductOnWarehousesRepository;
import service.OrderService;

import java.util.List;

/**
 * Created by Andrey on 13.05.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductOnWarehousesRepository productOnWarehousesRepository;

    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveNewOrder(Order order) {
        order = orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getAllOrdersByUser(long userId) {
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return orders;
    }
}
