package com.dbconnect.purejdbc.service;

import com.dbconnect.purejdbc.dto.DeptDTO;

import java.util.List;

public interface DeptService {

    //select
    public List<DeptDTO> selectAll();

    //selectByDeptNo
    public DeptDTO selectByDeptNo(int deptNo);

    // insert
    public int insert(DeptDTO dto);

    // delete
    public int delete(int deptNo);

    // update
    public int update(DeptDTO dto);
}