package com.SsTore.repositorys.Product;

import com.SsTore.domains.Account.Customer;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends IBaseJpaRepository<Customer> {
    Customer findByEmail(String email);
}
