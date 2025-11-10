package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneDAO {
	
	// 1.필드
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		// 2.메서드
		// DB드라이버 로딩 ~ DB연결 메서드
		public void getConn() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String password = "12345";
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		// 자원 반납 메서드
		public void getClose() {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if(conn!= null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		//전화번호 추가 기능
		public int insertPhoneNum(PhoneVO pvo) {
			getConn();
			String sql = "insert into phone values(?,?,?)";
			int row =0;
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, pvo.getName());
				psmt.setString(2, pvo.getPhoneNum());
				psmt.setInt(3, pvo.getAge());
				
				row=psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
			
			return row;
			
		}

		public ArrayList<PhoneVO> selectAll() {
			getConn();
			
			String sql = "select * from phone";
			ArrayList<PhoneVO> pvoList = new ArrayList<PhoneVO>();
			
			try {
				psmt = conn.prepareStatement(sql);
				
				rs =psmt.executeQuery();
				
				while(rs.next()) {
					String result_name = rs.getString("name");
					String result_phoneNum = rs.getString("phonenum");
					int result_age = rs.getInt("age");
					
					PhoneVO pvo = new PhoneVO(result_name, result_phoneNum, result_age);
				//return 키워드 : 메소드를 반환하는 키워드
					// 메소드, 반복문을 종료하는 기능 
					
					pvoList.add(pvo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
			
			return pvoList;
			
		}

		public int deleteNum(PhoneVO pvo) {
			
			getConn();
			
			String sql = "delete from phone where name = ? and phonenum = ?";
			int row = 0;
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, pvo.getName());
				psmt.setString(2, pvo.getPhoneNum());
				
				row = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
			
			return row;
		}
		
		
		
	
	

}
