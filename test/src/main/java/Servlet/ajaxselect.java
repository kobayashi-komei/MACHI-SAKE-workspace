package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ajaxselect
 */
@WebServlet("/ajaxselect")
public class ajaxselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajaxselect() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGetin");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		String name = "";

		try {

			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			System.out.println("Connected....");

			System.out.println("つながった");
			String sql = "SELECT ID, NAME "
					+ "FROM test "
					+ "WHERE id=? "
					+ "";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString("NAME");
			} else {
				id = "-1";
				name = "noname";
			}
			Map<String, String> mapMsg = new HashMap<String, String>();
			mapMsg.put("name", name);
			mapMsg.put("id", id);
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = null;
			jsonStr = mapper.writeValueAsString(mapMsg);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(jsonStr);
			System.out.println(jsonStr);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
