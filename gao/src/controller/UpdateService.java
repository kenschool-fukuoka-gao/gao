package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  @author 大瀬戸、江頭
 * Servlet implementation class UpdateService
 */
@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateService() {
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
		String processName1 = request.getParameter("processName1");
		String startDateYear1 = request.getParameter("startDateYear1");
		String startDateMonth1 = request.getParameter("startDateMonth1");
		String startDateDay1 = request.getParameter("startDateDay1");
		String startDate1 = startDateYear1 + "-" + startDateMonth1 + "-" + startDateDay1;
		String endDateYear1 = request.getParameter("endDateYear1");
		String endDateMonth1 = request.getParameter("endDateMonth1");
		String endDateDay1 = request.getParameter("endDateDay1");
		String endDate1 = endDateYear1 + "-" + endDateMonth1 + "-" + endDateDay1;
		String processName2 = request.getParameter("processName2");
		String startDateYear2 = request.getParameter("startDateYear2");
		String startDateMonth2 = request.getParameter("startDateMonth2");
		String startDateDay2 = request.getParameter("startDateDay2");
		String startDate2 = startDateYear2 + "-" + startDateMonth2 + "-" + startDateDay2;
		String endDateYear2 = request.getParameter("endDateYear2");
		String endDateMonth2 = request.getParameter("endDateMonth2");
		String endDateDay2 = request.getParameter("endDateDay2");
		String endDate2 = endDateYear2 + "-" + endDateMonth2 + "-" + endDateDay2;
		String processName3 = request.getParameter("processName3");
		String startDateYear3 = request.getParameter("startDateYear3");
		String startDateMonth3 = request.getParameter("startDateMonth3");
		String startDateDay3 = request.getParameter("startDateDay3");
		String startDate3 = startDateYear3 + "-" + startDateMonth3 + "-" + startDateDay3;
		String endDateYear3 = request.getParameter("endDateYear3");
		String endDateMonth3 = request.getParameter("endDateMonth3");
		String endDateDay3 = request.getParameter("endDateDay3");
		String endDate3 = endDateYear3 + "-" + endDateMonth3 + "-" + endDateDay3;
		String processName4 = request.getParameter("processName4");
		String startDateYear4 = request.getParameter("startDateYear4");
		String startDateMonth4 = request.getParameter("startDateMonth4");
		String startDateDay4 = request.getParameter("startDateDay4");
		String startDate4 = startDateYear4 + "-" + startDateMonth4 + "-" + startDateDay4;
		String endDateYear4 = request.getParameter("endDateYear4");
		String endDateMonth4 = request.getParameter("endDateMonth4");
		String endDateDay4 = request.getParameter("endDateDay4");
		String endDate4 = endDateYear4 + "-" + endDateMonth4 + "-" + endDateDay4;
		String processName5 = request.getParameter("processName5");
		String startDateYear5 = request.getParameter("startDateYear5");
		String startDateMonth5 = request.getParameter("startDateMonth5");
		String startDateDay5 = request.getParameter("startDateDay5");
		String startDate5 = startDateYear5 + "-" + startDateMonth5 + "-" + startDateDay5;
		String endDateYear5 = request.getParameter("endDateYear5");
		String endDateMonth5 = request.getParameter("endDateMonth5");
		String endDateDay5 = request.getParameter("endDateDay5");
		String endDate5 = endDateYear5 + "-" + endDateMonth5 + "-" + endDateDay5;
		String processName6 = request.getParameter("processName6");
		String startDateYear6 = request.getParameter("startDateYear6");
		String startDateMonth6 = request.getParameter("startDateMonth6");
		String startDateDay6 = request.getParameter("startDateDay6");
		String startDate6 = startDateYear6 + "-" + startDateMonth6 + "-" + startDateDay6;
		String endDateYear6 = request.getParameter("endDateYear6");
		String endDateMonth6 = request.getParameter("endDateMonth6");
		String endDateDay6 = request.getParameter("endDateDay6");
		String endDate6 = endDateYear6 + "-" + endDateMonth6 + "-" + endDateDay6;
		String check = request.getParameter("check");
		java.sql.Date compDate= null;
		String sql = null;
		String siteId = request.getParameter("siteId");
		ResultSet rs = null;
		List<Integer> processId = new ArrayList<Integer>();
		int num = 1;

		if(check != null){
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			compDate = new java.sql.Date(date.getTime());
		}

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
            rs = stmt.executeQuery("select count(*) from process");
        	while (rs.next()) {
        		num = rs.getInt("count(*)")+1;
        	}
        	rs.close();
         // SQL()を実行して、結果を得る
    		rs = stmt.executeQuery("select processId from site LEFT OUTER JOIN site_pro USING (siteId) WHERE siteId = '"+siteId+"'");
    		while (rs.next()) {
    			processId.add(rs.getInt("processId"));
    		}
    		for(int i = processId.size();i < 6;i++){
    				processId.add(0);
    		}
	        // SQL文を挿入
            if(check == null){
            	sql = "UPDATE site SET siteName = '"+siteName+"', responsible = '"+responsible+"', worker = '"+worker+"', deadLine = '"+deadLine+"' WHERE siteId = '"+siteId+"'";
            }else{
            	sql = "UPDATE site SET siteName = '"+siteName+"', responsible = '"+responsible+"', worker = '"+worker+"', deadLine = '"+deadLine+"', compDate = '"+compDate+"' WHERE siteId = '"+siteId+"'";
            }
            String sql2 = "UPDATE process LEFT OUTER JOIN site_pro USING (processId) SET processName = '"+processName1+"', startDate = '"+startDate1+"', endDate = '"+endDate1+"' WHERE  siteId = '"+siteId+"' AND processId = '"+processId.get(0)+"'";
            String sql22 = "INSERT INTO process VALUES ('"+num+"', '"+processName1+"', '"+startDate1+"', '"+endDate1+"');";
            String sql222 = "INSERT INTO site_pro VALUES ('"+siteId+"', '"+num+"');";
            ++num;
            String sql3 = "UPDATE process LEFT OUTER JOIN site_pro USING (processId) SET processName = '"+processName2+"', startDate = '"+startDate2+"', endDate = '"+endDate2+"' WHERE siteId = '"+siteId+"' AND processId = '"+processId.get(1)+"'";
            String sql33 = "INSERT INTO process VALUES ('"+num+"', '"+processName2+"', '"+startDate2+"', '"+endDate2+"');";
            String sql333 = "INSERT INTO site_pro VALUES ('"+siteId+"', '"+num+"');";
            ++num;
            String sql4 = "UPDATE process LEFT OUTER JOIN site_pro USING (processId) SET processName = '"+processName3+"', startDate = '"+startDate3+"', endDate = '"+endDate3+"' WHERE siteId = '"+siteId+"' AND processId = '"+processId.get(2)+"'";
            String sql44 = "INSERT INTO process VALUES ('"+num+"', '"+processName3+"', '"+startDate3+"', '"+endDate3+"');";
            String sql444 = "INSERT INTO site_pro VALUES ('"+siteId+"', '"+num+"');";
            ++num;
            String sql5 = "UPDATE process LEFT OUTER JOIN site_pro USING (processId) SET processName = '"+processName4+"', startDate = '"+startDate4+"', endDate = '"+endDate4+"' WHERE siteId = '"+siteId+"' AND processId = '"+processId.get(3)+"'";
            String sql55 = "INSERT INTO process VALUES ('"+num+"', '"+processName4+"', '"+startDate4+"', '"+endDate4+"');";
            String sql555 = "INSERT INTO site_pro VALUES ('"+siteId+"', '"+num+"');";
            ++num;
            String sql6 = "UPDATE process LEFT OUTER JOIN site_pro USING (processId) SET processName = '"+processName5+"', startDate = '"+startDate5+"', endDate = '"+endDate5+"' WHERE siteId = '"+siteId+"' AND processId = '"+processId.get(4)+"'";
            String sql66 = "INSERT INTO process VALUES ('"+num+"', '"+processName5+"', '"+startDate5+"', '"+endDate5+"');";
            String sql666 = "INSERT INTO site_pro VALUES ('"+siteId+"', '"+num+"');";
            ++num;
            String sql7 = "UPDATE process LEFT OUTER JOIN site_pro USING (processId) SET processName = '"+processName6+"', startDate = '"+startDate6+"', endDate = '"+endDate6+"' WHERE siteId = '"+siteId+"' AND processId = '"+processId.get(5)+"'";
            String sql77 = "INSERT INTO process VALUES ('"+num+"', '"+processName6+"', '"+startDate6+"', '"+endDate6+"');";
            String sql777 = "INSERT INTO site_pro VALUES ('"+siteId+"', '"+num+"');";

	        // INSERT文を実行
            stmt.executeUpdate(sql);
            if(processName1 != null){
            	stmt.executeUpdate(sql2);
            }
            else if (processId.get(0) == null){
            	stmt.executeUpdate(sql22);
            	stmt.executeUpdate(sql222);
            }
            if(processName2 != null){
            	stmt.executeUpdate(sql3);
            }
            else if (processId.get(1) == null){
            	stmt.executeUpdate(sql33);
            	stmt.executeUpdate(sql333);
            }
            if(processName3 != null){
            	stmt.executeUpdate(sql4);
            }
            else if (processId.get(2) == null){
            	stmt.executeUpdate(sql44);
            	stmt.executeUpdate(sql444);
            }
            if(processName4 != null){
            	stmt.executeUpdate(sql5);
            }
            else if (processId.get(3) == null){
            	stmt.executeUpdate(sql55);
            	stmt.executeUpdate(sql555);
            }
            if(processName5 != null){
            	stmt.executeUpdate(sql6);
            }
            else if (processId.get(4) == null){
            	stmt.executeUpdate(sql66);
            	stmt.executeUpdate(sql666);
            }
            if(processName6 != null){
            	stmt.executeUpdate(sql7);
            }
            else if (processId.get(5) == null){
            	stmt.executeUpdate(sql77);
            	stmt.executeUpdate(sql777);
            }

            // DBへ更新後List.jspへ
            RequestDispatcher rd = request.getRequestDispatcher("./List.jsp");
            rd.forward(request, response);
        }catch (Exception e) {
        	e.printStackTrace();
        	response.sendRedirect("./Error.jsp");
        }finally {
            // データベースとの接続をクローズ
            try { stmt.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
	}
}