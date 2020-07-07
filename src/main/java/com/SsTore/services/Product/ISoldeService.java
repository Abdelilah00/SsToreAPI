package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Solde.SoldeCreateDto;
import com.SsTore.Dtos.Product.Solde.SoldeDto;
import com.SsTore.Dtos.Product.Solde.SoldeUpdateDto;
import com.SsTore.domains.Product.Solde;
import com.springBootLibrary.services.IBaseCrudService;

public interface ISoldeService extends IBaseCrudService<Solde, SoldeDto, SoldeCreateDto, SoldeUpdateDto> {

}
