package com.service;

import com.config.SqlConnectionConfig;
import com.dao.StudentDAO;
import com.dto.PageDTO;
import com.dto.StudentDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
    public PageDTO<StudentDTO> selectAllPageable(int recordAmountPerPage, int currentPage) {
        SqlSession session = SqlConnectionConfig.getSession();
        PageDTO pageDTO = null;
        try {
            pageDTO = new StudentDAO().findAllWithPagination(session, currentPage, recordAmountPerPage);
        } finally {
            session.close();
        }
        return pageDTO;
    }
    @Override
    public PageDTO<StudentDTO> selectAllPageable2(int recordAmountPerPage, int currentPage) {
        SqlSession session = SqlConnectionConfig.getSession();
        PageDTO pageDTO = null;
        try {
            pageDTO = new StudentDAO().findAllWithPagination2(session, currentPage, recordAmountPerPage);
            System.out.println(pageDTO.gettList().size());
        } finally {
            session.close();
        }
        return pageDTO;
    }
}