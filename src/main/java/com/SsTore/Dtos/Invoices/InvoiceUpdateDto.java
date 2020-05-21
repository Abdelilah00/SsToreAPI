package com.SsTore.Dtos.Invoices;

import com.springBootLibrary.models.BaseDto;
import lombok.Data;

@Data
public class InvoiceUpdateDto extends BaseDto {
    private String firstName;
    private String lastName;
}
