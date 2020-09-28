////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils.Files;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileService implements IFileService {
    @Value("${src.uploads.imagesIn}")
    private String uploadDirIn;
    @Value("${src.uploads.imagesOut}")
    private String uploadDirOut;

    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int hieght) {
        return Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, width, hieght);
    }

    public String saveMultipartFile(MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        BufferedImage resizeImageJpg = resizeImage(originalImage, 550, 750);
        Date date = new Date();
        var name = date.getTime() + file.getOriginalFilename();
        var tmp = uploadDirIn + name;
        ImageIO.write(resizeImageJpg, "png", new File(tmp));
        return name;
    }

    public String saveCoverMultipartFile(MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        BufferedImage resizeImageJpg = resizeImage(originalImage, 315, 420);
        Date date = new Date();
        var name = date.getTime() + file.getOriginalFilename();
        var tmp = uploadDirIn + "Cover/" + name;
        ImageIO.write(resizeImageJpg, "png", new File(tmp));
        return name;
    }

    public String getFilePath(String fileName) {
        return uploadDirOut + fileName;
    }

}
