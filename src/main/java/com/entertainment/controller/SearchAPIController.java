package com.entertainment.controller;

import com.entertainment.entity.Address;
import com.entertainment.entity.Customer;
import com.entertainment.entity.Order;
import com.entertainment.repository.AddressRepository;
import com.entertainment.repository.CustomerRepository;
import com.entertainment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/search")
public class SearchAPIController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value="/orders")
    public ResponseEntity<?> searchDataBasedOnParams(
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String cityName,
            @RequestParam(required = false) String productName
    ){
        if(customerName!=null){
            List<Customer> customers = customerRepository.findByCustomerName(customerName);
            List<Order> orders = orderRepository.findByCustomerIn(customers);
            return ResponseEntity.ok(orders);
        }else if(cityName!=null){
            List<Address> addresses = addressRepository.findByCity(cityName);
            List<Customer> customers = customerRepository.findByAddressListIn(addresses);
            List<Order> orders = orderRepository.findByCustomerIn(customers);
            return ResponseEntity.ok(orders);
        }else if(productName!=null){
            List<Order> orders = orderRepository.findByProductName(productName);
            return ResponseEntity.ok(orders);
        }else{
            List<Order> orders = orderRepository.findAll();
            return ResponseEntity.ok(orders);
        }
    }

    @PostMapping(value = "/saveOrder")
    public List<Order> saveAllOrder(@RequestBody List<Order> orderList){
        return orderRepository.saveAll(orderList);
    }

    @PostMapping(value = "/saveCustomer")
    public List<Customer> saveAllCustomer(@RequestBody List<Customer> customerList){
        return customerRepository.saveAll(customerList);
    }

    @PostMapping(value = "/saveAddress")
    public List<Address> saveAllAddress(@RequestBody List<Address> addressList){
        return addressRepository.saveAll(addressList);
    }

    @GetMapping(value="/getData")
    public ResponseEntity<?> findAllData( @RequestParam(required = false) String customerName,
                                       @RequestParam(required = false) String cityName,
                                       @RequestParam(required = false) String productName){
        if(customerName!=null){
            return new ResponseEntity<>(customerRepository.findByCustomerName(customerName),HttpStatus.OK);
        }else if(cityName!=null){
            List<Address> addresses = addressRepository.findByCity(cityName);
            List<Customer> customers = customerRepository.findByAddressListIn(addresses);
            return new ResponseEntity<>(customers,HttpStatus.OK);
        }else if(productName!=null){
            List<Order> orders = orderRepository.findByProductName(productName);
            List<Customer> customers = customerRepository.findByOrderListIn(orders);
            return new ResponseEntity<>(customers,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(customerRepository.findAll(),HttpStatus.OK);
        }
    }

}
