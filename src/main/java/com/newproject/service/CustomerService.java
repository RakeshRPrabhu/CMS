package com.newproject.service;

import com.newproject.model.*;
import com.newproject.dao.*;
import exception.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;

@Component
public class  CustomerService {

    @Autowired
    private CustomerDAO customerDAO;



    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer)
    {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
        return customerDAO.save(customer);
//        return customer;
    }

    public List<Customer> getCustomers()
    {
        return customerDAO.findAll();
//        return customerList;
    }

    public Customer getCustomer(int customerId)
    {
//       return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not Available");
        return customerDAO.findById(customerId).get();
    }

    public Customer updateCustomer(int customerId,Customer customer)
    {
        customer.setCustomerId(customerId);
//        customerList
//                .stream()
//                .forEach(c-> {
//                    if(c.getCustomerId() == customerId) {
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//        return  customerList
//                .stream()
//                .filter(c-> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId)
    {
//        customerList
//                .stream()
//                .forEach(c-> {
//                    if(c.getCustomerId() == customerId)
//                    {
//                        customerList.remove(c);
//                    }
//                });
        customerDAO.deleteById(customerId);
    }
}
