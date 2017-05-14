package repository;

import model.ProductsOnWarehouses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrey on 28.04.2017.
 */
public interface ProductOnWarehousesRepository extends JpaRepository<ProductsOnWarehouses, Long> {
    ProductsOnWarehouses findOneByProductId(long id);
}
