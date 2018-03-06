package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// エンコード設定.
    	request.setCharacterEncoding( "UTF-8" );

    	// ID を取得.
    	String userID = request.getParameter( "UserID" );
    	if ( null == userID ) {
    	userID = "";
    	}

    	// PASSWORD を取得.
    	String userPassword = request.getParameter( "Password" );
    	if ( null == userPassword ) {
    	userPassword = "";
    	}

    	// データベースへのアクセス開始
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
        	// JDBCドライバをロード
        	Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続するConnectionオブジェクトの取得
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sample",
                "root", "root");
            // データベース操作を行うためのStatementオブジェクトの取得
            stmt = con.createStatement();
            // SQL()を実行して、結果を得る
            rs = stmt.executeQuery(
              "select * from employee");
            while (rs.next()) {
            	// ログイン認証.
            	if (rs.getString("employeeId").equals(userID) && rs.getString("password").equals(userPassword)){
            		// リストページへ遷移(リダイレクト).
            		response.sendRedirect("./List.jsp");
            	}else{
            		count++;
            	}
            }
            if(count != 0){
        		// ログインフォームへ遷移(リダイレクト).
        		response.sendRedirect("./Login.jsp");
        	}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースとの接続をクローズ
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
    }
}