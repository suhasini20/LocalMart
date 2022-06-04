import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RegisterJdbc {
	public int insertRegisterDetails(String ruser,String remail,String rusername,String rpassword,String retypepassword){
	
		int result=0;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermart", "root", "Harshini@26");
		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, ruser);
		ps.setString(2, remail);
		ps.setString(3, rusername);
		ps.setString(4, rpassword);
		ps.setString(5, retypepassword);
		
		 result = ps.executeUpdate();

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	 return result;
	}

}
