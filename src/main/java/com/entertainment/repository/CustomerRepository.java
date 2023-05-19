package com.entertainment.repository;

import com.entertainment.entity.Address;
import com.entertainment.entity.Customer;
import com.entertainment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCustomerName(String customerName);

//    List<Customer> findByAddressIn(List<Address> addresses);

    List<Customer> findByAddressListIn(List<Address> addresses);

    List<Customer> findByOrderListIn(List<Order> orders);
}
