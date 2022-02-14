package com.service;

import com.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> selectAllAsc();

    int deleteOneById(String id);

    int deleteByIdIn(List<String> idList);

    int updateQuantityById(String id, int quantity);

    int selectQuantityById(String id);

}
