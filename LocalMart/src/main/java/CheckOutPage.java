import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckOutPage extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("service(--) of CheckOutPage");

		CheckOutPageDetails d = new CheckOutPageDetails();
//		

		ResultSet rs = d.checkOutPageDetails();
		String  subtotal = d.getSubTotal();

		PrintWriter w = res.getWriter();

		
		res.setContentType("text/html");
		w.println("<html>");
		w.println("<head>");
		w.println("</head>");
		w.println("<body>");
		w.println("<h3>");
		w.println("1:checkout page");
		w.println("<h3>");

		w.println("<table border=2>");

		w.println("<tr>");
		w.println("<th>");
		w.println("gross_name");
		w.println("</th>");

		w.println("<th>");
		w.println("item_name");
		w.println("</th>");

		w.println("<th>");
		w.println("item_qty");
		w.println("</th>");

		w.println("<th>");
		w.println("item_cost");
		w.println("</th>");

		w.println("<th>");
		w.println("catr_date");
		w.println("</th>");

		try {

			while (rs.next()) {
				w.println("<tr>");
				w.println("<td>");
				w.println(rs.getString(1));
				w.println("</td>");

				w.println("<td>");
				w.println(rs.getString(2));
				w.println("</td>");

				w.println("<td>");
				w.println(rs.getInt(3));
				w.println("</td>");

				w.println("<td>");
				w.println(rs.getInt(4));
				w.println("</td>");

				w.println("<td>");
				w.println(rs.getDate(5));
				w.println("</td>");

				w.println("</tr>");
			}
		} catch (SQLException s) {
			System.out.println("exception occured");
			s.printStackTrace();
		}

			
		w.println("<tr>");

		w.println("<td colspan=5 >");
		w.println("subtotal="+subtotal);

		w.println("</td>");
		

		
		
		
		w.println("</tr>");
		w.println("</table >");
		w.println("<body>");
		w.println("<html>");

		w.println("<html>");
		w.println("<body>");
		w.println("<h3>2.shipping into:<h3>");
		w.println(" <form  action='payment' method='get'>");

		w.println("<table border=3>");

		w.println("<tr>");
		w.println("<td>");
		w.println("<select name='select' name='select' id='select'>");
		w.println("<option value='india'>india</option>");
		w.println("<option value='india'>usa</option>");
		w.println("<option value='india'>japan</option>");
		w.println("<option value='india'>south</option>");
		w.println("</select >");
		w.println("</td>");
		w.println("</tr >");
		w.println("</table >");

		w.println("<td>3.select payment method:<td>");
		w.println("</br>");

		w.println("<table border=3>");
		w.println("<tr>");
		w.println("<td>");
		w.println("<select ='select' value='carddata'  id='sub'>");
		w.println("<option value='card'>debit</option>");
		w.println("<option value='card'>credit</option>");
		w.println("<option value='card'>stored val card</option>");
		w.println("<option value='card'>charged card</option>");
		w.println("</select >");
		w.println("<td>");
		w.println("</tr>");
		w.println("</br>");

		w.println("<tr>");
		w.println("<td>");
		w.println("<select ='select' value='onlinepay'  id='select'>");
		w.println("<option value='card1'>paypal</option>");
		w.println("<option value='card1'>google pay</option>");
		w.println("<option value='card1'>phone pay </option>");
		w.println("<option value='card1'>paytm</option>");
		w.println("</select>");
		w.println("<td>");
		w.println("</tr >");
		w.println("</table>");

		w.println("<table bgcolor='red'>");
		w.println("<center>");
		w.println("<input type='submit' value='Pay Now' id='sub' >");
		w.println("<center>");

		w.println("</table >");
		w.println("</form>");
		w.println("</body>");
		w.println("</html>");
	}
}