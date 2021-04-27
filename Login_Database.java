

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_Database
 */
@WebServlet("/Login_Database")
public class Login_Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Database() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		String name="";
		int pass=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FaceBookLogin","root","root");
			System.out.println("connction establish suceffully");
			String query="select * from FaceBookLogin.varify";
			pst=con.prepareStatement(query);
			rst=pst.executeQuery();
			while(rst.next()) {
				name=rst.getString("name");
				pass=rst.getInt("password");
			}
			
			System.out.println(name);
			System.out.println(pass);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		String name="";
		int pass=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FaceBookLogin","root","root");
			System.out.println("connction establish suceffully");
			String query="select * from FaceBookLogin.varify";
			pst=con.prepareStatement(query);
			rst=pst.executeQuery();
			while(rst.next()) {
				name=rst.getString("name");
				pass=rst.getInt("password");
			}
			
			System.out.println(name);
			System.out.println(pass);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("================================");

		
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String name1=request.getParameter("namee");
		String password=request.getParameter("passwordd");
	int  pass1=Integer.valueOf(password);
		 if(name.equals(name1) && pass1==pass) {
			 out.println("suceffully login procedd");
//		 RequestDispatcher dispacher= request.getRequestDispatcher(" ");
//		 dispacher.forward(request, response);
		 }else {
			 out.println("incorrect password");
			 RequestDispatcher dispacher= request.getRequestDispatcher("Login_Page.html");
			 dispacher.include(request, response);
		 }
		 
	}

}
