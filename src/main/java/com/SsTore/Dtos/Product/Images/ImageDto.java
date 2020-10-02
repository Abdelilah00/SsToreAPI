package com.SsTore.Dtos.Product.Images;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {
    private String url = "";
    private String name = "";
    private Boolean cover = false;
}
