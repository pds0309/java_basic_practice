package com.dao;

import com.dto.StudentDTO;
import com.dto.StudentGradeDTO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StudentDAO {

    private static final String DIR = "com.config.StudentMapper.";

    public List<StudentDTO> findAll(SqlSession session) {
        return session.selectList(DIR + "selectAllAsc");
    }

    public List<StudentDTO> findByStudentNameContains(SqlSession session, String name) {
        return session.selectList(DIR + "selectByStudentNameContains", name);
    }

    public List<StudentDTO> findByEntranceDateBetween(SqlSession session, Map<String, Integer> dateMap) {
        return session.selectList(DIR + "selectByEntranceDateBetween", dateMap);
    }

    public List<StudentDTO> findByIdIn(SqlSession session, List<String> idList) {
        return session.selectList(DIR + "selectByIdIn", idList);
    }

    public int updateAbsenceYnByIdIn(SqlSession session, List<String> idList) {
        return session.update(DIR + "updateAbsenceYnByIdIn", idList);
    }

    public List<StudentGradeDTO> findGradeByStudentId(SqlSession session, String id) {
        return session.selectList(DIR + "selectGradeByStudentId", id);
    }

    public List<StudentDTO> findAllWithPagination(SqlSession session, RowBounds rowBounds) {
        return session.selectList(DIR + "selectAllAsc", null, rowBounds);
    }
}
