package com.SsTore.Dtos.Product.Solde;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SoldeDto extends BaseDto {
    private Float percent;
    private long ProductId;
}

