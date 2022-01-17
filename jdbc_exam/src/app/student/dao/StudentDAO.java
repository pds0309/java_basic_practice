package app.student.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.student.dto.Student;

public class StudentDAO {

	private static final String allQuery = "select student_no , student_name, "
			+ " rpad(substr(student_ssn,0,8), 14, '*'), substr(student_address ,0,10)||'...', "
			+ "to_char(entrance_date, 'yyyy/mm/dd'), absence_yn";

	public List<Student> selectAll(Connection con) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Student> studentResult = new ArrayList<>();
		String sql = allQuery + " from tb_student order by 1";
		System.out.println(sql);
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				studentResult.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6))

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentResult;
	};

	public List<Student> selectByName(Connection con, String name) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Student> studentResult = new ArrayList<>();
		String sql = allQuery + " from tb_student where student_name like ? order by 5 desc";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				studentResult.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6))

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentResult;
	}

	public List<Student> selectByDate(Connection con, int start, int end) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Student> studentResult = new ArrayList<>();
		String sql = allQuery + " from tb_student where to_char(entrance_date, 'yyyy') between ? and ? ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, end);
			rs = pst.executeQuery();
			while (rs.next()) {
				studentResult.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6))

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentResult;
	}

	public List<Student> selectByMulStudentNo(Connection con, String[] studentNoList) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Student> studentResult = new ArrayList<>();
		String sql = allQuery + " from tb_student where student_no in (" + getQuestion(studentNoList.length) + ")";
		try {
			pst = con.prepareStatement(sql);
			for (int i = 0; i < studentNoList.length; i++) {
				pst.setNString(i+1,  studentNoList[i]);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				studentResult.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6))

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentResult;
	}

	private String getQuestion(int size) {
		String result = "?";
		for (int i = 1; i < size; i++) {
			result += ",?";
		}
		return result;
	}

}
