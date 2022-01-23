package com.service;

import com.dto.StudentDTO;
import com.dto.StudentGradeDTO;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StudentService {
    List<StudentDTO> selectAll();

    List<StudentDTO> selectAll(int recordAmountPerPage, int currentPage);

    List<StudentDTO> selectByStudentNameContains(String name);

    List<StudentDTO> selectByEntranceDateBetween(int startDate, int endDate);

    List<StudentDTO> selectByIdIn(List<String> idList);

    int updateAbsenceYnByIdIn(List<String> idList);

    List<StudentGradeDTO> selectGradeById(String id);
}
