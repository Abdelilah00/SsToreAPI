package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Solde.SoldeCreateDto;
import com.SsTore.Dtos.Product.Solde.SoldeDto;
import com.SsTore.Dtos.Product.Solde.SoldeUpdateDto;
import com.SsTore.domains.Product.Solde;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SoldeService extends BaseCrudServiceImpl<Solde, SoldeDto, SoldeCreateDto, SoldeUpdateDto> implements ISoldeService {
    public SoldeService() {
        super(Solde.class, SoldeDto.class, SoldeCreateDto.class, SoldeUpdateDto.class);
    }
}
