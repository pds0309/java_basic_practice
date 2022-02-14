package com.dao;

import com.dto.ProductDTO;
import com.dto.ProductQuantityDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductDAO {
    private static final String DIR = "com.config.ProductMapper.";

    public List<ProductDTO> findAllAsc(SqlSession session) {
        return session.selectList(DIR + "selectAllAsc");
    }

    public int deleteOneById(SqlSession session, String productId) {
        return session.delete(DIR + "deleteOneById", productId);
    }

    public int deleteByIdIn(SqlSession session, List<String> idList) {
        return session.delete(DIR + "deleteByIdIn", idList);
    }

    public int updateQuantityById(SqlSession session, ProductQuantityDTO dto) {
        return session.update(DIR + "updateQuantityById", dto);
    }

    public int findQuantityById(SqlSession session, String productId) {
        return session.selectOne(DIR + "selectQuantityById", productId);
    }
}
