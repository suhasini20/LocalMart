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

public class RegisterPage extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ruser = req.getParameter("ruser");
		String remail = req.getParameter("remail");
		String rusername = req.getParameter("rusername");
		String rpassword = req.getParameter("rpassword");
		String retypepassword = req.getParameter("retypepassword");

		RegisterJdbc register = new RegisterJdbc();
		int result = register.insertRegisterDetails(ruser, remail, rusername, rpassword, retypepassword);

		PrintWriter writer = res.getWriter();
		writer.println(ruser);
		writer.println(remail);
		writer.println(rusername);
		writer.println(rpassword);
		writer.println(retypepassword);

		writer.println(result + " row affceted");

	}

}
