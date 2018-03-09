package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistService
 */
@WebServlet("/RegistService")
public class RegistService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String siteName = request.getParameter("siteName");
		String responsible = request.getParameter("responsible");
		String worker1 = request.getParameter("worker1");
		String worker2 = request.getParameter("worker2");
		String worker3 = request.getParameter("worker3");
		String worker4 = request.getParameter("worker4");
		String worker5 = request.getParameter("worker5");
		String worker6 = request.getParameter("worker6");
		String worker = worker1 + " " + worker2 + " " + worker3 + " " + worker4 + " " + worker5 + " " + worker6;
		String deadLineYear = request.getParameter("deadLineYear");
		String deadLineMonth = request.getParameter("deadLineMonth");
		String deadLineDay = request.getParameter("deadLineDay");
		String deadLine = deadLineYear + "-" + deadLineMonth + "-" + deadLineDay;
		String processName1 = request.getParameter("processName1");
		String startDateYear1 = request.getParameter("startDateYear1");
		String startDateMonth1 = request.getParameter("startDateMonth1");
		String startDateDay1 = request.getParameter("startDateDay1");
		String startDate1 = startDateYear1 + "-" + startDateMonth1 + "-" + startDateDay1;
		String endDateYear1 = request.getParameter("endDateYear1");
		String endDateMonth1 = request.getParameter("endDateMonth1");
		String endDateDay1 = request.getParameter("endDateDay1");
		String endDate1 = endDateYear1 + "-" + endDateMonth1 + "-" + endDateDay1;
		String processName2 = request.getParameter("processName2");
		String startDateYear2 = request.getParameter("startDateYear2");
		String startDateMonth2 = request.getParameter("startDateMonth2");
		String startDateDay2 = request.getParameter("startDateDay2");
		String startDate2 = startDateYear2 + "-" + startDateMonth2 + "-" + startDateDay2;
		String endDateYear2 = request.getParameter("endDateYear2");
		String endDateMonth2 = request.getParameter("endDateMonth2");
		String endDateDay2 = request.getParameter("endDateDay2");
		String endDate2 = endDateYear2 + "-" + endDateMonth2 + "-" + endDateDay2;
		String processName3 = request.getParameter("processName3");
		String startDateYear3 = request.getParameter("startDateYear3");
		String startDateMonth3 = request.getParameter("startDateMonth3");
		String startDateDay3 = request.getParameter("startDateDay3");
		String startDate3 = startDateYear3 + "-" + startDateMonth3 + "-" + startDateDay3;
		String endDateYear3 = request.getParameter("endDateYear3");
		String endDateMonth3 = request.getParameter("endDateMonth3");
		String endDateDay3 = request.getParameter("endDateDay3");
		String endDate3 = endDateYear3 + "-" + endDateMonth3 + "-" + endDateDay3;
		String processName4 = request.getParameter("processName4");
		String startDateYear4 = request.getParameter("startDateYear4");
		String startDateMonth4 = request.getParameter("startDateMonth4");
		String startDateDay4 = request.getParameter("startDateDay4");
		String startDate4 = startDateYear4 + "-" + startDateMonth4 + "-" + startDateDay4;
		String endDateYear4 = request.getParameter("endDateYear4");
		String endDateMonth4 = request.getParameter("endDateMonth4");
		String endDateDay4 = request.getParameter("endDateDay4");
		String endDate4 = endDateYear4 + "-" + endDateMonth4 + "-" + endDateDay4;
		String processName5 = request.getParameter("processName5");
		String startDateYear5 = request.getParameter("startDateYear5");
		String startDateMonth5 = request.getParameter("startDateMonth5");
		String startDateDay5 = request.getParameter("startDateDay5");
		String startDate5 = startDateYear5 + "-" + startDateMonth5 + "-" + startDateDay5;
		String endDateYear5 = request.getParameter("endDateYear5");
		String endDateMonth5 = request.getParameter("endDateMonth5");
		String endDateDay5 = request.getParameter("endDateDay5");
		String endDate5 = endDateYear5 + "-" + endDateMonth5 + "-" + endDateDay5;
		String processName6 = request.getParameter("processName6");
		String startDateYear6 = request.getParameter("startDateYear6");
		String startDateMonth6 = request.getParameter("startDateMonth6");
		String startDateDay6 = request.getParameter("startDateDay6");
		String startDate6 = startDateYear6 + "-" + startDateMonth6 + "-" + startDateDay6;
		String endDateYear6 = request.getParameter("endDateYear6");
		String endDateMonth6 = request.getParameter("endDateMonth6");
		String endDateDay6 = request.getParameter("endDateDay6");
		String endDate6 = endDateYear6 + "-" + endDateMonth6 + "-" + endDateDay6;

		// データベースへのアクセス開始
        Connection con = null;
        Statement stmt = null;

        try {
        	// JDBCドライバをロード
        	Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続するConnectionオブジェクトの取得
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sample", "root", "root");
            // データベース操作を行うためのStatementオブジェクトの取得
            stmt = con.createStatement();
	        //SQL文を挿入
	        String sql = "INSERT INTO site (siteName, responsible, worker, deadLine)" + "VALUES ('"+siteName+"', '"+responsible+"', '"+worker+"', '"+deadLine+"')";
	        String sql2 = "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName1+"', '"+startDate1+"', '"+endDate1+"')";
	        String sql3 = "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName2+"', '"+startDate2+"', '"+endDate2+"')";
	        String sql4 = "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName3+"', '"+startDate3+"', '"+endDate3+"')";
	        String sql5 = "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName4+"', '"+startDate4+"', '"+endDate4+"')";
	        String sql6 = "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName5+"', '"+startDate5+"', '"+endDate5+"')";
	        String sql7 = "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName6+"', '"+startDate6+"', '"+endDate6+"')";

	        // INSERT文を実行
            stmt.executeUpdate(sql);
            if(processName1 != null){
            	stmt.executeUpdate(sql2);
            }
            if(processName2 != null){
            	stmt.executeUpdate(sql3);
            }
            if(processName3 != null){
            	stmt.executeUpdate(sql4);
            }
            if(processName4 != null){
            	stmt.executeUpdate(sql5);
            }
            if(processName5 != null){
            	stmt.executeUpdate(sql6);
            }
            if(processName6 != null){
            	stmt.executeUpdate(sql7);
            }

            // DBへ登録後List.jspへ
            RequestDispatcher rd = request.getRequestDispatcher("./List.jsp");
            rd.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースとの接続をクローズ
            try { stmt.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
	}
}