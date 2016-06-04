package system.object;

import system.file.FileOperation;

public final class Student {
	private String id;
	private String name;
	private String sex;
	private String academy;
	private float score1;
	private float score2;
	private float score3;
	private float scoreAverage;
	
	public Student()
	{
		
	}
	
	public Student(
			String id,
			String name,
			String sex,
			String academy,
			float score1,
			float score2,
			float score3
			)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.academy = academy;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.scoreAverage = Float.parseFloat(String.format("%.2f", (this.score1 + this.score2 + this.score3) / 3.0));
	}
	
	public void setStudentInfo(
								String id,
								String name,
								String sex,
								String academy,
								float score1,
								float score2,
								float score3
								)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.academy = academy;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.scoreAverage = Float.parseFloat(String.format("%.2f", (this.score1 + this.score2 + this.score3) / 3.0));
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public float getScore1() {
		return score1;
	}

	public void setScore1(float score1) {
		this.score1 = score1;
	}

	public float getScore2() {
		return score2;
	}

	public void setScore2(float score2) {
		this.score2 = score2;
	}

	public float getScore3() {
		return score3;
	}

	public void setScore3(float score3) {
		this.score3 = score3;
	}

	public float getScoreAverage() {
		return scoreAverage;
	}

	public void setScoreAverage()
	{
		this.scoreAverage = Float.parseFloat(String.format("%.2f", (this.score1 + this.score2 + this.score3) / 3.0));
	}
	/*
	 * 输出学生的信息
	 */
	public void getOneStudentInfo()
	{
		System.out.println("\t" +
							this.id 		+ "\t" +
							this.name  		+ "\t" +
							this.sex 		+ "\t" +
							this.academy 	+ "\t" +
							this.score1 	+ "\t" +
							this.score2		+ "\t" +
							this.score3 	+ "\t" +
							this.scoreAverage 
							);
	}
	
	
	
}
