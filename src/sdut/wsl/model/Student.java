package sdut.wsl.model;

public class Student {
	public Student()
	{
		super();
	}
	public Student(String sno, String sname, String ssex, int sage, String sdept,String password) {
		super();
		Sno = sno;
		Sname = sname;
		Ssex = ssex;
		Sage = sage;
		Sdept = sdept;
		this.password=password;
		
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public int getSage() {
		return Sage;
	}
	public void setSage(int sage) {
		Sage = sage;
	}
	public String getSdept() {
		return Sdept;
	}
	public void setSdept(String sdept) {
		Sdept = sdept;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String Sno;
	private String Sname;
	private String Ssex;
	private int Sage;
	private String Sdept;
	private String password;

}
