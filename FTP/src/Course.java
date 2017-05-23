
public class Course {

	private String courseName;
	private String courseTeacher;
	
	public Course () {
		
	}
	public Course(String courseNmae,String courseTeacher){
		this.courseName=courseNmae;
		this.courseTeacher=courseTeacher;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	
	
}
