package sdut.wsl.model;

public class Course {
	public Course()
	{
		super();
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public Course(String cno, String cname, String cpno) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cpno = cpno;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpno() {
		return cpno;
	}
	public void setCpno(String cpno) {
		this.cpno = cpno;
	}
	private String cno;
	private String cname;
	private String cpno;
}
