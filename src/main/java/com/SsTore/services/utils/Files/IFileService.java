////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils.Files;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    String saveMultipartFile(MultipartFile file) throws IOException;

    String saveCoverMultipartFile(MultipartFile image) throws IOException;

    String getFilePath(String s) throws IOException;
}
