import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

public class LoginValidationJdbc {

	public void selectJdbc(String userName, String password , HttpServletResponse res) {

		try {
			PrintWriter writer = res.getWriter();

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermart", "root", "Harshini@26");
			String SELECT = "select * from register where RegisterUserName=" + userName + " and password=" + password
					+ "";

			Statement createStatement = con.createStatement();
		 int execute = createStatement.executeUpdate(SELECT);
			if (execute == 1) {
				writer.println("login successfully");
				
			} else {
				writer.println("login error");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
