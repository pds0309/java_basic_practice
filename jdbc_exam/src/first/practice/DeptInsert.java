package first.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptInsert {

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
			String sql ="insert into dept (deptno,dname,loc) values ( ?, ?, ? )"; //바인딩 변수
			pstmt = con.prepareStatement(sql);
			// ? 대신에 값 설정하기
			pstmt.setInt(1, 2);
			pstmt.setString(2, "개발");
			pstmt.setString(3, "서울");
			int num = pstmt.executeUpdate(); // 기본적으로 자동 commit 된다.
			System.out.println("저장된 레코드 개수:" + num);
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
}//end class