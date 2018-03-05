package model;

public class IndexPSBean {

	private int siteId;
	private String processId;
	private String responsible;
	private String dateLine;
	private String details;
	private String worker;
	private String startDate;

	public int getSiteId(){
		return siteId;
	}
	public void setSiteId(int siteId){
		this.siteId = siteId;
	}
	public String getProcessId(){
		return processId;
	}
	public void setProcessId(String processId){
		this.processId = processId;
	}
	public String getResponsible(){
		return responsible;
	}
	public void setResponsible(String responsible){
		this.responsible = responsible;
	}
	public String getDateLine(){
		return dateLine;
	}
	public void setDateLine(String dateLine){
		this.dateLine = dateLine;
	}
	public String getDetails(){
		return details;
	}
	public void setDetails(String details){
		this.details = details;
	}
	public String getWorker(){
		return worker;
	}
	public void setWorker(String worker){
		this.worker = worker;
	}
	public String getStartDate(){
		return startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

}
