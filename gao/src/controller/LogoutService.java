package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author 大瀬戸、江頭
 *
 * @version 1.0
 */
/**
 * Servlet implementation class LogoutService
 */
@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// セッション破棄.
			HttpSession session = request.getSession(true);
			session.invalidate();
			session = request.getSession(false);
			// ログインフォームへ遷移(リダイレクト).
			response.sendRedirect("./Login.jsp");
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("./Error.jsp");
		}
	}
}