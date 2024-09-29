package wk07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt;
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/./swadb";

	public void connect() {
	    try {
	        Class.forName(JDBC_DRIVER);
	        conn = DriverManager.getConnection(JDBC_URL, "swauser", "12345678");
	        System.out.println("DB 연결 성공");
	    } catch (Exception e) {
	    	System.out.println("DB 연결 실패");
	        e.printStackTrace();
	    }
	}

	public void close() {
		try {
			if (pstmt != null) {
				System.out.println("pstmt가 null");
	            pstmt.close();
	        }
	        if (conn != null) {
	        	System.out.println("conn이 null");
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void insert(Student s) {
		connect();
		String sql = "INSERT INTO student(username, univ, birth, email) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<Student> getAll() {
	    connect();
	    List<Student> students = new ArrayList<>();
	    ResultSet rs = null;  // ResultSet 선언
	    try {
	        pstmt = conn.prepareStatement("select * from student");
	        rs = pstmt.executeQuery();  // 쿼리 실행
	        while (rs.next()) {
	            Student s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setUsername(rs.getString("username"));
	            s.setUniv(rs.getString("univ"));
	            s.setBirth(rs.getDate("birth"));
	            s.setEmail(rs.getString("email"));
	            students.add(s);
	        }
	    } catch (Exception e) {
	        System.out.println("sql 조회오류");
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();  // ResultSet을 닫음
	            if (pstmt != null) pstmt.close();  // PreparedStatement 닫음
	            if (conn != null) conn.close();  // Connection 닫음
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return students;
	}
}
