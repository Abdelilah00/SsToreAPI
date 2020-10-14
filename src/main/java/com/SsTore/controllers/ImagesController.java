package com.SsTore.controllers;

import com.SsTore.services.utils.Files.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    IFileService iFileService;

    @RequestMapping(value = "{fileName}", method = RequestMethod.GET)
    protected byte[] getMultipartFile(@PathVariable(value = "fileName") String fileName) throws IOException {
        return iFileService.getMultipartFile(fileName);
    }

}
