////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils.Files;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class FileService implements IFileService {
    @Value("${src.uploads.imagesDir}")
    private String uploadDir;

    private static final Logger logger = LoggerFactory.getLogger(FileService.class.getName());


    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage bufferedImage;

        //resize
        if (originalImage.getWidth() > originalImage.getHeight())
            bufferedImage = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, width, height);
        else
            bufferedImage = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, width, height);

        return bufferedImage;

    }

    public String saveMultipartFile(MultipartFile file) throws IOException {

        File directory = new File(uploadDir);
        if (!directory.exists())
            directory.mkdirs();

        //resize
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        BufferedImage resizeImage = resizeImage(originalImage, 550, 750);

        //generate new name
        Date date = new Date();
        var name = date.getTime() + "_" + file.getOriginalFilename() + ".webp";
        var tmp = uploadDir + name;

        ImageIO.write(resizeImage, "webp", new File(tmp));
        return name;
    }


    public byte[] getMultipartFile(String fileName) throws IOException {
        File file = new File(uploadDir + fileName);
        var fileInputStream = new FileInputStream(file);
        return IOUtils.toByteArray(fileInputStream);
    }


}
