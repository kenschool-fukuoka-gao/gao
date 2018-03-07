package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IndexPSBean;

/**
 * Servlet implementation class SearchResultService
 */
@WebServlet("/SearchService")
public class SearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 画面から検索条件タイトルの取得
		String keyword = request.getParameter("keyword");

		//データベースへのアクセス開始
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<IndexPSBean> list = new ArrayList<IndexPSBean>();
		try{
	 		// JDBCドライバをロード
	 		Class.forName("com.mysql.jdbc.Driver");
	 		// データベースに接続するConnectionオブジェクトの取得
	 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			//SQLの作成
	 		String sql = "SELECT * FROM site INNER JOIN indexps USING (siteId) WHERE siteName LIKE '%"+keyword+"%'";

	 		// データベース操作を行うためのStatementオブジェクトの取得
	 		pst = con.prepareStatement(sql);
	 		rs = pst.executeQuery();

	 		while(rs.next()){
	 			IndexPSBean indexPSBean = new IndexPSBean();

	 			indexPSBean.setSiteId(rs.getString("siteId"));
	 			indexPSBean.setResponsible(rs.getString("responsible"));
	 			indexPSBean.setDateLine(rs.getString("dateLine"));
	 			list.add(indexPSBean);
	 		}



			}catch(Exception e){
				e.printStackTrace();
			}finally{
				// データベースとの接続をクローズ
				try{
					pst.close();
			 		con.close();
				}catch(Exception e){
				}
			}
		//インスタンスを代入後画面を遷移
		request.setAttribute("list", list);
		RequestDispatcher disp =
				request.getRequestDispatcher("Search.jsp");
		disp.forward(request, response);


	}
}
