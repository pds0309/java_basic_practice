package com.dao;

import com.dto.PageDTO;
import com.dto.StudentDTO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDAO {

    private static final String DIR = "com.config.StudentMapper.";

    private int totalCountForPageable(SqlSession session) {
        return session.selectOne(DIR + "pageable");
    }

    public List<StudentDTO> findAll(SqlSession session) {
        return session.selectList(DIR + "selectAllAsc");
    }

    // 실제 데이터베이스에서 어떻게 쿼리가 실행되는지 확인하자
    // currentPage 를 클라이언트 쿼리스트링에서 지정 범위 초과로 설정 후 요청하면 결과가 그대로 나오는데..
    public PageDTO findAllWithPagination(SqlSession session, int currentPage, int perPage) {
        int totalCount = totalCountForPageable(session);
        return new PageDTO(currentPage, perPage, totalCount, session.selectList(DIR + "selectAllAsc", null, new RowBounds((currentPage - 1) * perPage, perPage)));
    }
    // rownum 을 입력받았다고 치고 설정하기?
    // 위랑 똑같다..
    public PageDTO findAllWithPagination2(SqlSession session, int currentPage, int perPage) {
        int totalCount = 20;
        return new PageDTO(currentPage, perPage, totalCount, session.selectList(DIR + "selectAllAsc", totalCount, new RowBounds((currentPage - 1) * perPage, perPage)));
    }
}