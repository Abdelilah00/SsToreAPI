////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Objects;

@Service
public class FileService implements IFileService {
    @Value("${src.uploads.images}")
    private String uploadDir;
    @Autowired
    private ServletContext context;

    public void uploadFile(MultipartFile file) {
        try {
            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
/*
            throw new UserFriendlyException("Could not store file " + file.getOriginalFilename()+ ". Please try again!");
*/
        }
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
}
