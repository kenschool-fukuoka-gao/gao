package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	int num = 0;
    	/*
		if(request.getParameter("siteId") != null){
			num = Integer.parseInt(request.getParameter("siteId"));
		}
		*/
		//テスト
		num = 5;
		// エンコード設定.
    	request.setCharacterEncoding( "UTF-8" );
		//データベースへのアクセス開始
		Connection con = null;
		PreparedStatement pst = null;
		try{
	 		// JDBCドライバをロード
	 		Class.forName("com.mysql.jdbc.Driver");
	 		// データベースに接続するConnectionオブジェクトの取得
	 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			//SQLの作成
	 		String sql = "DELETE FROM site WHERE siteId = ?";
	 		// データベース操作を行うためのStatementオブジェクトの取得
	 		pst = con.prepareStatement(sql);
	 		pst.setInt(1,num);
	 		pst.executeUpdate();
	 		//画面遷移
	 		RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// データベースとの接続をクローズ
			try{
				pst.close();
			 	con.close();
			}catch(Exception e){ }
		}
	}
}