package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author 幸田
 *			大瀬戸
 *			江頭
 * @version 1.0
 */
/**
 * Servlet implementation class DeleteService
 */
@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エンコード設定.
    	request.setCharacterEncoding( "UTF-8" );
    	//画面から現場IDを取得する
    	String siteId = request.getParameter("siteId");
		// エンコード設定.
    	request.setCharacterEncoding( "UTF-8" );
		//データベースへのアクセス開始
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
	 		// JDBCドライバをロード
	 		Class.forName("com.mysql.jdbc.Driver");
	 		// データベースに接続するConnectionオブジェクトの取得
	 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
	 		// データベース操作を行うためのStatementオブジェクトの取得
			stmt = con.createStatement();
			// SQL()を実行して、結果を得る
			rs = stmt.executeQuery("select siteId, processId from site left outer join site_pro using (siteId) left outer join process using (processId)");
			// 得られた結果をレコードごとに表示
			while (rs.next()) {
				if(siteId.equals(rs.getString("siteId"))){
				String sql = "DELETE FROM process WHERE processId = " + rs.getString("processId");
				pst2 = con.prepareStatement(sql);
		 		pst2.executeUpdate();
				}
			}
			//SQLの作成
	 		String sql = "DELETE FROM site WHERE siteId = " + siteId;
	 		// データベース操作を行うためのStatementオブジェクトの取得
	 		pst = con.prepareStatement(sql);
	 		pst.executeUpdate();
	 		//画面遷移
	 		RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("./Error.jsp");
		}finally{
			// データベースとの接続をクローズ
			try{
				pst.close();
			 	con.close();
			}catch(Exception e){ }
		}
	}
}