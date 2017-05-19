package unp.student.work.manager.domain;

/**
 * StudentQuanxian entity. @author MyEclipse Persistence Tools
 */

public class StudentQuanxian implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentid;
	private String quanxian;

	// Constructors

	/** default constructor */
	public StudentQuanxian() {
	}

	/** full constructor */
	public StudentQuanxian(String studentid, String quanxian) {
		this.studentid = studentid;
		this.quanxian = quanxian;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getQuanxian() {
		return this.quanxian;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}

}