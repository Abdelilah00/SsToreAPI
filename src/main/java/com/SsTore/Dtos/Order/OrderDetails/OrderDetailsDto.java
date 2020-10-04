package com.SsTore.Dtos.Order.OrderDetails;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDto {
    private Long productId;
    private Long qte;
    //private CharacteristicDto productCharacteristic;
}
