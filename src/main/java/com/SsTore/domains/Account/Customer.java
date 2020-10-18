package com.SsTore.domains.Account;

import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer extends BaseEntity {

    @NotBlank
    @NotNull
    @NotEmpty
    public String address;
    @NotBlank
    @NotNull
    @NotEmpty
    private String email;
    @NotBlank
    @NotNull
    @NotEmpty
    private String phoneNumber;
    @NotBlank
    @NotNull
    @NotEmpty
    private String firstName;
    @NotBlank
    @NotNull
    @NotEmpty
    private String lastName;
    @NotBlank
    @NotNull
    @NotEmpty
    private String city;
    @NotBlank
    @NotNull
    @NotEmpty
    private String zip;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Reviews reviews;
}
