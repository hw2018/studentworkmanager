package unp.student.work.manager.dao;
import java.sql.SQLException;
import java.util.List;
import unp.student.work.manager.domain.DormInfo;

public interface DormInfoDao extends BaseDao<DormInfo> {
	List findByPage(int pageNo, int pageSize);
}
