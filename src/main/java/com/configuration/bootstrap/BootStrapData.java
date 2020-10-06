////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration.bootstrap;

import com.SsTore.Dtos.Product.Reviews.ReviewsCreateDto;
import com.SsTore.Dtos.Product.Tags.TagCreateDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseCreateDto;
import com.SsTore.domains.Product.Category;
import com.SsTore.domains.Product.ShippingMethod;
import com.SsTore.repositorys.Product.ICategoryRepository;
import com.SsTore.repositorys.Product.IShppingMethodesRepository;
import com.SsTore.services.Product.IReviewService;
import com.SsTore.services.Product.ITagService;
import com.SsTore.services.Product.IWareHouseService;
import com.SsTore.services.utils.Emails.Emails;
import com.configuration.TenantContext;
import com.configuration.security.repositorys.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;

@Component
public class BootStrapData implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private IWareHouseService iWareHouseService;
    @Autowired
    private IReviewService iReviewService;

    @Autowired
    private IShppingMethodesRepository iShppingMethodesRepository;
    @Autowired
    private IUserRepository iUserRepository;

    private final boolean first = true;
    private final boolean start = false;

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

        var email = new Emails();
        email.sendEmail("abdelilah0dehaoui@outlook.fr");

        if (first && start) {
            var catA = new Category();
            catA.setName("Category A");
            iCategoryRepository.save(catA);

            var catAA = new Category();
            catAA.setName("Category AA");
            catAA.setParent(catA);
            iCategoryRepository.save(catAA);

            var catAB = new Category();
            catAB.setName("Category AB");
            catAB.setParent(catA);
            iCategoryRepository.save(catAB);

            var catB = new Category();
            catB.setName("Category B");
            iCategoryRepository.save(catB);

            var catBA = new Category();
            catBA.setName("Category BA");
            catBA.setParent(catB);
            iCategoryRepository.save(catBA);

            var catBB = new Category();
            catBB.setName("Category BB");
            catBB.setParent(catB);
            iCategoryRepository.save(catBB);


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
        if (!first && start) {
            for (int i = 1; i < 9; i++) {
                var tmp = new ReviewsCreateDto();
                tmp.setProductId(1);
                tmp.setComment("good product i recommended");
                tmp.setStars(1.0f + (float) Math.random() * 4.0f);
                iReviewService.create(tmp);

                var tmp2 = new ReviewsCreateDto();
                tmp2.setProductId(i);
                tmp2.setComment("good product i recommended");
                tmp2.setStars(1.0f + (float) Math.random() * 4.0f);
                iReviewService.create(tmp2);
            }
        }


    }
}
