package model;

public class EmployeeBean {

	private String employeeId;
	private String employeeName;
	private String kana;
	private String passWord;
	private String mailAddress;

	public String getEmployeeId(){
		return employeeId;
	}
	public void setEnployeeId(String employeeId){
		this.employeeId = employeeId;
	}
	public String getEmployeeName(){
		return employeeName;
	}
	public void setEnployeeName(String employeeName){
		this.employeeName = employeeName;
	}
	public String getKana(){
		return kana;
	}
	public void setKana(String kana){
		this.kana = kana;
	}
	public String getPassWord(){
		return passWord;
	}
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	public String getMailAddress(){
		return mailAddress;
	}
	public void setMailAddress(String mailAddress){
		this.mailAddress = mailAddress;
	}

}


