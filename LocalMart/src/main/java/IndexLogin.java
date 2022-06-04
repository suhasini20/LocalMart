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

public class IndexLogin extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String user = req.getParameter("user");
		String password = req.getParameter("password");

//		LoginJdbc login = new LoginJdbc();
//		login.insertLoginDetails(user, password);

//		PrintWriter writer = res.getWriter();
//		writer.println(user);
//		writer.println(password);
//		writer.println(result+" row affceted");

	}

}
