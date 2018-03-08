package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		String siteName = request.getParameter("siteName");
		String responsible = request.getParameter("responsible");
		String worker = request.getParameter("worker");
		String deadLine = request.getParameter("deadLineYear");
		String processName = request.getParameter("processName");
		String startDate = request.getParameter("startDateYear");
		String endDate = request.getParameter("endDateYear");
	        //SQL文
	        //メッセージ情報を挿入
	        String sql =
	                "INSERT INTO site values(?, ?, ?, ?)";
	        String sql2 =
	                "INSERT INTO process values(?, ?, ?)";
		// データベースへのアクセス開始
        Connection con = null;
        Connection con2 = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        try {
        	// JDBCドライバをロード
        	Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続するConnectionオブジェクトの取得
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sample/site",
                "root", "root");
            con2 = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sample/process",
                    "root", "root");
            // データベース操作を行うためのStatementオブジェクトの取得
            pstmt = con.prepareStatement(sql);
            /* データ追加１ */
            pstmt.setString(1, siteName);
            pstmt.setString(2, responsible);
            pstmt.setString(3, worker);
            pstmt.setString(4, deadLine);
            // INSERT文を実行
            rs = pstmt.executeQuery();

            // データベース操作を行うためのStatementオブジェクトの取得
            pstmt2 = con2.prepareStatement(sql2);
            /* データ追加２ */
            pstmt2.setString(1, processName);
            pstmt2.setString(2, startDate);
            pstmt2.setString(3, endDate);
            // INSERT文を実行
            rs = pstmt2.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースとの接続をクローズ
            try { rs.close(); } catch (Exception e) {}
            try { pstmt.close(); } catch (Exception e) {}
            try { pstmt2.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
            try { con2.close(); } catch (Exception e) {}
         // リストページへ遷移(リダイレクト).
    		response.sendRedirect("./List.jsp");
        }
    }
}