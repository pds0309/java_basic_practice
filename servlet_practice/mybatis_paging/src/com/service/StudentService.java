package com.service;

import com.dto.PageDTO;
import com.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> selectAll();

    PageDTO<StudentDTO> selectAllPageable(int recordAmountPerPage, int currentPage);

    PageDTO<StudentDTO> selectAllPageable2(int recordAmountPerPage, int currentPage);

}