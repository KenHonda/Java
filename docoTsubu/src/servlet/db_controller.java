package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class db_controller
 */
@WebServlet("/db_controller")
public class db_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection(
				"jdbc:h2:file:C:/data/docoTsubu","","");

		String sql = "CREATE TABLE MUTTER(ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(100) NOT NULL, TEXT VARCHAR(255) NOT NULL)";
		PreparedStatement pSmt = conn.prepareStatement(sql);
		pSmt.execute();


		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
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


}
