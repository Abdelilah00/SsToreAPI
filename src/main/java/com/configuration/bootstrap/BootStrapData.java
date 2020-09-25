////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration.bootstrap;

import com.SsTore.Dtos.Product.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Product.Tags.TagCreateDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseCreateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.SsTore.repositorys.Product.IShppingMethodesRepository;
import com.SsTore.services.Product.ICategoryService;
import com.SsTore.services.Product.ITagService;
import com.SsTore.services.Product.IWareHouseService;
import com.configuration.TenantContext;
import com.configuration.security.repositorys.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());

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
        /*var user1 = new User();
        var admin = new Role();
        admin.setName(RoleName.ROLE_ADMIN);
        user1.setUserName("Abdelilah");
        user1.setPassword("123456");
        user1.setActive(true);
        user1.setEmail("abdelilah@gmail.com");
        user1.setRoles(Collections.singletonList(admin));
        iUserRepository.save(user1);
*/
        //////////////////////////////////////////
        /*var cat1 = new CategoryCreateDto();
        cat1.setName("Category A");
        iCategoryService.create(cat1);

        var cat4 = new CategoryCreateDto();
        cat4.setName("Category B");
        iCategoryService.create(cat4);

        var cat2 = new CategoryCreateDto();
        cat2.setName("Category AA");
        cat2.setParentId(1L);
        iCategoryService.create(cat2);

        var cat3 = new CategoryCreateDto();
        cat3.setName("Category AB");
        cat2.setParentId(1L);
        iCategoryService.create(cat3);


        var cat5 = new CategoryCreateDto();
        cat5.setName("Category BA");
        cat2.setParentId(4L);
        iCategoryService.create(cat5);

        var cat6 = new CategoryCreateDto();
        cat6.setName("Category BB");
        cat2.setParentId(4L);
        iCategoryService.create(cat6);

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
        iShppingMethodesRepository.save(shippingMethod1);*/
    }
}
