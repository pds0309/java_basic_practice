package com.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public final class SqlConnectionConfig {

    private static final SqlSessionFactory sqlSessionFactory;

    private SqlConnectionConfig() {
    }

    static {
        String resource = "com/config/Configuration.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }


    public static void sessionCommitForDML(SqlSession session, boolean matchNumOfRequestResponse) {
        if (session != null && matchNumOfRequestResponse) {
            session.commit();
        }
    }

    public static void sessionCommitForDML(SqlSession session) {
        if (session != null) {
            session.commit();
        }
    }
}
