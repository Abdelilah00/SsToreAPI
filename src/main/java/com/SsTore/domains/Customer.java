////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    private static final long serialVersionUID = -193856758757507296L;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
}
