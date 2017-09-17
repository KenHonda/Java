package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Mutter;
import model.User;

public class AccountDAO {

	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:file:C:/data/docoTsubu";
	private final String DB_USER = "";
	private final String DB_PASS = "";

	public boolean LoginExe(User user){
		Connection conn = null;
		String name = user.getName();
		String pass = user.getPass();
		String sqs = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "SELECT * FROM ACCOUNT WHERE NAME='" + name + "' AND PASS='" + pass + "'";
			PreparedStatement pSmt = conn.prepareStatement(sql);

			ResultSet rs = pSmt.executeQuery();
			while(rs.next()) {
			sqs = rs.getString("ID");
			}
			if(sqs != null) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean create(Mutter mutter) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());

			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
		return true;
	}
}
