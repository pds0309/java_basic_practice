package com.dao;

import org.apache.ibatis.session.SqlSession;

public class DepartmentDAO {

    public int updateAllCapacity(SqlSession session) {
        return session.update("com.config.DepartmentMapper.updateAllCapacity");
    }
}
