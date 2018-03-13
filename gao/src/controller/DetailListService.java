package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProcessBean;

/**
 * Servlet implementation class DetailListService
 */
@WebServlet("/DetailListService")
public class DetailListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailListService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// エンコード設定.
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		// 画面から現場IDを取得する

		if (request.getParameter("siteId") != null) {
			id = Integer.parseInt(request.getParameter("siteId"));
		}
		//データベースへのアクセス開始
		Connection con = null;
		PreparedStatement pst = null;
		String sql = null;
		ResultSet rs = null;
		try{
	 		// JDBCドライバをロード
	 		Class.forName("com.mysql.jdbc.Driver");
	 		// データベースに接続するConnectionオブジェクトの取得
	 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			//SQLの作成
	 		sql = "SELECT * FROM site WHERE siteid = ?";
	 		// データベース操作を行うためのStatementオブジェクトの取得
	 		pst = con.prepareStatement(sql);
	 		pst.setInt(1,id);
	 		rs=pst.executeQuery();

			while (rs.next()) {
				request.setAttribute("siteName", rs.getString("siteName"));
				request.setAttribute("responsible", rs.getString("responsible"));
				request.setAttribute("deadLine", rs.getString("deadLine"));
				request.setAttribute("compDate", rs.getString("compDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データベースとの接続をクローズ
			try {
				pst.close();
				con.close();
			} catch (Exception e) {
			}
		}
		try {
			// JDBCドライバをロード
			Class.forName("com.mysql.jdbc.Driver");
			// データベースに接続するConnectionオブジェクトの取得
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");
			// SQLの作成
			sql = "SELECT * FROM site_pro INNER JOIN process USING (processId) WHERE siteId =?";
			// データベース操作を行うためのStatementオブジェクトの取得
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			ArrayList<ProcessBean> list = new ArrayList<ProcessBean>();
			while (rs.next()) {
				ProcessBean processBean = new ProcessBean();

				processBean.setProcessId(Integer.parseInt(rs.getString("processId")));
				processBean.setProcessName(rs.getString("processName"));
				processBean.setStartDate(rs.getString("startDate"));
				processBean.setEndDate(rs.getString("endDate"));
				list.add(processBean);
			}
			request.setAttribute("List", list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データベースとの接続をクローズ
			try {
				pst.close();
				con.close();
			} catch (Exception e) {
			}

		}
		// 画面遷移
		request.getRequestDispatcher("./DetailList.jsp")
		.forward(request, response);

	}
}
