////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class FileService implements IFileService {
    @Value("${src.uploads.images}")
    private String uploadDir;

    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int width, int hieght) {
        BufferedImage resizedImage = new BufferedImage(width, hieght, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 512, 512, null);
        g.dispose();
        return resizedImage;
    }

    public void saveMultipartFile(MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        BufferedImage resizeImageJpg = resizeImage(originalImage, type, 550, 750);
        ImageIO.write(resizeImageJpg, "png", new File(uploadDir + file.getOriginalFilename()));
    }

    public String getFile(String fileName) throws IOException {

        String image = null;
        var filePath = uploadDir + '/' + fileName;
        File file = new File(filePath);

        if (!file.isDirectory()) {
            String extension = FilenameUtils.getExtension(file.getName());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);

            String endcodeBase64 = Base64.getEncoder().encodeToString(bytes);
            image = "data:image/" + extension + ";base64," + endcodeBase64;
            fileInputStream.close();
        }
        return image;
    }

    public void saveCoverMultipartFile(MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        BufferedImage resizeImageJpg = resizeImage(originalImage, type, 315, 420);
        ImageIO.write(resizeImageJpg, "png", new File(uploadDir + "Cover/" + file.getOriginalFilename()));

    }
}
