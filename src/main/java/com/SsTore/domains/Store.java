////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store extends BaseEntity {
    private static final long serialVersionUID = -1938567852507296L;
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "store")
    @JsonBackReference
    //@Fetch(FetchMode.JOIN)
    private List<Product> products = new ArrayList<>();

    @ManyToOne()
    @JsonManagedReference
    private Owner owner;
}
