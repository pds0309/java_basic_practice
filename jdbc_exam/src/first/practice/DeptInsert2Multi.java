package first.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptInsert2Multi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "SCOTT";
		String passwd = "TIGER";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	

		Connection con=null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql ="insert into dept (deptno,dname,loc) values ( ?, ?, ? )"; //���ε� ����
			pstmt = con.prepareStatement(sql);
			// ? ��ſ� �� �����ϱ�
			pstmt.setInt(1, 99);
			pstmt.setString(2, "����");
			pstmt.setString(3, "����");
			int num = pstmt.executeUpdate(); // �⺻������ �ڵ� commit �ȴ�.

			pstmt.setInt(1, 98);
			pstmt.setString(2, "����2");
			pstmt.setString(3, "����2");
			int num2 = pstmt.executeUpdate(); // �⺻������ �ڵ� commit �ȴ�.
			
			System.out.println("num����� ���ڵ� ����:" + num);
			System.out.println("num2����� ���ڵ� ����:" + num2);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
