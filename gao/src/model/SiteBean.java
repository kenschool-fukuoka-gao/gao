package model;

public class SiteBean {

	private int siteId;
	private String siteName;
	private String responsible;
	private String worker;
	private String deadLine;
	//private String siteName;

	public int getSiteId(){
		return siteId;
	}
	public void setSiteId(int siteId){
		this.siteId = siteId;
	}
	public String getSiteName(){
		return siteName;
	}
	public void setSiteName(String siteName){
		this.siteName = siteName;
	}
	public String getResponsible(){
		return responsible;
	}
	public void setResponsible(String responsible){
		this.responsible = responsible;
	}
	public String getWorker(){
		return worker;
	}
	public void setWorker(String worker){
		this.worker = worker;
	}
	public String getDeadLine(){
		return deadLine;
	}
	public void setDeadLine(String deadLine){
		this.deadLine = deadLine;
	}

}
