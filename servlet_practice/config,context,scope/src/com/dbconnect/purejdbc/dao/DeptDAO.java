package com.dbconnect.purejdbc.dao;

import com.dbconnect.purejdbc.dto.DeptDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {

    // select

    public List<DeptDTO> selectAll(Connection con) {
        List<DeptDTO> list = new ArrayList<>();
        String sql = "select * from dept";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                DeptDTO dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getNString(3));
                list.add(dto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public DeptDTO selectByDeptno(Connection con, int deptno) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from dept where deptno=?";
        DeptDTO dto = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, deptno);
            rs = pst.executeQuery();
            if(rs.next()) {
                dto = new DeptDTO(rs.getInt(1),rs.getString(2),rs.getNString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }

    public int insert(Connection con , DeptDTO dto) {
        int num = 0;
        PreparedStatement pst = null;
        String sql = "insert into dept values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, dto.getDeptNo());
            pst.setString(2, dto.getdName());
            pst.setString(3, dto.getLoc());
            num = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    public int delete(Connection con , int deptNo) {
        int num = 0;
        PreparedStatement pst = null;
        String sql = "delete from dept where deptno = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, deptNo);
            num = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }


    public int update(Connection con , DeptDTO dto) {
        int num = 0;
        PreparedStatement pst = null;
        String sql = "update dept set dname=?,loc=? where deptno=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getdName());
            pst.setNString(2, dto.getLoc());
            pst.setInt(3, dto.getDeptNo());
            num = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}