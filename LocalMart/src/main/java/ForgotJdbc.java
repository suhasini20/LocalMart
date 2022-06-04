import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ForgotJdbc {
	int result = 0;

	public int insertforgotDetails(String newpass, String confirmNewPass) {
		String UPDATESQL = "update register set  password=?,where  RegisterUserName=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermart", "root", "Harshini@26");
			PreparedStatement ps = con.prepareStatement(UPDATESQL);

			ps.setString(1, newpass);
			ps.setString(2, confirmNewPass);
			result = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
