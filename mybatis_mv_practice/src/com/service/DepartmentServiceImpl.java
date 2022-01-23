package com.service;

import com.config.SqlConnectionConfig;
import com.dao.DepartmentDAO;
import org.apache.ibatis.session.SqlSession;

public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public int updateAllCapacity() {
        SqlSession session = SqlConnectionConfig.getSession();
        int updateSuccessCount = 0;
        try {
            updateSuccessCount = new DepartmentDAO().updateAllCapacity(session);
        } finally {
            SqlConnectionConfig.sessionCommitForDML(session);
            session.close();
        }
        return updateSuccessCount;
    }
}
