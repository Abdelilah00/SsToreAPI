////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springBootLibrary.models.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Owner extends BaseEntity {
    private static final long serialVersionUID = -19385454577507296L;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Transient
    private String storeName;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    /*@JoinTable(
            name = "store_owners",
            joinColumns = {@JoinColumn(name = "store_id")},
            inverseJoinColumns = {@JoinColumn(name = "owner_id")})*/
    private List<Store> stores = new ArrayList<>();

    @PostLoad
    private void init() {
        storeName = stores.get(0).getName();
    }
}
