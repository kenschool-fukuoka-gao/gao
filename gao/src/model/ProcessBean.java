package model;

public class ProcessBean {

	private int processId;
	private String processName;
	private String startDate;
	private String endDate;

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
