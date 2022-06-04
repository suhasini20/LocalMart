
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc {
	static Connection c;

	public ResultSet Details() {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "Suhasri@20");

			PreparedStatement prepareStatement = c
					.prepareStatement("select * select sum(item_cost)  from cart12; ");

			java.util.Date date = new java.util.Date();
			java.sql.Date sqldate = new java.sql.Date(date.getTime());

			prepareStatement.setDate(1, sqldate);
			rs = prepareStatement.executeQuery();

		} catch (Exception e) {

			System.out.println("exception not occured ");
			e.printStackTrace();

		}

		return rs;
	}

}
