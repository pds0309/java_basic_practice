package com.service;

import com.config.SqlConnectionConfig;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.dto.StudentGradeDTO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentDTO> selectAll() {
        SqlSession session = SqlConnectionConfig.getSession();
        List<StudentDTO> studentDtoList = null;
        try {
            studentDtoList = new StudentDAO().findAll(session);
        } finally {
            session.close();
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDTO> selectAll(int recordAmountPerPage, int currentPage) {
        SqlSession session = SqlConnectionConfig.getSession();
        List<StudentDTO> studentDtoList = null;
        try {
            studentDtoList =
                    new StudentDAO().findAllWithPagination(session, new RowBounds(currentPage * recordAmountPerPage, recordAmountPerPage));
        } finally {
            session.close();
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDTO> selectByStudentNameContains(String name) {
        SqlSession session = SqlConnectionConfig.getSession();
        List<StudentDTO> studentDTOList = null;
        try {
            studentDTOList = new StudentDAO().findByStudentNameContains(session, name);
        } finally {
            session.close();
        }
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> selectByEntranceDateBetween(int startDate, int endDate) {
        SqlSession session = SqlConnectionConfig.getSession();
        List<StudentDTO> studentDTOList = null;
        Map<String, Integer> dateMap = new HashMap<>();
        dateMap.put("startDate", startDate);
        dateMap.put("endDate", endDate);
        try {
            studentDTOList = new StudentDAO().findByEntranceDateBetween(session, dateMap);
        } finally {
            session.close();
        }
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> selectByIdIn(List<String> idList) {
        SqlSession session = SqlConnectionConfig.getSession();
        List<StudentDTO> studentDTOList = null;
        try {
            studentDTOList = new StudentDAO().findByIdIn(session, idList);
        } finally {
            session.close();
        }
        return studentDTOList;
    }

    @Override
    public int updateAbsenceYnByIdIn(List<String> idList) {
        SqlSession session = SqlConnectionConfig.getSession();
        int updateSuccessCount = 0;
        try {
            updateSuccessCount = new StudentDAO().updateAbsenceYnByIdIn(session, idList);
        } finally {
            SqlConnectionConfig.sessionCommitForDML(session, updateSuccessCount == idList.size());
            session.close();
        }
        return updateSuccessCount;
    }

    @Override
    public List<StudentGradeDTO> selectGradeById(String id) {
        SqlSession session = SqlConnectionConfig.getSession();
        List<StudentGradeDTO> studentGradeList = null;
        try {
            studentGradeList = new StudentDAO().findGradeByStudentId(session, id);
        } finally {
            session.close();
        }
        return studentGradeList;
    }

}
