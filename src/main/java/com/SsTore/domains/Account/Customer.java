package com.SsTore.domains.Account;

import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    private String email;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    public String address;
    private String country;
    private String state;
    private String city;
    private String zip;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Reviews reviews;
}
