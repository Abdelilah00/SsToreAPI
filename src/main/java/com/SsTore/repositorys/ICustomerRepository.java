package com.SsTore.repositorys;

import com.SsTore.domains.Customer;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends IBaseJpaRepository<Customer> {
}
