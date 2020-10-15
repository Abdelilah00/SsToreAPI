////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils.Files;

import com.SsTore.controllers.TestsController;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class FileService implements IFileService {
    @Value("${src.uploads.imagesDir}")
    private String uploadDir;

    private static final Logger logger = LoggerFactory.getLogger(FileService.class.getName());


    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int hieght) {
        return Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, width, hieght);
    }

    public String saveMultipartFile(MultipartFile file) throws IOException {
        File directory = new File(uploadDir);
        if (!directory.exists())
            directory.mkdirs();


        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        BufferedImage resizeImageJpg = resizeImage(originalImage, 550, 750);
        Date date = new Date();
        var name = date.getTime() + "_" + file.getOriginalFilename();
        var tmp = uploadDir + name;
        ImageIO.write(resizeImageJpg, "png", new File(tmp));

        return name;
    }


    public byte[] getMultipartFile(String fileName) throws IOException {
        File file = new File(uploadDir + fileName);
        var fileInputStream = new FileInputStream(file);
        return IOUtils.toByteArray(fileInputStream);
    }


}
