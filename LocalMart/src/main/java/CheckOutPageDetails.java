import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.ParseConversionEvent;

public class CheckOutPageDetails {
	static Connection c;
	static {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermart", "root", "Harshini@26");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

	public ResultSet checkOutPageDetails() {
		ResultSet rs = null;

		try {
			
			

			PreparedStatement prepareStatement = c
					.prepareStatement("select * from cart12 where catr_date <= ? ORDER BY  gross_name asc  ");
			// PreparedStatement total = c.prepareStatement("select sum(item_cost) from
			// cart12");

			java.util.Date date = new java.util.Date();
			java.sql.Date sqldate = new java.sql.Date(date.getTime());

			prepareStatement.setDate(1, sqldate);
			rs = prepareStatement.executeQuery();
			// sum = total.executeQuery();

		} catch (Exception e) {

			System.out.println("exception not occured ");
			e.printStackTrace();

		}
		return rs;
	}

	public static String getSubTotal() {

		String total = null;
		Statement statement = null;

		try {

			statement = c.createStatement();
			ResultSet rs = statement.executeQuery("select sum(item_cost)*sum(item_qty) as total from cart12");
			while (rs.next()) {
				System.out.println("inside while loop");
				total = rs.getString(1);

			}
		} catch (Exception e) {
			System.out.println("inside exception loop");
			

		}

		return total;
	}
}

//	public static float getSubTotal() throws SQLException {
//		float add = 0;
//		PreparedStatement prepareStatement = c
//				.prepareStatement("select item_cost from cart12");
//		
//		 ResultSet rs = prepareStatement.executeQuery();
//		 while( rs .next()) {
//			 add=add+rs.getFloat("item_cost");
//			 
//		 }
//		 System.out.println(add);
//		
//		return add;
//		 
//		
//		
//		
//		
//		
//	}
//}