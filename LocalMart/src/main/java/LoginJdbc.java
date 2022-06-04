import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class LoginJdbc {


	public void insertLoginDetails(String user, String password) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermart", "root", "Harshini@26");

//			PreparedStatement ps = con
//					.prepareStatement("select * from register where RegisterUserName=? and password=?");
//			ps.setString(1, user);
//			ps.setString(2, password);
//			
			Statement stmt = con.createStatement();
			boolean result = stmt.execute("select * from register where RegisterUserName='"+user+"'");
//			boolean verify = ps.execute();
			if (result == true) {
				System.out.println("verified ");
			} else {
				System.out.println(" non verified");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	
		
	}

}
