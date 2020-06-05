////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.repositorys.Product;

import com.SsTore.domains.Product.Image;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagesRepository extends IBaseJpaRepository<Image> {

}
