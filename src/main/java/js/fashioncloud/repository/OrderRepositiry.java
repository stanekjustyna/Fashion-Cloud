package js.fashioncloud.repository;

import js.fashioncloud.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositiry extends JpaRepository<Order, Long> {
}
