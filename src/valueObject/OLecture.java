package valueObject;

import model.MLecture;

public class OLecture {

	private String id;
	private String name;
	private String credit;
	private String time;
	private String professor;
	
	public void set(MLecture mLecture) {
		this.id = mLecture.getId();
		this.name = mLecture.getName();
		this.credit = mLecture.getCredit();
		this.time = mLecture.getTime();
		this.professor = mLecture.getProfessor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	
}