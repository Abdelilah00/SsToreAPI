////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration.bootstrap;

import com.SsTore.Dtos.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Tags.TagCreateDto;
import com.SsTore.Dtos.WareHouses.WareHouseCreateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.SsTore.repositorys.Product.IShppingMethodesRepository;
import com.SsTore.services.ICategoryService;
import com.SsTore.services.ITagService;
import com.SsTore.services.IWareHouseService;
import com.configuration.TenantContext;
import com.configuration.security.repositorys.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private IWareHouseService iWareHouseService;
    @Autowired
    private IShppingMethodesRepository iShppingMethodesRepository;
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void run(String... args) throws Exception {
    /*    var user1 = new User();
        var admin = new Role();
        admin.setName(RoleName.ROLE_ADMIN);
        user1.setUserName("Abdelilah");
        user1.setPassword("123456");
        user1.setActive(true);
        user1.setEmail("abdelilah@gmail.com");
        user1.setRoles(Collections.singletonList(admin));
        iUserRepository.save(user1);*/

        //////////////////////////////////////////
        var cat1 = new CategoryCreateDto();
        cat1.setName("Category A");
        iCategoryService.create(cat1);

        var cat2 = new CategoryCreateDto();
        cat2.setName("Category B");
        iCategoryService.create(cat2);

        var cat3 = new CategoryCreateDto();
        cat3.setName("Category C");
        iCategoryService.create(cat3);

        //////////////////////////////////////////
        var tag1 = new TagCreateDto();
        tag1.setName("Tag A");
        iTagService.create(tag1);

        var tag2 = new TagCreateDto();
        tag2.setName("Tag B");
        iTagService.create(tag2);

        var tag3 = new TagCreateDto();
        tag3.setName("Tag C");
        iTagService.create(tag3);

        //////////////////////////////////////////
        var wHouse1 = new WareHouseCreateDto();
        wHouse1.setCountry("wHouse 1");
        iWareHouseService.create(wHouse1);

        var wHouse2 = new WareHouseCreateDto();
        wHouse2.setCountry("wHouse 2");
        iWareHouseService.create(wHouse2);

        var wHouse3 = new WareHouseCreateDto();
        wHouse3.setCountry("wHouse 3");
        iWareHouseService.create(wHouse3);

        //////////////////////////////////////////
        var shippingMethod1 = new ShippingMethod();
        shippingMethod1.setName("DHL");
        iShppingMethodesRepository.save(shippingMethod1);
    }
}
