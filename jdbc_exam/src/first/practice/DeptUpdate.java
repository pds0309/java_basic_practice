package first.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptUpdate {

	public static void main(String[] args) {

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
			String sql ="update dept set dname = ?, loc=?  where deptno= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(3, 2);
			pstmt.setString(1, "包府");
			pstmt.setString(2, "力林");
			int num  = pstmt.executeUpdate();
			System.out.println("荐沥等 饭内靛 肮荐:"+ num);
			
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
		
		
		
	}//end main
}//end 