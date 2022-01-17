package first.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSelect {

	public static void main(String[] args) {

		//1. 4가지 정보 설정
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "SCOTT";
		String passwd = "TIGER";
		
		
		//2. 드라이버 로딩 ==> "oracle.jdbc.driver.OracleDriver" 객체생성하는 작업의미
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//3. Connection 맺기
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd); //성공
			//4. SQL문 작성
			String sql ="select deptno as 부서번호, dname, loc from dept";
			//5. SQL문 전송할 때 사용할 API
			pstmt = con.prepareStatement(sql); //실패==>에러발생
			//6. SQL문 요청 및 반환값 저장
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("부서번호");
				String dname = rs.getString("dname");
				String loc = rs.getNString(3);
				System.out.println(deptno+"\t"+dname+"\t"+loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//7. 자원반납 ==> 사용했던 객체의 역순으로 close한다.
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
