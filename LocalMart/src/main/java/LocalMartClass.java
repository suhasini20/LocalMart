

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalMartClass extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String grocery = req.getParameter("gtype");
		//String rice = req.getParameter("rtype");
		String basmathiRice = req.getParameter("btype");
		String basmathiQuantity = req.getParameter("basmathiQuantity");
		String price = req.getParameter("amount");

		SuperMartJdbcClass superMartData = new SuperMartJdbcClass();
		int results = superMartData.insertSuperMartData(grocery, basmathiRice, basmathiQuantity,price);

		PrintWriter writer = res.getWriter();
		writer.println(grocery);
        //writer.println(rice);
		writer.println(basmathiRice);
		writer.println(basmathiQuantity);
		writer.println(price);
		writer.println(results + "successfully inserted!!!!");
	}

}
