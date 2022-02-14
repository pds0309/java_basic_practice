package com.service;

import com.config.SqlConnectionConfig;
import com.dao.ProductDAO;
import com.dto.ProductDTO;
import com.dto.ProductQuantityDTO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductDTO> selectAllAsc() {
        SqlSession session = SqlConnectionConfig.getSession();
        List<ProductDTO> productDTOList = null;
        try {
            productDTOList = new ProductDAO().findAllAsc(session);
        } finally {
            session.close();
        }
        return productDTOList;
    }

    @Override
    public int selectQuantityById(String id) {
        SqlSession session = SqlConnectionConfig.getSession();
        int quantity = -1;
        try {
            quantity = new ProductDAO().findQuantityById(session, id);
        } finally {
            session.close();
        }
        return quantity;
    }

    @Override
    public int deleteOneById(String id) {
        SqlSession session = SqlConnectionConfig.getSession();
        int status = 0;
        try {
            status = new ProductDAO().deleteOneById(session, id);
        } finally {
            if (status == 1) {
                session.commit();
            }
            session.close();
        }
        return status;
    }

    @Override
    public int deleteByIdIn(List<String> idList) {
        SqlSession session = SqlConnectionConfig.getSession();
        int status = 0;
        try {
            status = new ProductDAO().deleteByIdIn(session, idList);
        } finally {
            if (status == idList.size()) {
                session.commit();
            }
            session.close();
        }
        return status;
    }

    @Override
    public int updateQuantityById(String id, int quantity) {
        SqlSession session = SqlConnectionConfig.getSession();

        int status = 0;
        try {
            status = new ProductDAO().updateQuantityById(session, new ProductQuantityDTO(id, quantity));
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (status == 1) {
                session.commit();
            }
            session.close();
        }
        return status;
    }

}
