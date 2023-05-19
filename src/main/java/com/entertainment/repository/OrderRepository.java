package com.entertainment.repository;

import com.entertainment.entity.Customer;
import com.entertainment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByCustomerIn(List<Customer> customers);

    List<Order> findByProductName(String productName);
}
