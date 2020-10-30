package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicCreateDto;
import com.SsTore.Dtos.Product.Characteristics.CharacteristicDto;
import com.SsTore.domains.Product.Characteristic;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CharacteristicService extends BaseCrudServiceImpl<Characteristic, CharacteristicDto, CharacteristicCreateDto, CharacteristicDto> implements ICharacteristicService {

    public CharacteristicService() {
        super(Characteristic.class, CharacteristicDto.class, CharacteristicCreateDto.class, CharacteristicDto.class);
    }

}
