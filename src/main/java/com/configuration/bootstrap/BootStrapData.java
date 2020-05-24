////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration.bootstrap;

import com.SsTore.Dtos.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Tags.TagCreateDto;
import com.SsTore.services.ICategoryService;
import com.SsTore.services.ITagService;
import com.configuration.TenantContext;
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

    @Override
    public void run(String... args) throws Exception {
        var cat1 = new CategoryCreateDto();
        cat1.setName("Category A");
        iCategoryService.create(cat1);

        var cat2 = new CategoryCreateDto();
        cat2.setName("Category B");
        iCategoryService.create(cat2);

        var cat3 = new CategoryCreateDto();
        cat3.setName("Category C");
        iCategoryService.create(cat3);

        var tag1 = new TagCreateDto();
        tag1.setName("Tag A");
        iTagService.create(tag1);

        var tag2 = new TagCreateDto();
        tag2.setName("Tag B");
        iTagService.create(tag2);

        var tag3 = new TagCreateDto();
        tag3.setName("Tag C");
        iTagService.create(tag3);

    }
}
