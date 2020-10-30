////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration.bootstrap;

import com.SsTore.Dtos.Product.Tags.TagCreateDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseCreateDto;
import com.SsTore.domains.Product.Category;
import com.SsTore.domains.Product.ShippingCountry;
import com.SsTore.domains.Product.ShippingMethod;
import com.SsTore.repositorys.Product.ICategoryRepository;
import com.SsTore.repositorys.Product.IReviewsRepository;
import com.SsTore.repositorys.Product.IShippingCountryRepository;
import com.SsTore.repositorys.Product.IShppingMethodesRepository;
import com.SsTore.services.Product.IReviewService;
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
    @Autowired
    private IShippingCountryRepository iShippingCountryRepository;
    @Autowired
    private IReviewsRepository iReviewsRepository;

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

        boolean start = iCategoryRepository.findAll().size() == 0;

        if (start) {
            var catA = new Category();
            catA.setName("Sacs");
            iCategoryRepository.save(catA);

            var catAA = new Category();
            catAA.setName("Portefeuille");
            catAA.setParent(catA);
            iCategoryRepository.save(catAA);


            var catB = new Category();
            catB.setName("Maison");
            iCategoryRepository.save(catB);

            var catBA = new Category();
            catBA.setName("Cuisine");
            catBA.setParent(catB);
            iCategoryRepository.save(catBA);

            var catBB = new Category();
            catBB.setName("Gadgets");
            catBB.setParent(catB);
            iCategoryRepository.save(catBB);


            var catC = new Category();
            catC.setName("Voitures");
            iCategoryRepository.save(catC);

            var catCA = new Category();
            catCA.setName("Gadgets");
            catCA.setParent(catC);
            iCategoryRepository.save(catCA);

            var catE = new Category();
            catE.setName("Electronique");
            iCategoryRepository.save(catE);

            var catEA = new Category();
            catEA.setName("Camera");
            catEA.setParent(catE);
            iCategoryRepository.save(catEA);

            var catEB = new Category();
            catEB.setName("GPS");
            catEB.setParent(catE);
            iCategoryRepository.save(catEB);

            var catEC = new Category();
            catEC.setName("Autre");
            catEC.setParent(catE);
            iCategoryRepository.save(catEC);


            //////////////////////////////////////////
            var tag1 = new TagCreateDto();
            tag1.setName("portable");
            iTagService.create(tag1);

            var tag2 = new TagCreateDto();
            tag2.setName("security");
            iTagService.create(tag2);

            var tag3 = new TagCreateDto();
            tag3.setName("rechargeable");
            iTagService.create(tag3);

            //////////////////////////////////////////
            var wHouse1 = new WareHouseCreateDto();
            wHouse1.setCountry("Morocco");
            iWareHouseService.create(wHouse1);



            //////////////////////////////////////////
            var shippingMethod1 = new ShippingMethod();
            shippingMethod1.setName("Amana");
            iShppingMethodesRepository.save(shippingMethod1);

            ////////////////////////////////////////
            var country = new ShippingCountry();
            country.setName("Morocco");
            iShippingCountryRepository.save(country);
        }

  /*      if (!first && start) {
            for (int i = 1; i < 9; i++) {
                var tmp = new Reviews();
                tmp.getProduct().setId(1);
                tmp.setComment("good product i recommended");
                tmp.setStars(1.0f + (float) Math.random() * 4.0f);
                iReviewsRepository.save(tmp);

                var tmp2 = new Reviews();
                tmp2.getProduct().setId(i);
                tmp2.setComment("good product i recommended");
                tmp2.setStars(1.0f + (float) Math.random() * 4.0f);
                iReviewsRepository.save(tmp2);
            }
        }*/


    }
}
