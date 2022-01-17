package first.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSelect {

	public static void main(String[] args) {

		//1. 4���� ���� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "SCOTT";
		String passwd = "TIGER";
		
		
		//2. ����̹� �ε� ==> "oracle.jdbc.driver.OracleDriver" ��ü�����ϴ� �۾��ǹ�
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//3. Connection �α�
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd); //����
			//4. SQL�� �ۼ�
			String sql ="select deptno as �μ���ȣ, dname, loc from dept";
			//5. SQL�� ������ �� ����� API
			pstmt = con.prepareStatement(sql); //����==>�����߻�
			//6. SQL�� ��û �� ��ȯ�� ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("�μ���ȣ");
				String dname = rs.getString("dname");
				String loc = rs.getNString(3);
				System.out.println(deptno+"\t"+dname+"\t"+loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//7. �ڿ��ݳ� ==> ����ߴ� ��ü�� �������� close�Ѵ�.
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end main
}//end class
