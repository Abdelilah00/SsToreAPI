////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers;

import com.SsTore.services.IFileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/tests")
public class TestsController {
    private static final Logger logger = LoggerFactory.getLogger(TestsController.class.getName());
    @Autowired
    private IFileService iFileService;

    @PostMapping(path = "/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("model") String testModel) throws JsonProcessingException {

        var objectMapper = new ObjectMapper();
        TestModel object = objectMapper.readValue(testModel, TestModel.class);

        logger.info("Upload File => " + object.toString());
        iFileService.uploadFile(file);

        return "You successfully uploaded";
    }
}

@Getter
@Setter
@ToString
class TestModel {
    private String attrA;
}
