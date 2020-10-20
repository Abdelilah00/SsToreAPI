package com.SsTore.Dtos.Order.OrderDetails;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrderDetailsDto {
    private Long productId;
    private Long qte;
    private List<SelectedCharacteristicsDto> selectedCharacteristics;

    private List<GetSelectedCharacteristicsDto> orderDetailsProductCharacteristics;
}

