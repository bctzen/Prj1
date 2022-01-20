package customer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBcon;
import customer.vo.Notice;

public class NoticeDao {
	 
	public List<Notice> noticeSelectAll(String field, String query) throws Exception {
		//db접속
		Connection con = DBcon.getConnection();
		//실행
		//String sql = "SELECT * FROM notices order by to_number(seq) desc";
		String sql = "SELECT * FROM notices WHERE " + field + " LIKE ? ORDER BY to_number(seq) DESC";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + query + "%");
		//결과
		ResultSet rs = pstmt.executeQuery();
		
		//리스트에 Notice내용을 담기
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			Notice n = new Notice();
			n.setContent(rs.getString("content"));
			n.setHit(rs.getInt("hit"));
			n.setRegdate(rs.getDate("regdate"));
			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			
			list.add(n);
		}
		rs.close();
		pstmt.close();
		con.close();
		return list;
	}
	
	public int delete(String seq) throws Exception {
		String sql = "DELETE FROM notices WHERE seq = " + seq;
		
		//dbconnect
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";
		
		//실행
		Connection con = DriverManager.getConnection(url, user, pw);*/
		Connection con = DBcon.getConnection();
		Statement stmt = con.createStatement();
		
		int del = stmt.executeUpdate(sql);
		
		stmt.close();
		con.close();
		
		return del;
	}
	
	public int write(Notice n) throws Exception {
		//dbcon
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";
		
		Connection con = DriverManager.getConnection(url, user, pw);*/
		Connection con = DBcon.getConnection();
		String sql = "INSERT INTO notices VALUES("
				+ "(SELECT NVL(MAX(TO_NUMBER(seq)), 0) + 1 FROM notices)"
				+ ", ?, 'cj', sysdate, 0, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getContent());
		int af = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return af;
	}
	
	//변수로 수정내용받기
	public int update2(String s, String t, String c) throws Exception {
		
		String sql = "UPDATE notices SET title = ?, content = ? WHERE seq = ?";
		
		//dbconnect
		/*Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";

		Connection con = DriverManager.getConnection(url, user, pw);*/
		Connection con = DBcon.getConnection();
		//실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, t);
		pstmt.setString(2, c);
		pstmt.setString(3, s);
		
		int af = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return af;
	}
	
	//객체로 수정내용 받기
	public int update(Notice n) throws Exception {
		
		String sql = "UPDATE notices SET title = ?, content = ? WHERE seq = ?";
		
		/*//dbconnect
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";*/

		/*Connection con = DriverManager.getConnection(url, user, pw);*/
		Connection con = DBcon.getConnection();
		//실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getContent());
		pstmt.setString(3, n.getSeq());
		
		int af = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return af;
	}
	
	public Notice getNotice(String seq) throws Exception {
		
		String sql = "SELECT * FROM notices WHERE seq="+seq;

		/*//dbconnect
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";

		Connection con = DriverManager.getConnection(url, user, pw);*/
		Connection con = DBcon.getConnection();
		//실행
		Statement stmt = con.createStatement();

		//결과
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
//		Notice에 select 결과물 저장
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setWriter(rs.getString("writer"));
		n.setTitle(rs.getString("title"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		
		rs.close();
		stmt.close();
		con.close();
		
		return n;
	}
}
