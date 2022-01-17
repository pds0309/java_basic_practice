package app.student.dto;

public class Student {
	private String stuNo;
	private String departNo;
	private String stuName;
	private String stuSsn;
	private String stuAdress;
	private String entDate;
	private String absYn;
	private String coachProfessorNo;

	public Student(String stuNo, String stuName, String stuSsn, String stuAdress, String entDate,
			String absYn) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuSsn = stuSsn;
		this.stuAdress = stuAdress;
		this.entDate = entDate;
		this.absYn = absYn;
	}

	public Student() {
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getDepartNo() {
		return departNo;
	}

	public void setDepartNo(String departNo) {
		this.departNo = departNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSsn() {
		return stuSsn;
	}

	public void setStuSsn(String stuSsn) {
		this.stuSsn = stuSsn;
	}

	public String getStuAdress() {
		return stuAdress;
	}

	public void setStuAdress(String stuAdress) {
		this.stuAdress = stuAdress;
	}

	public String getEntDate() {
		return entDate;
	}

	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}

	public String getAbsYn() {
		return absYn;
	}

	public void setAbsYn(String absYn) {
		this.absYn = absYn;
	}

	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}

	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}

	@Override
	public String toString() {
		return stuNo  + " " + stuName + " " + stuSsn+ " " + getShortedAddress(stuAdress) + " "
				+ entDate + " " + absYn + " " + "\n";
	}

//	private String getBlindedSsn() {
//		return this.stuSsn.substring(0, 8).concat("******");
//	}
//
	private String getShortedAddress(String address) {
		if (address.equals("...") || address.equals("불 명...")) {
			return "*** 주소 미상 ***";
		}
		return address;
	}

//	private String getDateByFormat() {
//		return this.entDate.replace("-", "/").split(" ")[0];
//	}
//
//	private String adjIndentString(String str, int indentNum) {
//		if(str.length() < indentNum) {
//			for(int i = str.length(); i < indentNum; i++) {
//				str+="  ";
//			}
//		}
//		return str;
//	}

}
