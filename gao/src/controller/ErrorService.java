package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorService
 */
@WebServlet("/ErrorService")
public class ErrorService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エンコード設定.
    	request.setCharacterEncoding( "UTF-8" );
    	String UserID = request.getParameter("UserID");

    	String forward = null;
		if ("Login".equals(UserID)) {
			// ログイン画面の処理
			// Login.jspへフォワードする
			forward = "login.jsp";
		}else {
			// 不正なアクションの場合
			forward = doError(request, response, "不正なリクエストです");
		}
		// JSPへのフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
	protected String doError(HttpServletRequest request, HttpServletResponse response,
		String message) throws ServletException, IOException {
		request.setAttribute("message", message);
		// エラーを表示する
		return "error.jsp";
	}
}