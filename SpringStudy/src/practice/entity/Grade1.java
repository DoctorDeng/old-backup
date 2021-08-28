package practice.entity;

public class Grade1 {
	/**
	 * 年纪ID
	 */
	private int gradeId;
	/**
	 * 年纪姓名
	 */
	private String gradeName;
	
	public Grade1() {}
	
	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", gradeName=" + gradeName + "]";
	}

	public Grade1(int gradeId, String gradeName) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
}
