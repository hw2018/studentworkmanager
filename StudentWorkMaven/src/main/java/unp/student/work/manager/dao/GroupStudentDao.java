package unp.student.work.manager.dao;
//µÇÂ¼ÑéÖ¤
public interface GroupStudentDao {
	boolean validate(String userName, String password);
	boolean studentquanxian(String userName,String password);
	boolean teacherquanxian(String userName,String password);
}
