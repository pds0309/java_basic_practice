package mvc.practice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import mvc.practice.model.DeptDAO;
import mvc.practice.model.DeptDTO;

/*
 *  CRUD�߻�޼ҵ� ����
 *  DB������ �ʿ��� Connection ���
 *  ���� CRUD �ȿ��� Connect and Close
 *  DAO ��  Connection ����
 *  �ٽ� - transaction ó��
 *     - ���񽺿��� �޼ҵ� ȣ���� �� �� Ʈ����ǿ� ���� �ϰ����� ���� Connection �� �ʿ���
 *     - 
 */
public class DeptServiceImpl implements DeptService {

	private final String driver = "oracle.jdbc.driver.OracleDriver";

	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String userId = "SCOTT";
	private final String passwd = "TIGER";

	public DeptServiceImpl() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DeptDTO> selectAll() {
		Connection con = null;
		List<DeptDTO> result = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			DeptDAO dao = new DeptDAO();
			result = dao.selectAll(con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public DeptDTO selectByDeptNo(int deptNo) {
		Connection con = null;
		DeptDTO dto = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			dto = new DeptDAO().selectByDeptno(con, deptNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dto;
	}

	
	@Override
	public int insert(DeptDTO dto) {

		int result = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			result = new DeptDAO().insert(con, dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@Override
	public int delete(int deptNo) {
		int result = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			result = new DeptDAO().delete(con, deptNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@Override
	public int update(DeptDTO dto) {
		int result = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userId, passwd);
			result = new DeptDAO().update(con, dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}
