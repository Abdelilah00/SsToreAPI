////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.utils;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    void uploadFile(MultipartFile file);
}
