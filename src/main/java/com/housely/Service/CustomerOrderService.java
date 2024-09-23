package com.housely.Service;

import com.housely.Model.Order.CustomerOrder;
import com.housely.Model.Order.OrderItem;
import com.housely.Repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    // inject CustomerOrderRepository
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> findAll() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder save(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrder findById(Long id) {
        return customerOrderRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("customer order id:"+id+" not found"));
    }

    public CustomerOrder findCustomerOrderByCustomerAndOrderId(Long cusId, Long orderId) {
        return customerOrderRepository.findCustomerOrderByCustomerAndOrderId(cusId, orderId)
                .orElseThrow(
                        () -> new RuntimeException("customer order id:"+orderId+" not found"));
    }

    public List<CustomerOrder> findCustomerOrdersByCustomerId(Long cusId) {
        return customerOrderRepository.findCustomerOrdersByCustomerId(cusId);
    }


    public void deleteById(Long id) {
        customerOrderRepository.deleteById(id);
    }
}
