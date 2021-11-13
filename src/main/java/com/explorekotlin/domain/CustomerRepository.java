package com.explorekotlin.domain;

import java.util.List;

public interface CustomerRepository {

    CustomerJava findById(Integer id);
    List<CustomerJava> findCustomers();

}
