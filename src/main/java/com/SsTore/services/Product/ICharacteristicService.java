package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicCreateDto;
import com.SsTore.Dtos.Product.Characteristics.CharacteristicDto;
import com.SsTore.domains.Product.Characteristic;
import com.springBootLibrary.services.IBaseCrudService;

public interface ICharacteristicService extends IBaseCrudService<Characteristic, CharacteristicDto, CharacteristicCreateDto, CharacteristicDto> {
}
