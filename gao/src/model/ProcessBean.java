package model;
/**
 * @author 木下
 */
import java.io.Serializable;

public class ProcessBean implements Serializable{

	private int processId;
	private String processName;
	private String startDate;
	private String endDate;
	private int siteId;
	private String siteName;
	private String responsible;
	private String worker;
	private String deadLine;
	private String compDate;

	public ProcessBean(){}

	public String getCompDate() {
		return compDate;
	}
	public void setCompDate(String compDate) {
		this.compDate = compDate;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public int getProcessId(){
		return processId;
	}
	public void setProcessId(int processId){
		this.processId = processId;
	}
	public String getProcessName(){
		return processName;
	}
	public void setProcessName(String processName){
		this.processName = processName;
	}
	public String getStartDate(){
		return startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	public String getEndDate(){
		return endDate;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
}
