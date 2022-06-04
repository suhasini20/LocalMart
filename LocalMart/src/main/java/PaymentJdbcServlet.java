import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentJdbcServlet extends HttpServlet {
      
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("service(--) of PaymentJdbcServlet");
		String select = req.getParameter("select");
		String carddata= req.getParameter("carddata");
		
		String onlinepay= req.getParameter("onlinepay");
		
		
		
		
		
		
		
	PrintWriter writer = res.getWriter();
	
	writer.println("<html>");
	writer.println("<head>");
	writer.println("</head>");
	writer.println("<body bgcolor='yellow'>");
		writer.println("</body>");
	writer.println("</html>");

	writer.println("select");
	writer.println("<br>");

	writer.println("carddata");
	writer.println("<br>");
	writer.println("onlinepay");
	writer.println("<br>");
	writer.println("<a href='CheckOutPage.java'>SelectPayment</a>");
	writer.println("<br>");

	writer.println("amount successfully debited from your account");
	
	
	
	}
}