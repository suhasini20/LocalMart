

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SuperMartJdbcClass {
	public int insertSuperMartData(String grocery,String basmathiRice, String basmathiQuantity, String price) {
		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/SuperMart", "root", "Harshini@26");
			java.util.Date utildate=new java.util.Date();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(utildate.getTime());
			PreparedStatement ps = con.prepareStatement("insert into SuperMart values(?,?,?,?,?)");
			ps.setString(1, grocery);
			//ps.setString(2, rice);
			ps.setString(2, basmathiRice);
			ps.setString(3, basmathiQuantity);
			ps.setString(4, price);
			ps.setTimestamp(5, sqlDate);
			result = ps.executeUpdate();
			System.out.println("rows affected" + result);
			con.close();

		} catch (Exception e) {
			System.out.println( e.getStackTrace()+"Exception occured");
		}

		return result;
	}

}
