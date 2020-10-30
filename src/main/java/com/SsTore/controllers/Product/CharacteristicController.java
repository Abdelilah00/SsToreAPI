package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicCreateDto;
import com.SsTore.Dtos.Product.Characteristics.CharacteristicDto;
import com.SsTore.domains.Product.Characteristic;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/characteristics")
public class CharacteristicController extends BaseCrudController<Characteristic, CharacteristicDto, CharacteristicCreateDto, CharacteristicDto> {

}
