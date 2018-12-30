package sdut.wsl.model;

public class SC {
	public SC()
	{
		super();
	}
	private String Sno;
	private String Cno;
	private int Grade;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public SC(String sno, String cno, int grade) {
		super();
		Sno = sno;
		Cno = cno;
		Grade = grade;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}	
}
