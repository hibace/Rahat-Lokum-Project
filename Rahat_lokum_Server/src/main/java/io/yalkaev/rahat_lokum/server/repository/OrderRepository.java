package io.yalkaev.rahat_lokum.server.repository;

import io.yalkaev.rahat_lokum.server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
