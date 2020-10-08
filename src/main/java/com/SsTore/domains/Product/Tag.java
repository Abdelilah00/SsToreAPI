////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {
    @NotBlank
    @NotNull
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<ProductTags> productTags = new ArrayList<>();
}
