package service.impl;

import model.ProductInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductInOrderRepository;
import service.ProductInOrderService;

/**
 * Created by Andrey on 14.05.2017.
 */

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public void saveNewProductInOrder(ProductInOrder productInOrder) {
        productInOrderRepository.save(productInOrder);
    }
}
