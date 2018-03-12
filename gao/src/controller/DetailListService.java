package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エンコード設定.
    	request.setCharacterEncoding( "UTF-8" );

    	//画面から現場IDを取得する
    	int id = 0;
    	/*
		if(request.getParameter("siteId") != null){
			num = Integer.parseInt(request.getParameter("siteId"));
		}
		*/

		//テスト
		id = 1;
		// エンコード設定.

    	//	テスト表示用
    	response.setContentType("text/html:charset = utf-8");
    	PrintWriter out =response.getWriter();

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

	 		while(rs.next()){
	 			request.setAttribute("siteName", rs.getString("siteName"));
	 			request.setAttribute("responsible", rs.getString("responsible"));
	 			request.setAttribute("worker", rs.getString("worker"));
	 			request.setAttribute("compDate", rs.getString("compDate"));
	 		}
	 		//SQLの作成
	 		sql = "SELECT * FROM site_pro INNER JOIN process USING (processId) WHERE siteId =?";
	 		// データベース操作を行うためのStatementオブジェクトの取得
	 		pst = con.prepareStatement(sql);
	 		pst.setInt(1,id);
	 		rs=pst.executeQuery();

	 		ArrayList<ArrayList> list_id = new ArrayList<ArrayList>();
	 		ArrayList<Calendar> list_day = new ArrayList<Calendar>();
	 		while(rs.next()){
	 			String[] startDay = rs.getString("startDay").split("-",0);
	 			String[] endDay = rs.getString("endDay").split("-",0);
	 			Calendar cal_start = Calendar.getInstance();
	 			cal_start.set(Integer.parseInt(startDay[0]),Integer.parseInt(startDay[1]),Integer.parseInt(startDay[2]));
	 			list_day.add(cal_start);
	 			Calendar cal_end = Calendar.getInstance();
	 			cal_end.set(Integer.parseInt(endDay[0]),Integer.parseInt(endDay[1]),Integer.parseInt(endDay[2]));
	 			list_day.add(cal_end);
	 			list_id.add(list_day);
	 		}
	 		request.setAttribute("List", list_id);


	 		//画面遷移
	 		RequestDispatcher rd = request.getRequestDispatcher("./DetailList.jsp");
			rd.forward(request, response);

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

	}
}
