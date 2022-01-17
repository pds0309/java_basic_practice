package app.student.service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import app.student.dao.StudentDAO;
import app.student.dto.Student;

public class StudentServiceImpl implements StudentService {

	private final String driver = "oracle.jdbc.driver.OracleDriver";

	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String userId = "workshop";
	private final String passwd = "workshop";

	public StudentServiceImpl() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> selectAll() {
		Connection con = null;
		List<Student> studentResult = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			studentResult = new StudentDAO().selectAll(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentResult;
	}

	@Override
	public List<Student> selectByName(String name) {
		Connection con = null;
		List<Student> studentResult = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			studentResult = new StudentDAO().selectByName(con ,  name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentResult;
	}

	@Override
	public List<Student> selectByDate(int start, int end) {
		Connection con = null;
		List<Student> studentResult = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			studentResult = new StudentDAO().selectByDate(con , start , end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentResult;
	}

	@Override
	public List<Student> selectByMulStudentNo(String studentNos) {
		Connection con = null;
		List<Student> studentResult = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
		
			studentResult = new StudentDAO()
					.selectByMulStudentNo(con , 
							studentNos.split(","));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentResult;
	}

}
