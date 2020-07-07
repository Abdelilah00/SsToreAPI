package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Solde.SoldeCreateDto;
import com.SsTore.Dtos.Product.Solde.SoldeDto;
import com.SsTore.Dtos.Product.Solde.SoldeUpdateDto;
import com.SsTore.domains.Product.Solde;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/solde")
public class SoldeController extends BaseCrudController<Solde, SoldeDto, SoldeCreateDto, SoldeUpdateDto> {

}
