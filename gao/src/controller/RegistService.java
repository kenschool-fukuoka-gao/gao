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
		String processName = request.getParameter("processName");
		String startDateYear = request.getParameter("startDateYear");
		String startDateMonth = request.getParameter("startDateMonth");
		String startDateDay = request.getParameter("startDateDay");
		String startDate = startDateYear + "-" + startDateMonth + "-" + startDateDay;
		String endDateYear = request.getParameter("endDateYear");
		String endDateMonth = request.getParameter("endDateMonth");
		String endDateDay = request.getParameter("endDateDay");
		String endDate = endDateYear + "-" + endDateMonth + "-" + endDateDay;

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
	        //SQL文
	        //メッセージ情報を挿入
	        String sql =
	                "INSERT INTO site (siteName, responsible, worker, deadLine)" + "VALUES ('"+siteName+"', '"+responsible+"', '"+worker+"', '"+deadLine+"')";
	        String sql2 =
	                "INSERT INTO process (processName, startDate, endDate)" + "VALUES ('"+processName+"', '"+startDate+"', '"+endDate+"')";
	           // INSERT文を実行
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);

            // DBへ登録後、List.jspへ
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