import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPage extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String newpass = req.getParameter("newpass");
		String confirmNewPass = req.getParameter("confirmnewpass");
		
		ForgotJdbc forgot=new ForgotJdbc();
		
		int result = forgot.insertforgotDetails(newpass,confirmNewPass);

		PrintWriter writer = res.getWriter();
		writer.println(newpass);
		writer.println(confirmNewPass);

		
		writer.println(result+" row affceted");

	}

}
