////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration.bootstrap;

import com.configuration.TenantContext;
import com.configuration.security.domains.Role;
import com.configuration.security.domains.RoleName;
import com.configuration.security.domains.User;
import com.configuration.security.repositorys.IUserRepository;
import com.SsTore.Dtos.Owners.OwnerCreateDto;
import com.SsTore.repositorys.ICustomerRepository;
import com.SsTore.repositorys.Product.IProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BootStrapData implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IOwnerService ownerService;


    @Override
    public void run(String... args) throws Exception {

        Role userRole = new Role();
        userRole.setName(RoleName.ROLE_USER);
        User userUser = new User("user", passwordEncoder.encode("user"), "user@x.com", true, Collections.singletonList(userRole));
        userRepository.save(userUser);
        Role adminRole = new Role();
        adminRole.setName(RoleName.ROLE_ADMIN);
        User userAdmin = new User("admin", passwordEncoder.encode("admin"), "admin@x.com", true, Collections.singletonList(adminRole));
        userRepository.save(userAdmin);

        Customer customer = new Customer("Abdelilah 1", "Dehaoui", "abdelilah@gelail.cop");
        customer.setTenantId(2L);
        customerRepository.save(customer);
        Customer customer1 = new Customer("Jamal 2", "Elghafouli", "abdelilah@gelail.cop");
        customer1.setTenantId(2L);
        customerRepository.save(customer1);

        var store = ownerService.withStore(new OwnerCreateDto("Abdelilah", "Dehaoui", "Alexa"));
       /* ownerService.withStore(new OwnerDto("Amine", "bachan", "test"));
        ownerService.withStore(new OwnerDto("zaki", "bali", "pprn"));
        ownerService.withStore(new OwnerDto("oussama", "Dehaoui", "xxxx"));*/

        var storeEntity = new Store();
        storeEntity.setId(store.getId());
        var prod1 = new Product("Bimoo from tenant 1", 10L, storeEntity);
        prod1.setTenantId(2L);
        productRepository.save(prod1);
        var prod2 = new Product("Picala from tenant 2", 10L, storeEntity);
        prod2.setTenantId(2L);
        productRepository.save(prod2);
    }
}
